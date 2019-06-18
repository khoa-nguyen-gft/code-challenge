import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {
    public static void main(String[] arg) {
        Integer ar1[] = { 1, 12, 15, 26, 38, 50 };
        Integer ar2[] = { 2, 13, 17, 30, 45 };
        System.out.println(MedianTwoArray(ar1, ar2));
    }

    public static int MedianTwoArray(Integer a1[], Integer a2[]) {
        Integer result = 0;
        List list = new ArrayList<Integer>();
        if (a1[a1.length - 1] < a2[0]) {
            list = Stream.concat(Stream.of(a1), Stream.of(a2)).collect(Collectors.toList());
        }

        if (a1[0] > a2[a2.length - 1]) {
            list = Stream.concat(Stream.of(a2), Stream.of(a1)).collect(Collectors.toList());
        }

        if (list.isEmpty()) {
            list = Stream.concat(Stream.of(a1), Stream.of(a2)).sorted().collect(Collectors.toList());
        }

        int position = (int) (list.size() % 2 == 0 ? list.size() / 2 - 1 : Math.floor(list.size() / 2));
        result = (Integer) list.get(position);
        System.out.println(list);
        return result;
    }
}
