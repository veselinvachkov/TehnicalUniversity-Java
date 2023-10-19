package TU_Java.week_2.project_1;

import TU_Java.week_2.project_1.Teacher;
import TU_Java.week_2.project_1.Course;

public class Test {
    public static void main(String[] args) {

        Course mathCourse = new Course("Math");

        Teacher mathTeacher = new Teacher("Veselin Vachkov", 19, mathCourse);

        System.out.println("Teacher: " + mathTeacher.getName());
        System.out.println("Age: " + mathTeacher.getAge());
        System.out.println("Course name: " + mathTeacher.getCourse().getCourseName());
    }
}