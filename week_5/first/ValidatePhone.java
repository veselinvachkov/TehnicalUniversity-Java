package Vesko.first;

interface ValidatePhone {
    static void validatePhoneNumber(String phoneNumber) throws WrongPhoneNumberException {
        if (!phoneNumber.matches("\\d+")) {
            throw new WrongPhoneNumberException("Invalid phone number format");
        }
    }
}
