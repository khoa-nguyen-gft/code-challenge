package com.example.springBootExample;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.SocketException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.apache.commons.net.PrintCommandListener;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockftpserver.fake.FakeFtpServer;
import org.mockftpserver.fake.UserAccount;
import org.mockftpserver.fake.filesystem.DirectoryEntry;
import org.mockftpserver.fake.filesystem.FileEntry;
import org.mockftpserver.fake.filesystem.FileSystem;
import org.mockftpserver.fake.filesystem.UnixFakeFileSystem;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * tutorials-master\libraries\src\main\java\com\baeldung\ftp\FtpClient.java
 * tutorials-master\libraries\src\test\java\com\baeldung\ftp\FtpClientIntegrationTest.java
 * 
 * @author knguyen97
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootExampleApplicationTests {

	private FakeFtpServer fakeFtpServer;
	
	private FtpClient ftpClient;

	@Before
	public void setup() throws SocketException, IOException {
		fakeFtpServer = new FakeFtpServer();
		fakeFtpServer.addUserAccount(new UserAccount("user", "password", "/data"));
		FileSystem fileSystem = new UnixFakeFileSystem();
		fileSystem.add(new DirectoryEntry("/data"));
		fileSystem.add(new FileEntry("/data/foobar.txt", "abcdef 1234567890"));
		fakeFtpServer.setFileSystem(fileSystem);
		fakeFtpServer.setServerControlPort(0);

		fakeFtpServer.start();
		
		ftpClient = new FtpClient("localhost", fakeFtpServer.getServerControlPort(), "user", "password");
		ftpClient.open();
		
		//clean data
		new File("download.txt").delete();
	}

	@Test
	public void givenRemoteFile_whenDownloading_thenItIsOnTheLocalFileSystem() throws IOException {
		String ftpUrl = String.format("ftp://user:password@localhost:%d/foobar.txt",
				fakeFtpServer.getServerControlPort());

		URLConnection connection = (new URL(ftpUrl)).openConnection();
		InputStream inputStream = connection.getInputStream();
		Files.copy(inputStream, new File("download.txt").toPath());
		inputStream.close();
	}
	
	@Test
	public void givenRemoteFile_whenListingRemoteFiles_thenItIsContainedInList() throws IOException {
		Collection<String> files = ftpClient.listFile("");
		assertThat(files).contains("foobar.txt");		
	}
	
	
	@Test
	public void givenLocalFile_whenUploadingIt_thenItExistsOnRemoteLocation() 
	  throws URISyntaxException, IOException {
		File file = new File("data/foobar.txt");
		ftpClient.putFileToPath(file, "/buz.txt");
		assertThat(fakeFtpServer.getFileSystem().exists("/buz.txt")).isTrue();
	}
	
	@Test
	public void givenRemoteFile_whenDownloading_thenItIsOnTheLocalFilesystem() throws IOException {
		ftpClient.downloadFile("/data/foobar.txt", "downloaded_buz.txt");
		assertThat(new File("downloaded_buz.txt")).exists();
		
	}
	
	@After
	public void teardown() throws IOException {
		ftpClient.close();
		fakeFtpServer.stop();
	}
}

class FtpClient {
	private String server;
	private int port;
	private String user;
	private String password;
	private FTPClient ftp;
	
    FtpClient(String server, int port, String user, String password) {
        this.server = server;
        this.port = port;
        this.user = user;
        this.password = password;
    }
    
	public void putFileToPath(File file, String path) throws FileNotFoundException, IOException {
		ftp.storeFile(path, new FileInputStream(file));
	}

	public void downloadFile(String source, String destination) throws FileNotFoundException, IOException {
		ftp.retrieveFile(source, new FileOutputStream(destination));
	}

	public Collection<String> listFile(String path) throws IOException {
		FTPFile[] files = ftp.listFiles(path);
		return Arrays.stream(files).map(f -> f.getName()).collect(Collectors.toList());
		
		
	}

	void open() throws SocketException, IOException {
		ftp = new FTPClient();
		ftp.addProtocolCommandListener(new PrintCommandListener(new PrintWriter(System.out)));
		
		ftp.connect(server, port);
		int replyCode = ftp.getReplyCode();
		if (!FTPReply.isPositiveCompletion(replyCode)) {
			ftp.disconnect();
			throw new IOException("Exception in connecting to FTP Server");
		}
		
		ftp.login(user, password);
		
	}
	

	void close() throws IOException {
		ftp.disconnect();
	}
}
