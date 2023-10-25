package uni;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Database {

    private static String path = "D:\\UTS\\Sem-2\\FSD\\Assignment\\Assign_part-2\\Project\\CLIUniApp\\src\\data\\Student.data";


    static {
        initialize();
    }
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
                e.printStackTrace();
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
            e.printStackTrace();
        }
    }

    public static List<Student> read() {
        List<Student> temp = null;
        File file = new File(path);
        try {
            FileInputStream fileIn = new FileInputStream(file);
            ObjectInputStream objIn = new ObjectInputStream(fileIn);
            temp = (List) objIn.readObject();
            fileIn.close();
            objIn.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }
        return temp;
    }

}