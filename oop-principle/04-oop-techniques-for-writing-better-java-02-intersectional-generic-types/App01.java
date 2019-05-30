import java.util.List;

public class App01 {
    public static void main(String[] args) {

    }
}

interface Writer {
    public void write();
}

class WriterComposite<T extends Writer> implements Writer {
    private final List<T> writers;

    public WriterComposite(List<T> writers) {
        this.writers = writers;
    }

    @Override
    public void write() {
        for (Writer writer : this.writers) {
            writer.write();
        }
    }
}
