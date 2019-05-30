

public class AppAfter {
    public static void main(String args[]){
		GenericsType<String> type = new GenericsType<String>();
		type.set("Pankaj"); 
		String str = (String) type.get(); //type casting, error prone and can cause ClassCastException
		System.out.println(str);// null
	}
}

class GenericsType <T> {

	private T obj;
	public void set(T obj) {
		this.obj = obj;
	}

	public T get() {
		return obj;
	}

}
