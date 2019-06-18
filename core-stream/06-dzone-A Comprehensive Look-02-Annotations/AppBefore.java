import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@interface Profile{
    String value();
}

@Retention(RetentionPolicy.RUNTIME)
@interface Profiles{
    Profile[] value();
}

@Profiles({
            @Profile("DEV"),
            @Profile("PRO")
})
public class AppBefore {
    public static void main(String[] arg) {
        Profile[] values = AppBefore.class.getAnnotation(Profiles.class).value();
        for (Profile profile : values) {
            System.out.println(profile.value());
        }
    }
}
