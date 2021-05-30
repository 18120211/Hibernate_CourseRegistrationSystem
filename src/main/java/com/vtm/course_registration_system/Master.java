package com.vtm.course_registration_system;

public class Master {
    private static Master instance;
    private Master(){}
    public static Master getInstance() {
        if (Master.instance == null) {
            Master.instance = new Master();
        }
        return Master.instance;
    }
    private void menu() {
        System.out.println("1. Đăng nhập");
        System.out.println("2.1. Xem danh sách giáo vụ");
        System.out.println("2.2. Thêm tài khoản giáo vụ");
        System.out.println("2.3. Cập nhật tài khoản giáo vụ");
        System.out.println("2.4. Reset mật khẩu giáo vụ");
        System.out.println("2.5. Xóa tài khoản giáo vụ");
        System.out.println("3.1. Xem ds môn học");
        System.out.println("3.2. Tìm 1 môn học");
        System.out.println("3.3. Thêm môn học");
        System.out.println("3.4. Cập nhật môn học");
        System.out.println("3.5. Xóa môn học");
        System.out.println("4.1. Xem ds học kỳ");
        System.out.println("4.2. Thêm học kỳ");
        System.out.println("4.3. Xóa học kỳ");
        System.out.println("4.4. Set học kỳ hiện tại");
        System.out.println("5.1. Xem ds lớp học");
        System.out.println("5.2. Thêm lớp học");
        System.out.println("5.3. Xóa lớp học");
        System.out.println("6.1. Xem ds học sinh");
        System.out.println("6.2. Tìm kiếm hs");
        System.out.println("6.3. Thêm hs");
        System.out.println("6.4. Cập nhật hs");
        System.out.println("6.5. Xóa hs");
        System.out.println("6.6. Reset mật khẩu cho sv");
        System.out.println("7.1. Xem kì đk học phần");
        System.out.println("7.2. Tạo một kỳ đk học phần");
        System.out.println("8.1. Xem ds học phần");
        System.out.println("8.2. Tìm kiếm học phần");
        System.out.println("8.3. Thêm học phần");
        System.out.println("8.4. Xóa học phần");
        System.out.println("9. Xem ds sinh viên đk học phần");
        System.out.println("10. Đăng ký học phần");
        System.out.println("11. Xem ds các học phần mà mình đăng ký");
        System.out.println("12. Xóa một học phần còn hạn đăng ký");
    }
    public void run() {
        String choice = "0";
        boolean isRunning = true;
        while(isRunning) {
            switch (choice) {
                case "0":
                    isRunning = false;
                    break;
                default:
                    break;
            }
        }
    }
}
