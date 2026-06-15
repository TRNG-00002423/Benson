/** Lab 2 driver — run after Student is implemented. */
public class StudentDemo {
    public static void main(String[] args) {
        // TODO: create 3 Student instances, print enrollment count,
        // demonstrate equals vs == with two references to same id scenario if possible
        Student s1 = new Student("Fanta", "CS");
        Student s2 = new Student("Jack", "Math");
        Student s3 = new Student("Tris", "Chem");
        Student s4 = s2;
        System.out.println(Student.getEnrollmentCount());
        System.out.println(s2 == s4);
        System.out.println(s2.equals(s4));
    }
}