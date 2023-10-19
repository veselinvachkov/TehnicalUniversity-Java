package TU_Java.week_2.project_2;

class Person {
    private String name;
    private String birthDate;

    public Person(String name, String birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    public Person() {

    }


    public String getName() {
        return name;
    }

    public String getBirthDate() {
        return birthDate;
    }
}
