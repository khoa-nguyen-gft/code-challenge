
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

//public class App {
//    public static void main(String[] args) {
//
//    }
//}

class Program {
    public static boolean isPrefix(String word, String prefix) {
        return word.startsWith(prefix.substring(0, prefix.length() - 1));
    }

    public static boolean isSuffix(String word, String suffix) {
        return word.endsWith(suffix.substring(1, suffix.length()));
    }
}

public class App {

    @Test
    public void test1() {
        assertThat(Program.isPrefix("automation", "auto-"), is(true));
    }

    @Test
    public void test2() {
        assertThat(Program.isPrefix("superfluous", "super-"), is(true));
    }

    @Test
    public void test3() {
        assertThat(Program.isPrefix("oration", "mega-"), is(false));
    }

    @Test
    public void test4() {
        assertThat(Program.isPrefix("retrospect", "sub-"), is(false));
    }

    @Test
    public void test5() {
        assertThat(Program.isSuffix("arachnophobia", "-phobia"), is(true));
    }

    @Test
    public void test6() {
        assertThat(Program.isSuffix("rhinoplasty", "-plasty"), is(true));
    }

    @Test
    public void test7() {
        assertThat(Program.isSuffix("movement", "-scope"), is(false));
    }

    @Test
    public void test8() {
        assertThat(Program.isSuffix("vocation", "-logy"), is(false));
    }
}