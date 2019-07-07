package com.example.springBootExample;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;

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
 * @author knguyen97
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootExampleApplicationTests {

	private FakeFtpServer fakeFtpServer;
	
	@Before
	public void setup() {
		fakeFtpServer = new FakeFtpServer();
		fakeFtpServer.addUserAccount(new UserAccount("user","password", "/data"));
		FileSystem fileSystem = new UnixFakeFileSystem();
		fileSystem.add(new DirectoryEntry("/data"));
		fileSystem.add(new FileEntry("/data/foobar.txt", "abcdef 1234567890"));
		fakeFtpServer.setFileSystem(fileSystem);
        fakeFtpServer.setServerControlPort(0);

        fakeFtpServer.start();
	}


	@Test
	public void givenRemoteFile_whenDownloading_thenItIsOnTheLocalFileSystem() throws IOException, IOException {
		String ftpUrl = String.format("ftp://user:password@localhost:%d/foobar.txt", fakeFtpServer.getServerControlPort());
		
		URLConnection connection = (new URL(ftpUrl)).openConnection();
		InputStream inputStream = connection.getInputStream();
		Files.copy(inputStream, new File("download.txt").toPath());
		inputStream.close();
	}
}
