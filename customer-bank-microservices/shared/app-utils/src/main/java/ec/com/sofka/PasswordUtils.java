package ec.com.sofka;


import org.mindrot.jbcrypt.BCrypt;

public class PasswordUtils {

    public static String encryptPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt(10));
    }

}