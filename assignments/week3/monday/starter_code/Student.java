
import java.util.Objects;


/**
 * Lab 2 — Student. Replace UnsupportedOperationException bodies with real logic.
 * See ../README.md
 */
public class Student {
    // TODO: private static nextId, private static count of instances
    // TODO: private final int id; private String name; private String program
    private static int nextId = 0;
    private static int count = 0;
    private final int id;
    private String name;
    private String program;

    public Student(String name, String program) {
        this.id = nextId;
        nextId += 1;
        count += 1;
        this.name = name;
        this.program = program;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getProgram() {
        return this.program;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public static int getEnrollmentCount() {
        return count;
    }

    @Override
    public String toString() {
        return String.format("Student: %s, program: %s", this.name, this.program);
    }

    @Override
    public boolean equals(Object o) {
        if(o instanceof Student){
            Student other = (Student) o;
            return other.id == this.id;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }
}