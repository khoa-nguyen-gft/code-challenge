public class App {
    public static void main(String[] args) {
    	
        Foo foo = param -> param + "method";
        System.out.println(foo.method("YES "));
        
        
        Foo fooDoNot = new Foo() {			
			@Override
			public String method(String str) {
				return str + "method";
			}
		};
		
		System.out.println(fooDoNot.method("DO NOT "));
    }
    

}

@FunctionalInterface
interface Foo {
    String method(String str);
}