package uni;

import utils.CredentialValidator;
import utils.Input;


import java.util.List;
import java.util.Random;

public class University {

    public static List<Student> studentList = null;

    public University() {
        studentList = Database.read();
    }

    private char readChoice() {
        System.out.print("University System: (A)dmin, (S)tudent, or X : ");
        return Input.readCharacter();
    }

    public void homeMenu() {
        System.out.println("University Home Menu");
        char c;
        while ((c = readChoice()) != 'X') {
            switch (c) {
                case 'A':
                    adminMenu();
                    break;
                case 'S':
                    studentMenu();
                    break;
            }
        }
        System.out.println("Thank You");
    }

    private void studentMenu() {
        studentMainMenu();
    }

    private void adminMenu() {

    }

    private void studentMainMenu() {
        char c;
        while ((c = readMainMenuChoice()) != 'x') {
            switch (c) {
                case 'l':
                    studentLogin();
                    break;
                case 'r':
                    studentRegister();
                    break;
                default:
                    mainMenuHelp();
                    break;

            }
        }
    }

    private char readMainMenuChoice() {
        System.out.print("Student System (l/r/x) : ");
        return Input.readCharacter();
    }

    private void studentRegister() {
        System.out.println("Student Sign Up");
        Student student = new Student();
        System.out.print("Email : ");
        String email = Input.readString();

        System.out.print("Password : ");
        String password = Input.readString();
        // validate password
        while (validateCredentials(email, password)) {
            System.out.println("Incorrect email or password format");
            System.out.print("Email : ");
            email = Input.readString();
            System.out.print("Password : ");
            password = Input.readString();
        }
        // if any one validation fails, you have to keep in the loop untill
        // it is correct

        System.out.println("email and password formats acceptable");
        // check if that student exists by email in DB
        // if exists System.out.println("Student "+this.name+" already exists");
        // no need to keep it in loop
        student.setEmail(email);
        student.setPassword(password);
        int index = findStudent(email);
        if (index == -1) {
            System.out.print("Name: ");
            student.setName(Input.readString());
            System.out.println("Enrolling Student " + student.getName());
            student.setStudentId(generateStudentId());
            University.studentList.add(student);
            Database.write(University.studentList);
        } else {
            System.out.println("Student " + University.studentList.get(index).getName() + " already exists");
        }
    }

    private String generateStudentId() {
        String id = generateId();
        while (!uniqueStudentIdValidation(id)) {
            id = generateId();
        }

        return id;
    }

    public boolean uniqueStudentIdValidation(String Id) {
        List<Student> studentList = University.studentList;
        return studentList.stream().noneMatch(st -> st.getStudentId().equals(Id));
    }

    public String generateId() {
        int id = new Random().nextInt(1000000);
        StringBuilder studentID = new StringBuilder(Integer.toString(id));
        while (studentID.length() < 6) {
            studentID.insert(0, "0");
        }
        return studentID.toString();

    }


    private void studentLogin() {
        System.out.println("Student Sign In");
        System.out.print("Email : ");
        String email = Input.readString();
        // validate email
        System.out.print("Password : ");
        String password = Input.readString();
        // do the validation and keep it untill in correct format
        while (validateCredentials(email, password)) {
            System.out.println("Incorrect email or password format");
            System.out.print("Email : ");
            email = Input.readString();
            System.out.print("Password : ");
            password = Input.readString();
        }
        System.out.println("email and password formats acceptable");
        // check it that student exists by email in DB
        // if not leave it
        // inside the if condition call be submenu
        int index = findStudent(email);
        if (index != -1){
            University.studentList.get(index).studentSubMenu();
            Database.write(University.studentList);
            }
        else
            System.out.println("Student does not exist");

    }

    private int findStudent(String email) {
        List<Student> list = University.studentList;
        for (int i = 0; i < list.size(); i++) {
            Student st = list.get(i);
            if (st.getEmail().equals(email)) {
                return i;
            }
        }
        return -1;
    }

    public boolean validateCredentials(String email, String password) {
        return (!(CredentialValidator.validateEmail(email) &&
                CredentialValidator.validatePassword(password)));
    }

    private void mainMenuHelp() {
        System.out.println("Student Main Menu Options");
        System.out.println("l = login");
        System.out.println("r = register");
        System.out.println("x = exit");

    }


}
