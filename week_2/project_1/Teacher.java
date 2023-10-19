package TU_Java.week_2.project_1;

class Teacher extends Person {
    private Course course;

    public Teacher(String name, int age, Course course) {
        super(name, age);
        this.course = course;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}