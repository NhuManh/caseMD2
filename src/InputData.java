import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class InputData {
    public static int getValiInteger(Scanner sc,String prompt) {
        int val = 0;
        while(true) {
            try{
                System.out.print(prompt);
                val = Integer.parseInt(sc.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("ID không hợp lệ. Vui lòng nhập lại.");
            }
        }
        return val;
    }
    public static String getValiString(Scanner sc,String prompt,int min,int max) {
        String val = "";
        while(true) {
            System.out.print(prompt);
            val = sc.nextLine();
            if(val.length()>=min && val.length()<=max) {
                break;
            }else {
                System.out.println("Vui lòng nhập tên có độ dài từ "+min+ " đến "+max+ " kí tự.");
            }
        }
        return val;
    }
    public static String getValiDate(Scanner sc,String prompt) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        String dateStr = "";
        while (true) {
            System.out.print(prompt);
            dateStr = sc.nextLine();
            try {
                dateFormat.parse(dateStr);
                break;
            } catch (ParseException e) {
                System.out.println("Ngày sinh không hợp lệ. Định dạng phải là yyyy-MM-dd. Vui lòng nhập lại.");
            }
        }
        return dateStr;
    }
    // Phương thức kiểm tra email
    public static boolean isValidEmailSimple(String email) {
        return email.contains("@") && email.endsWith(".com");
    }

    // Phương thức yêu cầu nhập email hợp lệ
    public static String getValidEmailSimple(Scanner scanner, String prompt) {
        String email;
        while (true) {
            System.out.print(prompt);
            email = scanner.nextLine();
            if (isValidEmailSimple(email)) {
                break;
            } else {
                System.out.println("Email không hợp lệ. Email cần chứa '@' và kết thúc bằng '.com'. Vui lòng nhập lại.");
            }
        }
        return email;
    }
}
