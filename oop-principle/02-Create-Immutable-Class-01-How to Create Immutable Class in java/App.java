import java.util.HashMap;
import java.util.Map;

public class App {
    public static void main(String[] args) {
        HashMap<String, String> h1 = new HashMap<String, String>();
        h1.put("1", "first");
        h1.put("2", "second");
        h1.put("3", "third");
        FinalClassExample ce = new FinalClassExample(1, "original", h1);
        System.out.println(ce.toString());

        System.out.println("change the value of h1: ");
        h1.put("3", "third");
        System.out.println(ce);

        ce.getTestMap().put("4", "forth");
        System.out.println("change the value of testMap: ");
        System.out.println(ce);

    }
}

final class FinalClassExample {
    private final int id;
    private final String name;
    private final Map<String, String> testMap;

    // public FinalClassExample(int id, String name, Map<String, String> testMap) {
    // super();
    // this.id = id;
    // this.name = name;
    // this.testMap = testMap;
    // }

    public FinalClassExample(int id, String name, HashMap<String, String> inputMap) {
        System.out.println("Performing Deep Copy for Object initialization");

        this.id = id;
        this.name = name;

        testMap = new HashMap<String, String>();
        for (String key : inputMap.keySet()) {
            testMap.put(key, inputMap.get(key));
        }
    }

    @Override
    public String toString() {
        return "FinalClassExample [id=" + id + ", name=" + name + ", testMap=" + testMap + "]";
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public HashMap<String, String> getTestMap() {
        HashMap<String, String> tempTestMap = new HashMap<String, String>();
        for (String key : testMap.keySet()) {
            tempTestMap.put(key, testMap.get(key));
        }

        return tempTestMap;
    }

}