public class App {
    public static void main(String[] args) {
        Foo foo = param -> param + "method";
        String str = add(foo, "start ");
        System.out.println(str);
    }

    public static String add(Foo foo, String str) {
        return foo.method(str);
    }
}

@FunctionalInterface
interface Foo {
    String method(String str);
}