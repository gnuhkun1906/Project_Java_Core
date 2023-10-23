package config;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validate {
    public  static boolean checkValidateFullName(String fullName){
        Pattern pattern=Pattern.compile("^[a-z0-9._-]{8,15}$");
        Matcher matcher=pattern.matcher(fullName);
        return matcher.matches();
    }
    public static boolean checkValidateEmail(String email){
        Pattern pattern=Pattern.compile("^(.+)@(\\S+)$");
        Matcher matcher= pattern.matcher(email);
        return matcher.matches();
    }
    public  static boolean checkValidatePassword(String password){
        Pattern pattern=Pattern.compile("^[a-z0-9._-]{6,15}$");
        Matcher matcher=pattern.matcher(password);
        return matcher.matches();
    }
}
