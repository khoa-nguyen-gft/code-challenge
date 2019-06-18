import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//Given [1,3],[2,6],[8,10],[15,18],
//return [1,6],[8,10],[15,18].

public class AppBefore {
    public static void main(String[] arg) {
        ArrayList<Interval> listInterval = new ArrayList<Interval>();
        listInterval.add(new Interval(1, 3));
        listInterval.add(new Interval(15, 18));
        listInterval.add(new Interval(2, 6));
        listInterval.add(new Interval(8, 10));
        listInterval.add(new Interval(7, 16));

        System.out.println(merge(listInterval));
    }

    public static List<Interval> merge(List<Interval> input){
        List<Interval> result = new ArrayList<Interval>();
        Comparator<Interval> comparator = Comparator.comparing(Interval::getStart);
        Collections.sort(input, comparator);


        if (input == null || input.size() ==1) {
            return input;
        }

        Interval t = input.get(0);

        for (int i = 1; i < input.size(); i++) {
            if (t.getEnd() > input.get(i).getStart()) {
                t = new Interval(t.getStart(), input.get(i).getEnd());
            } else {
                result.add(t);
                t = input.get(i);
            }

        }

        result.add(t);

        return result;
    }
}


class Interval {
    private int start;
    private int end;

    @Override
    public String toString() {
        return "Interval [start=" + start + ", end=" + end + "]";
    }

    public Interval(int start, int end) {
        super();
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

}