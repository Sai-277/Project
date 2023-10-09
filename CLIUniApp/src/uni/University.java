package uni;

import utils.Input;

public class University {
    

    private char readChoice() {
        System.out.println("University System: (A)dmin, (S)tudent, or X : ");
        return Input.readCharacter();
    }

    public void homeMenu() {
        System.out.print("University Home Menu");
        char c;
        while ((c = readChoice()) != 'x') {
            switch (c) {
                case 'A':
                    adminMenu();
                    break;
                case 'S':
                    studentMenu();
                    break;
            }
        }
        System.out.println("Back to Main Menu");
    }

    private void adminMenu() {
        
    }

}
