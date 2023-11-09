package TU_Java.week_4;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class User implements ValidatePhone{
    private String username;
    private String password;
    private String phoneNumber;

    public User(String username, String password, String phoneNumber) throws WrongUserException, WrongPhoneNumberException {
        setUsername(username);
        setPassword(password);
        setPhoneNumber(phoneNumber);
    }

    public User() {}


    public void setUsername(String username) throws WrongUserException {
        if (username.length() < 3 || username.length() > 15) {
            throw new WrongUserException();
        }

        String pattern = "[0-9a-z_-]+";
        Pattern regexPattern = Pattern.compile(pattern);
        Matcher matcher = regexPattern.matcher(username);

        if (!matcher.matches()) {
            throw new WrongUserException();
        }

        this.username = username;
    }

    public void setPhoneNumber(String phoneNumber) throws WrongPhoneNumberException {
        phoneNumber = phoneNumber.replaceAll("[^0-9]", "");

        if (phoneNumber.length() != 10) {
            throw new WrongPhoneNumberException();
        }


        this.phoneNumber = phoneNumber;
    }

    public void setPassword(String password) {
        String pattern = "[a-zA-Z]+";
        Pattern regexPattern = Pattern.compile(pattern);
        Matcher matcher = regexPattern.matcher(username);

        if (username.length() < 11) {
            throw new IllegalArgumentException("The length of the password must be over 11 symbols!");
        }

        if (!matcher.matches()) {
            throw new IllegalArgumentException("Invalid password format. It should only contain letters a-z.");
        }

        this.password = password;
    }


    public String getPassword() {
        return password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getUsername() {
        return username;
    }


}
