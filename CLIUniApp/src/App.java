

import uni.Student;
import uni.Subject;

public class App {
    public static void main(String[] args) throws Exception {
        Student s = new Student();
        s.enrollSubject();
        s.enrollSubject();
        s.enrollSubject();
        s.enrollSubject();
       s.getSubjects().forEach(System.out::println);
       System.out.println(s.getCourseResult());
    }
}
