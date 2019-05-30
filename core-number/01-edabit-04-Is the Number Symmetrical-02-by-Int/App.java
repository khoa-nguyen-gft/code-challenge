public class App {
	public static void main(String[] args) {
		System.out.println(isSymmetrical(7227));// true
		System.out.println(isSymmetrical(12567));//  false
		System.out.println(isSymmetrical(44444444));// true
		System.out.println(isSymmetrical(9939));//  false
		System.out.println(isSymmetrical(1112111));//  true
	}

	private static boolean isSymmetrical(int i) {
		System.out.println(i);

		int last_digit = 0;
		int reversedNum = 0;
		
		while (i != 0) {
			last_digit = i % 10;
			reversedNum = reversedNum * 10 + last_digit;
			System.out.println(reversedNum);
			i = i /10;
		}		
		return false;
	}
}
