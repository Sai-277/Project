package uni;

import java.util.Random;

public class Subject {

    private String subjectID;
    private int marks;
    private String grade;

    public Subject() {
        this.subjectID = generateSubjectId();
        assignMarks();
        assignGrade();

    }

    private String generateSubjectId() {
        int id = new Random().nextInt(1000);
        String studentId = Integer.toString(id);
        while (studentId.length() < 3) {
            studentId = "0" + studentId;
        }
        return studentId;
    }

    public void assignMarks() {
        int id = new Random().nextInt(101 - 25) + 25;
        this.marks = id;
    }

    public void assignGrade() {
        if (this.marks < 50) {
            this.grade = "Z";
        } else if (this.marks < 65) {
            this.grade = "P";
        } else if (this.marks < 75) {
            this.grade = "C";
        } else if (this.marks < 85) {
            this.grade = "D";
        } else {
            this.grade = "HD";
        }
    }

   

    @Override
    public String toString() {
        //return "Subject [subjectID=" + subjectID + ", marks=" + marks + ", grade=" + grade + "]";
         return "[ Subject::"+subjectID+" -- mark = "+marks+" -- grade = "+grade+"]";
    }

    public String getSubjectID() {
        return subjectID;
    }

    public void setSubjectID(String subjectID) {
        this.subjectID = subjectID;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

}
