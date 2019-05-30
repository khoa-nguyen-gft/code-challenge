import java.io.Console;

public class AppBefore {
    public static void main(String[] args) {

    }
}

interface Manuscript {
    void print(Console console);
}

interface interScript extends Manuscript {
    void submit(Conference conf);
}

class Conference {

}