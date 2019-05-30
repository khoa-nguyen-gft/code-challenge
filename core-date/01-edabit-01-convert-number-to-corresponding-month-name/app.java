import java.util.ArrayList;
import java.util.Calendar;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Locale;

public class app {
    public static void main(String[] args) {
        System.out.println(monthName(1));
    }

    public static String monthName(int num){
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.MONTH, num -1);
        return calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault());
    }

}
