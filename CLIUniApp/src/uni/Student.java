package uni;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import utils.Input;

public class Student implements Serializable {

    private Set<String> unqiueIdValidation = new HashSet<>();
    private String studentId;
    private String name;
    private String email;
    private String password;
    private List<Subject> subjects;
    private char courseResult;

    public Student() {
        this.studentId = generateStudentId();
        this.subjects = new ArrayList<>();
    }

    private String generateStudentId() {
        String id = generateId();
        while (unqiueIdValidation.contains(id)) {
            id = generateId();
        }
        unqiueIdValidation.add(id);
        return id;
    }

    public char getCourseResult() {
        return courseResult;
    }

    public void setCourseResult(char courseResult) {
        this.courseResult = courseResult;
    }

    public String generateId() {
        int id = new Random().nextInt(1000000);
        String studentID = Integer.toString(id);
        while (studentID.length() < 6) {
            studentID = "0" + studentID;
        }
        return studentID;

    }

    public void changePassword() {
        
        this.password = readPassword();
    }

    private String readPassword() {
        System.out.println("Enter the Passowrd");
        return Input.readString();
    }

    public void enrollSubject() {
        this.subjects.add(new Subject());
        calculateResult();
    }

    public void removeSubject(String subjectID) {
        int index = -1;
        for (int i = 0; i < this.subjects.size(); i++) {
            if (this.subjects.get(i).getSubjectID().equals(subjectID)) {
                index = i;
                break;
            }
        }
        this.subjects.remove(index);
        calculateResult();
    }

    public void calculateResult() {
        int totalMarks = 0;
        for (Subject s : this.subjects) {
            totalMarks += s.getMarks();
        }
        float averageMarks = totalMarks * 1f / this.subjects.size();
        if (averageMarks < 50) {
            this.courseResult = 'F';
        } else {
            this.courseResult = 'P';
        }
    }

    private char readChoice() {
        System.out.println("Student Course Menu (c/e/r/s/x)");
        return Input.readCharacter();
    }

    public void studentMenu() {
        System.out.println(this.name + " The Student Course System : ");
        char c;
        while ((c = readChoice()) != 'x') {
            switch (c) {
                case 'c':
                    changePassword();
                    break;
                case 'e':
                    withdraw();
                    break;
                case 'r':
                    transfer();
                    break;
                case 's':
                    show();
                    break;
                default:
                    help();
                    break;
            }
        }
        System.out.println("Back to Bank menu");
    }

    private void help() {
        System.out.println("Student Course Menu Options");
        System.out.println("c = change password");
        System.out.println("e = enroll");
        System.out.println("r = remove");
        System.out.println("s = show");
        System.out.println("x = exit");
    }

    @Override
    public String toString() {
        return "Student [studentId=" + studentId + ", name=" + name + ", email=" + email + ", password=" + password
                + ", subjects=" + subjects + "]";
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

}
