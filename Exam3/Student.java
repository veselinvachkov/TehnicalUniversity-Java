package TU_Java.Exam3;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Student implements Serializable {
    private String egn;
    private String facultyNumber;

    public Student(String egn, String facultyNumber) throws StudentException {
        validateEgn(egn);
        validateFacultyNumber(facultyNumber);
        this.egn = egn;
        this.facultyNumber = facultyNumber;
    }

    private void validateEgn(String egn) throws StudentException {
        Pattern egnPattern = Pattern.compile("\\d{10}");
        if (!egnPattern.matcher(egn).matches()) {
            throw new StudentException("Invalid EGN format");
        }
    }

    private void validateFacultyNumber(String facultyNumber) throws StudentException {
        Pattern facultyNumberPattern = Pattern.compile("\\d{9}");
        if (!facultyNumberPattern.matcher(facultyNumber).matches()) {
            throw new StudentException("Invalid faculty number format");
        }
    }
}
