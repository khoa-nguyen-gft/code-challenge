import java.util.HashMap;
import java.util.Map;

public class AppBefore {
    public static void main(String[] arg) {
        System.out.println(isIsomorphic("egg", "add")); // true
        System.out.println(isIsomorphic("foo", "bar")); // false
        System.out.println(isIsomorphic("paper", "title")); // true

    }

    public static boolean isIsomorphic(String s, String t) {
        Map<String, String> map = new HashMap<String, String>();
        boolean flag = false;
        if (s.length() != t.length()) {
            return flag;
        }

        String[] sSplit = s.split("");
        String[] tSplit = t.split("");

        for (int i = 0; i < sSplit.length; i++) {
            if (map.get(sSplit[i]) == null)
                map.put(sSplit[i], tSplit[i]);
            else {
                if (!map.get(sSplit[i]).equals(tSplit[i])) {
                    return flag;
                }
            }
        }

        flag = true;

        return flag;
    }
}
