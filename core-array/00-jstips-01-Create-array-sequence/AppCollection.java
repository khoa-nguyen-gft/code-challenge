import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AppCollection{
    public static void main(String[] args) {
        
        System.out.println(sequence(13));
    }

    public static List<Integer> sequence(int num){
        List<Integer> result = IntStream.rangeClosed(1, num).boxed()
        	 .collect(Collectors.toList());
        
        //System.out.println("result" + result);
        return result;
    }
}