import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class IOStream {

    private Student[] students;

    // Phương thức ghi danh sách học viên vào file
    public void writeToFile(String filename, List<Student> students) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Student student : students) {
                writer.write(student.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Lỗi khi lưu danh sách học viên: " + e.getMessage());
        }
    }

    // Phương thức đọc danh sách học viên từ file
    public List<Student> readFromFile(String filename) {
        List<Student> students = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(", ");
                if (parts.length == 4) {
                    try {
                        int id = Integer.parseInt(parts[0]);
                        String name = parts[1].split(": ")[1];
                        String dateOfBirth = parts[2].split(": ")[1];
                        String className = parts[3].split(": ")[1].replace(".", ""); // Remove trailing dot
                        Student student = new Student(id, name, dateOfBirth, className);
                        students.add(student);
                    } catch (NumberFormatException e) {
                        System.out.println("Error parsing number: " + e.getMessage());
                    }
                } else {
                    System.out.println("Invalid line format: " + line);
                }
            }
        } catch (IOException e) {
            System.out.println("Lỗi khi đọc danh sách học viên từ file: " + e.getMessage());
        }
        return students;
    }
    // Trả học viên theo Id
    public Student getStudentById(int studentId) {
        List<Student> students = readFromFile("list.txt");
        for (Student student : students) {
            if (student.getStudentId() == studentId) {
                return student;
            }
        }
        return null;
    }


    //Phương thức xóa học viên ở file
    public void deleteStudentById(int id) {
        List<Student> students = readFromFile("list.txt");
        Iterator<Student> iterator = students.iterator();
        boolean studentFound = false;

        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.getStudentId() == id) {
                iterator.remove();
                studentFound = true;
                break; // Thoát khỏi vòng lặp sau khi tìm thấy và xóa
            }
        }

        if (studentFound) {
            saveStudentsToFile(students, "list.txt");
            System.out.println("Học viên có ID " + id + " đã bị xóa.");
        } else {
            System.out.println("Không tìm thấy học viên có ID: " + id);
        }
    }


    public void saveStudentsToFile(List<Student> students, String filename) {
        if (students == null) {
            System.out.println("Danh sách học viên rỗng, không có gì để lưu.");
            return;
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Student student : students) {
                writer.write(student.getStudentId() + ", Name: " + student.getName() + ", Date of Birth: " + student.getDateOfBirth() + ", Class: " + student.getClassName() + ".");
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Lỗi khi lưu danh sách học viên vào file: " + e.getMessage());
        }
    }


    public void updateStudentInFile(int studentId, String newName, String newDateOfBirth, String newClassName) {
        // Đọc nội dung từ file và lưu vào danh sách
        List<Student> students = readFromFile("list.txt");
        boolean studentFound = false;

        // Tìm và cập nhật thông tin học viên
        for (Student student : students) {
            if (student.getStudentId() == studentId) {
                student.setName(newName);
                student.setDateOfBirth(newDateOfBirth);
                student.setClassName(newClassName);
                studentFound = true;
                break; // Thoát khỏi vòng lặp sau khi tìm thấy và cập nhật
            }
        }

        if (studentFound) {
            saveStudentsToFile(students, "list.txt");
        } else {
            System.out.println("Không tìm thấy học viên có ID: " + studentId);
        }
    }

}