import java.util.ArrayList;
import java.util.List;

public class AppAfter{
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        
        list.add("abc");
        //list.add(new Integer(5));
        
        //java.lang.ClassCastException: java.lang.Integer cannot be cast to java.lang.String
        for (Object object : list) {
			String str = (String) object;
			System.out.println(str);
		}
    }

}