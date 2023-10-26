package uni;

import utils.Input;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Admin {

    public void adminMenu(){
        char c;
        while ((c = readMainMenuChoice()) != 'x') {
            switch (c) {
                case 'c':
                    clearDatabase();
                    break;
                case 'g':
                    gradeGrouping();
                    break;
                case 'p':
                    partition();
                    break;
                case 'r':
                    removeStudentById();
                    break;
                case 's':
                    studentList();
                    break;
                default:
                    menuHelp();
                    break;
            }
        }
    }

    private void clearDatabase() {
        System.out.println("Clearing students database");
        System.out.print("Are you sure you want to clear the database (Y) ES/ (N) O: ");
        char confirmation = Input.readCharacter();
        if(confirmation == 'Y'){
            University.studentList.clear();
            Database.write(University.studentList);
        }

    }

    private void removeStudentById() {
        System.out.println("Remove by ID: ");
        String id = Input.readString();
        int index = -1;
        for(int i=0;i<University.studentList.size();i++){
            if(University.studentList.get(i).getStudentId().equals(id)){
                index = i;
                break;
            }
        }
        if(index == -1){
            System.out.println("Student "+id+" does not exist");
        } else{
            System.out.println("Removing Student "+id+" Account");
            University.studentList.remove(index);
            Database.write(University.studentList);
        }

    }

    private void partition() {
        System.out.println("PASS/FAIL Partition");
        List<Student> passList = new ArrayList<>();
        List<Student> failList = new ArrayList<>();
        for (Student st : University.studentList) {
            if ("PASS".equals(st.getCourseResult())) {
                passList.add(st);
            } else if("FAIL".equals(st.getCourseResult())) {
                failList.add(st);
            }
        }

        String pass = passList.stream()
                .map(st -> st.getName() + " :: " + st.getStudentId() + " --> GRADE: " + st.getcourseGrade() + " - MARK: " + st.getcourseMarks())
                .collect(Collectors.joining(", "));

        System.out.println("PASS --> [" + pass + "]");
        String fail = failList.stream()
                .map(st -> st.getName() + " :: " + st.getStudentId() + " --> GRADE: " + st.getcourseGrade() + " - MARK: " + st.getcourseMarks())
                .collect(Collectors.joining(", "));

        System.out.println("FAIL --> [" + fail + "]");

    }

    private void gradeGrouping() {
        if(University.studentList==null || University.studentList.isEmpty()){
            System.out.println("< Nothing to Display >");
            return;
        }
        System.out.println("Grade Grouping");
        // Z; → P; C; D;  HD
        List<Student>gradeZList = new ArrayList<>();
        List<Student>gradePList = new ArrayList<>();
        List<Student>gradeCList = new ArrayList<>();
        List<Student>gradeDList = new ArrayList<>();
        List<Student>gradeHDList = new ArrayList<>();

        for(Student st:University.studentList){
            if ("Z".equals(st.getcourseGrade())) {
                    gradeZList.add(st);
            } else if ("P".equals(st.getcourseGrade())) {
                gradePList.add(st);
            } else if ("C".equals(st.getcourseGrade())) {
                gradeCList.add(st);
            } else if ("D".equals(st.getcourseGrade())) {
                gradeDList.add(st);
            } else if("HD".equals(st.getcourseGrade())){
                gradeHDList.add(st);
            }
        }
        if (!gradeZList.isEmpty()) {
            String result = gradeZList.stream()
                    .map(st -> st.getName() + " :: " + st.getStudentId() + " --> GRADE: " + st.getcourseGrade() + " - MARK: " + st.getcourseMarks())
                    .collect(Collectors.joining(", "));

            System.out.println("Z --> ["+result+"]");
        }
        if (!gradePList.isEmpty()) {
            String result = gradePList.stream()
                    .map(st -> st.getName() + " :: " + st.getStudentId() + " --> GRADE: " + st.getcourseGrade() + " - MARK: " + st.getcourseMarks())
                    .collect(Collectors.joining(", "));

            System.out.println("P --> ["+result+"]");
        }
        if (!gradeCList.isEmpty()) {
            String result = gradeCList.stream()
                    .map(st -> st.getName() + " :: " + st.getStudentId() + " --> GRADE: " + st.getcourseGrade() + " - MARK: " + st.getcourseMarks())
                    .collect(Collectors.joining(", "));

            System.out.println("C --> ["+result+"]");
        }
        if (!gradeDList.isEmpty()) {
            String result = gradeDList.stream()
                    .map(st -> st.getName() + " :: " + st.getStudentId() + " --> GRADE: " + st.getcourseGrade() + " - MARK: " + st.getcourseMarks())
                    .collect(Collectors.joining(", "));

            System.out.println("D --> ["+result+"]");
        }
        if (!gradeHDList.isEmpty()) {
            String result = gradeHDList.stream()
                    .map(st -> st.getName() + " :: " + st.getStudentId() + " --> GRADE: " + st.getcourseGrade() + " - MARK: " + st.getcourseMarks())
                    .collect(Collectors.joining(", "));

            System.out.println("HD --> ["+result+"]");
        }

    }

    private void studentList() {
        if(University.studentList==null || University.studentList.isEmpty()){
            System.out.println("< Nothing to Display >");
            return;
        }
        System.out.println("Student List");
        for(Student st:University.studentList){
            System.out.println(st.getName()+" :: "+st.getStudentId()+" --> Email: "+st.getEmail());
        }
    }

    private void menuHelp() {
        System.out.println("Admin Menu Options");
        System.out.println("c = login");
        System.out.println("g = register");
        System.out.println("p = exit");
        System.out.println("r = login");
        System.out.println("s = StudentList");
        System.out.println("x = exit");
    }

    private char readMainMenuChoice() {
        System.out.print("Admin System (c/g/p/r/s/x) : ");
        return Input.readCharacter();
    }

}
