package TU_Java.week_2.project_2;

class Student extends Person {
    private String facultyNumber;
    private double pikGrade;
    private double teGrade;
    private double ppeGrade;

    public Student() {
        super();
        this.facultyNumber = facultyNumber;
        this.pikGrade = pikGrade;
        this.teGrade = teGrade;
        this.ppeGrade = ppeGrade;
    }

    public Student(String name, String birthDate) {
        super(name, birthDate);
    }

    public Student(String s, double v, double v1, double v2) {
        this.facultyNumber = s;
        this.pikGrade = v;
        this.teGrade = v1;
        this.ppeGrade = v2;
    }


    public String getFacultyNumber() {
        return facultyNumber;
    }

    public double getPikGrade() {
        return pikGrade;
    }

    public double getTeGrade() {
        return teGrade;
    }

    public double getPpeGrade() {
        return ppeGrade;
    }

    public void setPikGrade(double pikGrade) {
        this.pikGrade = pikGrade;
    }

    public void setTeGrade(double teGrade) {
        this.teGrade = teGrade;
    }

    public void setPpeGrade(double ppeGrade) {
        this.ppeGrade = ppeGrade;
    }

    public void setFacultyNumber(String facultyNumber) {
        this.facultyNumber = facultyNumber;
    }

    public void changeGrades(double pikGrade, double teGrade, double ppeGrade) {
        this.pikGrade = pikGrade;
        this.teGrade = teGrade;
        this.ppeGrade = ppeGrade;
    }

}
