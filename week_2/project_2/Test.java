package TU_Java.week_2.project_2;

public class Test {
    public static void main(String[] args) {

        Student student = new Student("121222025", 4.20, 5.10, 6.00);
        System.out.println(student.getFacultyNumber());
        System.out.println(student.getPikGrade());
        System.out.println(student.getPpeGrade());
        System.out.println(student.getTeGrade());
        student.changeGrades(3.20, 2.80, 5.30);
        System.out.println();
        System.out.println(student.getFacultyNumber());
        System.out.println(student.getPikGrade());
        System.out.println(student.getPpeGrade());
        System.out.println(student.getTeGrade());

    }
}
