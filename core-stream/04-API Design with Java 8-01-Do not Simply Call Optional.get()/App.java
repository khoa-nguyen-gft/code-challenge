import java.util.Optional;

public class App {
    public static void main(String[] args) {

        // MUST DO
        Optional<String> comment = Optional.of("ABC");
        String s = comment.map(c -> "MUST DO :" + c).orElse("");
        System.out.println(s);

        // DO NOT
        System.out.println("DO NOT :" + comment.get());
    }
}