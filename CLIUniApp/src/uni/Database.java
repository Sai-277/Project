package uni;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Database {

    private static final String path = "D:\\UTS\\Sem-2\\FSD\\Assignment\\Assign_part-2\\Project\\CLIUniApp\\src\\data\\Student.data";


    static {
        initialize();
    }
    public Database(){}
    public static void initialize() {
        File file = new File(path);

        if (!file.exists()) {
            try {
                file.createNewFile();
                List<Student> students = new ArrayList<>();
                FileOutputStream fileOut = new FileOutputStream(file);
                ObjectOutputStream objOut = new ObjectOutputStream(fileOut);
                objOut.writeObject(students);
                objOut.close();
                fileOut.close();
            } catch (IOException e) {
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, "Reading Error", e);
            }
        }
    }

    public static void write(List<Student> students) {
        File file = new File(path);
        try {
            FileOutputStream fileOut = new FileOutputStream(file);
            ObjectOutputStream objOut = new ObjectOutputStream(fileOut);
            objOut.writeObject(students);
            objOut.close();
            fileOut.close();
        } catch (IOException e) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, "Reading Error", e);
        }
    }

    public static List<Student> read() {
        List<Student> studentList = null;
        File file = new File(path);
        try {
            FileInputStream fileIn = new FileInputStream(file);
            ObjectInputStream objIn = new ObjectInputStream(fileIn);
            Object data = objIn.readObject();
            if (data != null)
                studentList = (List) data;
            fileIn.close();
            objIn.close();
        }  catch (FileNotFoundException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, "File Not Found", ex);
        } catch (IOException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, "Reading Error", ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return studentList;
    }

}