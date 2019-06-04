import java.util.Optional;

import javax.swing.text.Segment;

import com.sun.javafx.scene.paint.GradientUtils.Point;

public class App {
    public static void main(String[] args) {

        // MUST DO
        Optional<String> comment = Optional.of("ABC");
        String s = comment.map(c -> "MUST DO :" + c).orElse("");
        System.out.println(s);

        // DO NOT
        System.out.println("DO NOT :" + comment.get());
    }

    // MUST DO
    public void addToSegment(Segment segment, Point point) {
        Object.requireNotNull(segment);
        Object.requireNotNull(point);
        segment.add(point);
    }

    //DON’T DO THIS
    public void doesNotToSegment(Segment segment, Point point) {
        segment.add(point);
    }


}
