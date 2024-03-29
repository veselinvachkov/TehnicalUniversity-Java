package TU_Java.Exam;

import java.util.ArrayList;
import java.util.List;

public class Student extends User
{
    private List<Grade> grades;

    public Student(String facultyNumber, String EGN)
    {
        super(facultyNumber, EGN);
        grades = new ArrayList<>();
    }

    @Override
    public UserType getUserType()
    {
        return UserType.STUDENT;
    }

    public List<Grade> getGrades()
    {
        return grades;
    }

    @Override
    public String toString()
    {
        return "Student{" +
                "grades=" + grades +
                "} " + super.toString();
    }
}
