package murach.data;

import murach.business.User;

public class UserDB {
    public static long insert(User user) {
        // Mô phỏng lưu dữ liệu xuống DB hoặc file log
        System.out.println("Đã lưu user: " + user.getEmail());
        return 1;
    }
}