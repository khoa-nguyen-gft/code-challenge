public class App {
	public static void main(String[] args) {
		System.out.println(isSymmetrical(7227));// true
		System.out.println(isSymmetrical(12567));//  false
		System.out.println(isSymmetrical(44444444));// true
		System.out.println(isSymmetrical(9939));//  false
		System.out.println(isSymmetrical(1112111));//  true
	}

	private static boolean isSymmetrical(int i) {
		String strNum = (new StringBuilder(String.valueOf(i))).reverse().toString();		
		int reverValue = Integer.valueOf(strNum).intValue();
		
		if (i == reverValue)
			return true;
		return false;
	}

}
