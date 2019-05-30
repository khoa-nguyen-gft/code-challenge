import java.util.ArrayList;
import java.util.List;

public class AppBefore {
    public static void main(String args[]){
		GenericsTypeOld type = new GenericsTypeOld();
		type.set("Pankaj"); 
		String str = (String) type.get(); //type casting, error prone and can cause ClassCastException
		System.out.println(str);// null
	}
}

class GenericsTypeOld {

	private Object obj;
	public void set(Object obj) {
		this.obj =obj;
	}

	public Object get() {
		return obj;
	}

}
