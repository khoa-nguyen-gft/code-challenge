public class AppAfter {
    public static void main(String[] args) {
        System.out.println(new Max(10, 5).intValue());
    }
}

interface Number {
    public int intValue();

}

class Max implements Number {
    private int a;
    private int b;

    public Max(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public int intValue() {
        return this.a > this.b ? this.a : this.b;
    }
}