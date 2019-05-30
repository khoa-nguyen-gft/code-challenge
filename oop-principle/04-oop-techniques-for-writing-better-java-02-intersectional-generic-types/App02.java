import java.util.List;

public class App02 {
    public static void main(String[] args) {

    }
}

interface Writer {
    public void write();
}

interface Reader {
    public void read();
}

interface ReaderWriter extends Reader, Writer {

}

class ReaderWriterComposite<T extends ReaderWriter> implements ReaderWriter {

    private List<T> readerWriters;

    public ReaderWriterComposite(List<T> readerWriters) {
        this.readerWriters = readerWriters;
    }

    @Override
    public void read() {
        for (Reader t : readerWriters) {
            t.read();
        }
    }

    @Override
    public void write() {
        for (Writer t : readerWriters) {
            t.write();
        }
    }

}
