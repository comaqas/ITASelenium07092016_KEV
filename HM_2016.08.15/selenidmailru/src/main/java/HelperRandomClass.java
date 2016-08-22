import java.util.UUID;

/**
 * Created by Lenovo on 8/17/2016.
 */
public class HelperRandomClass {
    public static String getRandomString() {
        return UUID.randomUUID().toString().replaceAll("-", "").substring(20);
    }
}
