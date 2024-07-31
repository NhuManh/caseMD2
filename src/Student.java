public class Student {
    public static Object remove;
    private int studentId;
    private String name,className,dateOfBirth;

    // Constructor
    public Student(int studentId, String name, String dateOfBirth, String className) {
        this.studentId = studentId;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.className= className;;
    }

    // Getter và Setter

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    public String getClassName() {
        return className;
    }
    public void setClassName(String className) {
        this.className = className;
    }

    @Override
    public String toString() {
        return studentId + ", Name: " + name + ", Date of Birth: " + dateOfBirth +
                ", Class: " + className+".";
    }
}
