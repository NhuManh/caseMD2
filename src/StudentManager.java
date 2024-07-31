
import java.util.ArrayList;
import java.util.List;
public class StudentManager {
    private static List<Student> students;

    public StudentManager() {
        students = new ArrayList<>();
    }

    // Thêm học viên mới
    public void addStudent(Student student) {
        students.add(student);
    }
    // Lấy danh sách học viên
    public List<Student> getAllStudents() {
        return students;
    }
    // Chỉnh sửa thông tin học viên

    public void setStudents(List<Student> students) {
        this.students = students;
    }

}
