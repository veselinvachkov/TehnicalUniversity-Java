package Vesko.first;

public class Provider implements ValidatePhone {
    private String name;
    private String phoneNumber;

    public Provider(String name, String phoneNumber) throws WrongPhoneNumberException {
        this.name = name;
        setPhoneNumber(phoneNumber);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) throws WrongPhoneNumberException {
        ValidatePhone.validatePhoneNumber(phoneNumber);
        this.phoneNumber = phoneNumber;
    }
}
