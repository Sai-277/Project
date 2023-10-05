// package uni;

// import java.io.File;
// import java.io.FileInputStream;
// import java.io.FileOutputStream;
// import java.io.IOException;
// import java.io.ObjectInputStream;
// import java.io.ObjectOutputStream;

// public class Database {

//     private static String path = "D:\\UTS\\Sem-2\\FSD\\Assignment\\Assign_part-2\\Project\\CLIUniApp\\src\\data\\Student.data";

//     public static void main(String[] args) throws IOException, ClassNotFoundException {

//         FileOutputStream fos = null;
//          ObjectOutputStream oos = null;
//         FileInputStream fis = null;
//           ObjectInputStream ois = null;
//         try{
//           fos = new FileOutputStream(path);
//           oos = new ObjectOutputStream(fos);
//           fis = new FileInputStream(path);
//           ois =  new ObjectInputStream(fis);
//         //  oos.writeObject(new Student( "xyz", "email", "123456", null));
//         //  oos.writeObject(new Student( "xyz", "email", "123456", null));
//         int i = 2;
//          while(i-->0){
//             Object st = ois.readObject();
//             if(st == null) break;
//           Student s = (Student) st;
//           System.out.println(s);
//           }
          
//            fos.close();
//          ois.close();
//           fis.close();
//         }
//         catch(ClassNotFoundException e){
//             System.out.println("Class is not found");
//         } catch(IOException e ){
//             System.out.println("File is not found in the given path");
//         }finally{
        
//         }


       
          
// }
// }