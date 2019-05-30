public class App {
    public static void main(String[] args) {
        Age age = new Age();
        age.setDay(1);
        age.setMonth(1);
        age.setYear(1992);
        ImmutableStudent student = new ImmutableStudent(1, "Alex", age);
        System.out.println("Alex age year before modification = " + student.getAge().getYear());
        student.getAge().setYear(1993);
        System.out.println("Alex age year after modification = " + student.getAge().getYear());
    }
}

final class ImmutableStudent {
    private final int id;
    private final String name;
    private final Age age;

    public ImmutableStudent(int id, String name, Age age) {
        super();
        this.id = id;
        this.name = name;
        this.age = new Age(age.getDay(), age.getMonth(), age.getYear());
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Age getAge() {
        Age clone = new Age(age.getDay(), age.getMonth(), age.getYear());
        return clone;
    }

}

class Age {
    private int day;
    private int month;
    private int year;

    public Age() {
        super();
    }

    public Age(int day, int month, int year) {
        super();
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

}