import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class App{
    public static void main(String[] args) {
        findLargestNums(new Integer[][] {{4, 2, 7, 1}, {20, 70, 40, 90}, {1, 2, 0}});// {7, 90, 2}

        findLargestNums(new Integer[][]{{-34, -54, -74}, {-32, -2, -65}, {-54, 7, -43}});// {-34, -2, 7}

        findLargestNums(new Double[][] {{0.4321, 0.7634, 0.652},
        {1.324, 9.32, 2.5423, 6.4314}, 
        {9.0, 3.0, 6.0, 3.0}});        //  {0.7634, 9.32, 9}
    }

	@SuppressWarnings("unchecked")
	private static <E> void findLargestNums(E[][] arr) {
		List<E> result = new ArrayList<E>();
		for (E[] integers : arr) {
			result.add(Stream.of(integers).max((Comparator<? super E>) Comparator.naturalOrder()).get());
		}		
		System.out.println(result);
		
	}



}