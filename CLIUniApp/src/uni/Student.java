package uni;

import utils.CredentialValidator;
import utils.Input;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Student implements Serializable {

    private String studentId;
    private String name;
    private String email;
    private String password;
    private List<Subject> subjects;
    private String courseResult;

    private String courseGrade;

    private float courseMarks;

    public Student() {
        this.subjects = new ArrayList<>();
    }


    public String getCourseResult() {
        return courseResult;
    }

    public void setCourseResult(String courseResult) {
        this.courseResult = courseResult;
    }


    public void changePassword() {
        System.out.println("Updating Password");
        String nPassword = readPassword("New");
        String cPassword = readPassword("Confirm");
        while (!nPassword.equals(cPassword)) {
            System.out.println("Password does not match - try again");
            cPassword = readPassword("Confirm");
        }
        this.password = nPassword;

    }

    public String readPassword(String action) {
        System.out.print(action + " Password: ");
        String password = Input.readString();
        while(!CredentialValidator.validatePassword(password)){
            System.out.println("Incorrect Password Format");
            password = Input.readString();
        }
        return password;
    }


    public boolean isEnrollmentBelowLimit() {
        return this.getSubjects().size() < 4;
    }

    public void enrollSubject() {
        if (isEnrollmentBelowLimit()) {
            Subject subject = new Subject();
            System.out.println("Enrolling in Subject - " + subject.getSubjectID());
            this.subjects.add(subject);
            System.out.println("You are now enrolled in " + this.getSubjects().size()
                    + " out of 4 subjects");
            calculateCourseResult();
            calculateCourseGrade();
        } else {
            System.out.println("Students are allowed to enroll in 4 subjects only");
        }
    }

    public void removeSubject(String subjectID) {
        int index = -1;
        for (int i = 0; i < this.subjects.size(); i++) {
            if (this.subjects.get(i).getSubjectID().equals(subjectID)) {
                index = i;
                break;
            }
        }
        if (index == -1){
            System.out.println("Please enter valid Subject Id");}
        else{
            System.out.println("Dropping Subject - " + subjectID);
            this.subjects.remove(index);}
        System.out.println("You are now enrolled in " + this.getSubjects().size()
                + " out of 4 subjects");
        calculateCourseResult();
        calculateCourseGrade();
    }

    public void removeSubject() {
        if(this.subjects.isEmpty()){
            System.out.println("Before dropping subjects, Please enroll into the subjects");
            return;
        }
        System.out.print("Remove Subject by ID: ");
        String subId = Input.readString();
        removeSubject(subId);
    }

    public void showSubjects() {
        if ((this.getSubjects() == null) || (this.getSubjects().isEmpty()))
            System.out.println("You have enrolled in 0 subjects");
        else
            this.getSubjects().forEach(System.out::println);
    }

    public void calculateCourseResult() {
        int totalMarks = 0;
        for (Subject s : this.subjects) {
            totalMarks += s.getMarks();
        }

        float averageMarks = totalMarks * 1f / this.subjects.size();
        this.courseMarks = averageMarks;
        if (averageMarks < 50) {
            this.courseResult = "FAIL";
        } else {
            this.courseResult = "PASS";
        }
    }


    public void calculateCourseGrade() {
        if (this.courseMarks < 50) {
            this.courseGrade = "Z";
        } else if (this.courseMarks < 65) {
            this.courseGrade = "P";
        } else if (this.courseMarks < 75) {
            this.courseGrade = "C";
        } else if (this.courseMarks < 85) {
            this.courseGrade = "D";
        } else {
            this.courseGrade = "HD";
        }
    }
    private char readSubMenuChoice() {
        System.out.print("Student Course Menu (c/e/r/s/x)");
        return Input.readCharacter();
    }



    public void studentSubMenu() {
        System.out.println(this.name + " The Student Course System : ");
        char c;
        while ((c = readSubMenuChoice()) != 'x') {
            switch (c) {
                case 'c':
                    changePassword();
                    break;
                case 'e':
                    enrollSubject();
                    break;
                case 'r':
                    removeSubject();
                    break;
                case 's':
                    showSubjects();
                    break;
                default:
                    subMenuHelp();
                    break;
            }
        }
        System.out.println("Back to Main Menu");
    }

    private void subMenuHelp() {
        System.out.println("Student Course Menu Options");
        System.out.println("c = change password");
        System.out.println("e = enroll");
        System.out.println("r = remove");
        System.out.println("s = show");
        System.out.println("x = exit");
    }


    @Override
    public String toString() {
        return "Student{" +
                "studentId='" + studentId + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", subjects=" + subjects +
                ", courseResult=" + courseResult +
                ", courseGrade=" + courseGrade +
                ", courseMarks=" + courseMarks +
                '}';
    }

    public String getcourseGrade() {
        return courseGrade;
    }

    public void setcourseGrade(String courseGrade) {
        this.courseGrade = courseGrade;
    }

    public float getcourseMarks() {
        return courseMarks;
    }

    public void setcourseMarks(float courseMarks) {
        this.courseMarks = courseMarks;
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
