package TU_Java.week_4;

public class UserManagement extends User implements ValidatePhone{
    private User[] users;
    private int userCount;

    public UserManagement() throws WrongPhoneNumberException, WrongUserException {
        super();
    }

    public void register(String username, String password, String phoneNumber) throws WrongPhoneNumberException, WrongUserException {
        for (User user : users) {
            if (user != null && user.getUsername().equals(username)) {
                System.out.println("Username already in use!");
                return;
            }
        }

        users[userCount] = new User(username, password, phoneNumber);
        userCount++;
        System.out.println("Registration success!");
    }

    public boolean login(String username, String password, String phoneNumber) {
        for (User user : users) {
            if (user != null && user.getUsername().equals(username) && user.getPassword().equals(password) && user.getPhoneNumber().equals(phoneNumber)) {
                System.out.println("login success!");
                return true;
            }
        }
        System.out.println("Login failed!");
        return false;
    }
}