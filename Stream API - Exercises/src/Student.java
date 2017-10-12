import java.util.Collections;
import java.util.List;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class Student {
    String facultyNumber;
    String firstName;
    String lastName;
    String email;
    int age;
    int group;
    List<Integer> grades;
    String phone;

    Student(String facultyNumber, String firstName, String lastName, String email, int age, int group, List<Integer> grades, String phone) {
        this.setFacultyNumber(facultyNumber);
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setAge(age);
        this.setEmail(email);
        this.setGrades(grades);
        this.setGroup(group);
        this.setPhone(phone);
    }

    public String getYear() {
        return this.facultyNumber.substring(this.facultyNumber.length() - 2);
    }

    public String getFacultyNumber() {
        return facultyNumber;
    }

    private void setFacultyNumber(String facultyNumber) {
        this.facultyNumber = facultyNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public List<Integer> getGrades() {
        return grades;
    }

    public void setGrades(List<Integer> grades) {
        this.grades = grades;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return this.firstName + " " + this.lastName;// + " " + getForEachedGrades();
    }

    private String getForEachedGrades() {
        StringBuilder gradesBuilder = new StringBuilder();
        Collections.sort(this.grades);

        for (int i = 0; i < this.grades.size(); i++) {
            gradesBuilder.append(this.grades.get(i));
            gradesBuilder.append(" ");
        }
        return gradesBuilder.toString();
    }
}
