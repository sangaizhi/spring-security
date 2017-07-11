import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author sangaizhi
 * @date 2017/7/11
 */
public class Test {

    /**
     * @param args
     */
    public static void main(String[] args) {
        String password = "123456";
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        System.out.println(passwordEncoder.encode(password));
    }

}
