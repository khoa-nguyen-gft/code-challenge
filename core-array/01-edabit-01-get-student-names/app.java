import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class app {
    private static List<Student> students = null;
    public static void main(String[] args) {
        students = init();
        List<String>  names = students.stream()
                        .map(student -> student.getName())
                        .collect(Collectors.toList());
        System.out.println(names);
    }

    public static List<Student> init(){
        List<Student> students = new ArrayList<Student>();
        students.add(new Student("Steve"));
        students.add(new Student("Mike"));
        students.add(new Student("John"));

        return students;

    }
}

class Student {
    private String name;

    public Student(String name){
        this.name = name;
    }
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }


}