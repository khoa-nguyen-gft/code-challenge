public class App{
    public static void main(String[] args) {
    System.out.printf("Max of %d, %d and %d is %d\n\n", 
    3, 4, 5, maximum( 3, 4, 5 ));

     System.out.printf("Max of %.1f,%.1f and %.1f is %.1f\n\n",
        6.6, 8.8, 7.7, maximum( 6.6, 8.8, 7.7 ));

     System.out.printf("Max of %s, %s and %s is %s\n","pear",
        "apple", "orange", maximum("pear", "apple", "orange"));
    }

	private static <T extends Comparable<T>> T maximum (T i, T j, T k) {
		T max = i;
		
		if (j.compareTo(max) > 0) {
			max = j;
		}
		
		if (k.compareTo(max) > 0) {
			max = k;
		}
		return max;
	}


}