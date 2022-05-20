public class Student extends Human {
    String university;
    String faculty;
    String speciality;


    public Student(String firstName, String lastName, String patronymic, int age, Gender gender, String university, String faculty, String speciality) {
        super(firstName, lastName, patronymic, age, gender);
        this.university = university;
        this.faculty = faculty;
        this.speciality = speciality;
    }
}
