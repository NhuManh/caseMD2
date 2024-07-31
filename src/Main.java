
import java.util.Scanner;
import java.util.List;

public class Main {
    private static IOStream ioStream = new IOStream();

    public static void main(String[] args) {
        StudentManager studentManager = new StudentManager();
        TeacherManager teacherManager = new TeacherManager();
        Scanner scanner = new Scanner(System.in);
        IOStream ioStream = new IOStream();

        List<Student> students = ioStream.readFromFile("list.txt");
        studentManager.setStudents(students);

        while (true) {
            System.out.println("Main Menu:");
            System.out.println("1. Quản lý học viên");
            System.out.println("2. Quản lý giảng viên");
            System.out.println("3. Thoát");
            System.out.print("Chọn một tùy chọn: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    manageStudents(studentManager, scanner);
                    break;
                case 2:
                    manageTeachers(teacherManager, scanner);
                    break;
                case 3:
                    System.out.println("Thoát chương trình.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Tùy chọn không hợp lệ. Vui lòng chọn lại.");
            }
        }
    }

    private static void manageStudents(StudentManager studentManager, Scanner scanner) {
        while (true) {
            System.out.println("----Student Management----");
            System.out.println("1. Thêm học viên.");
            System.out.println("2. Hiển thị danh sách học viên");
            System.out.println("3. Sửa thông tin học viên.");
            System.out.println("4. Xóa học viên: ");
            System.out.println("5. Quay lại menu chính.");
            System.out.print("Chọn một tùy chọn: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addStudent(studentManager, scanner);
                    break;
                case 2:
                    displayAllStudents(studentManager);
                    break;
                case 3:
                    editStudent(studentManager,scanner);
                case 4:
                    deleteByIdStudent(studentManager,scanner);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Tùy chọn không hợp lệ. Vui lòng chọn lại.");
            }
        }
    }

    private static void manageTeachers(TeacherManager teacherManager, Scanner scanner) {
        while (true) {
            System.out.println("----Teacher Management----");
            System.out.println("1. Thêm giảng viên");
            System.out.println("2. Hiển thị danh sách giảng viên");
            System.out.println("3. Quay lại menu chính");
            System.out.print("Chọn một tùy chọn: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addTeacher(teacherManager, scanner);
                    break;
                case 2:
                    displayAllTeachers(teacherManager);
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Tùy chọn không hợp lệ. Vui lòng chọn lại.");
            }
        }
    }

    private static void addStudent(StudentManager studentManager, Scanner scanner) {

        int studentId = InputData.getValiInteger(scanner,"Nhập mã học viên (ID): ");

        String name = InputData.getValiString(scanner,"Nhập tên học viên: ",5,50);

        String dateOfBirth = InputData.getValiDate(scanner,"Nhập ngày sinh (yyyy-MM-dd): ");

        System.out.print("Nhập tên lớp: ");
        String className = scanner.nextLine();

        Student student = new Student(studentId,name, dateOfBirth, className);
        studentManager.addStudent(student);
        ioStream.writeToFile("list.txt", studentManager.getAllStudents());
        System.out.println("Học viên đã được thêm thành công.");
    }

    private static void displayAllStudents(StudentManager studentManager) {
        if (studentManager.getAllStudents().size() == 0) {
            System.out.println("Chưa có học viên.");
        } else {
            System.out.println("Danh sách học viên:");
            for (Student student : studentManager.getAllStudents()) {
                System.out.println(student);
            }
        }
    }

    private static void addTeacher(TeacherManager teacherManager, Scanner scanner) {
        int teacherId = InputData.getValiInteger(scanner,"Nhập mã giảng viên: ");

        String name = InputData.getValiString(scanner,"Nhập tên giảng viên: ",5,50);

        String dateOfBirth = InputData.getValiDate(scanner,"Nhập ngày sinh (yyyy-MM-dd): ");

        String email = InputData.getValidEmailSimple(scanner,"Nhập email: ");

        String phone = String.valueOf(InputData.getValiInteger(scanner,"Nhập số điện thoại: "));

        System.out.print("Nhập địa chỉ: ");
        String address = scanner.nextLine();

        Teacher teacher = new Teacher(teacherId, name, dateOfBirth, email, phone, address);
        teacherManager.addTeacher(teacher);
        System.out.println("Giảng viên đã được thêm thành công.");
    }

    private static void displayAllTeachers(TeacherManager teacherManager) {

        if (teacherManager.getAllTeachers().size() == 0) {
            System.out.println("Chưa có giảng viên.");
        } else {
            System.out.println("Danh sách giảng viên:");
            for (Teacher teacher : teacherManager.getAllTeachers()) {
                System.out.println(teacher);}
            }
    }
    private static void editStudent(StudentManager studentManager, Scanner scanner) {
        System.out.println("----Danh sách học viên----");
        for (Student student : studentManager.getAllStudents()) {
            System.out.println(student);
        }
        int studentId = InputData.getValiInteger(scanner,"Nhập ID học viên cần chỉnh sửa.");
        Student student = ioStream.getStudentById(studentId);
        if (student != null) {
            System.out.println("Đã tìm thấy học viên có ID: " + studentId);
        }
        else{
            System.out.println("Không có học viên có ID: " + studentId);
        }
        System.out.println(student);// Hiển thị học viên tìm được

        String name = InputData.getValiString(scanner,"Nhập tên mới: ",5,50);
        student.setName(name);

        String dateOfBirth = InputData.getValiDate(scanner,"Nhập ngày sinh mới: ");
        student.setDateOfBirth(dateOfBirth);

        System.out.println("Nhập tên lớp mới");
        String className = scanner.nextLine();
        student.setClassName(className);
        ioStream.updateStudentInFile(studentId,name,dateOfBirth,className);
        System.out.println("Đã cập nhật");

    }

    public static void deleteByIdStudent(StudentManager studentManager, Scanner scanner) {
        for (Student student : studentManager.getAllStudents()) {
            System.out.println(student);
        }
        System.out.println("Nhập ID học viên cần xóa; ");
        int studentId = scanner.nextInt();
        scanner.nextLine();
         Student student = ioStream.getStudentById(studentId);
        if (student == null) {
            System.out.println("Không tìm thấy học viên có ID: " + studentId);
        }else{
            System.out.println("Đã tìm thấy học viên"+ student);
            while(true){
                System.out.println("1:Xoá");
                System.out.println("2:Thôi...");

                int choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1:
                        ioStream.deleteStudentById(studentId);
                        return;
                    case 2:
                        return;
                    default:
                        System.out.println("Lựa chọn không phù hợp");
                }
            }
        }
    }
}