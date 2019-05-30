public class AppBefore {
    public static void main(String[] args) {
        System.out.println(NumberUtil.Max(4, 5));
    }
}


class NumberUtil {
    public static int Max(int a, int b){
        return a > b ? a : b;
    }
}