package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CredentialValidator {

    public static boolean validateEmail(String email) {
        String emailPattern = "^[A-Za-z0-9._%+-]+\\.[A-Za-z0-9._%+-]+@university\\.com$";
        Pattern pattern = Pattern.compile(emailPattern);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static boolean validatePassword(String password) {
        String passwordPattern = "^[A-Z].{5,}[0-9]{3,}$";
        Pattern pattern = Pattern.compile(passwordPattern);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }
}