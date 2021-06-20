# Hibernate_CourseRegistrationSystem
## Thông tin tác giả
- Họ tên: Võ Thế Minh
- Liên lạc: minhthevo123@gmail.com

## Thông tin đồ án
- Trường đại học Khoa học Tự Nhiên khóa K18 khóa học `Lập trình ứng dụng Java-CQ2019/1`
- Đồ án môn học số 3-Hệ thống quản lý đăng ký học phần cho Sinh Viên
- Yêu cầu đồ án: [Here](https://drive.google.com/file/d/1yFsjstaQqR16FSlkQ2SjpWVgn7JQ0gyw/view)

## Hướng dẫn chạy đồ án
**Chuẩn bị:**
- Cài đặt Java sdk phiển bản 8 trở lên
- Cài đặt Mysql service 
- Cài đặt Mysql Mysql workbench(Hoặc 1 trình thực thi mysql script)
- Cài đặt IDEA intellij

**Thực hiện:**
- Chạy `SqlScipt.sql`
- Tạo một Mysql connection, tiếp tục cấu hình tập tin `/src/main/resources/hibernate.cfg.xml` cho phù hợp với connection
``` xml
    <property name="connection.username"></property>
    <property name="connection.password"></property>
```
- Build project
- Chạy method main ở class `src/main/java/com/vtm/course_registration_system/App.java`




## Công nghệ được sử dụng trong đồ án
- IDEA: Intellij
- Programing language: Java  
- Framework: Hibernate
- GUI: Java-swing  
- Database: mySql

## Demo ứng dụng

![](https://res.cloudinary.com/minhvocloudinary/image/upload/v1623561368/hibernate/readme/ministyr_ldovdk.png
"Giao diện chính cho giáo vụ")

![](https://res.cloudinary.com/minhvocloudinary/image/upload/v1623561368/hibernate/readme/registration_cewupi.png
"Giao diện chính cho sinh viên")

![](https://res.cloudinary.com/minhvocloudinary/image/upload/v1623561368/hibernate/readme/login_lorvy2.png
"Giao diện đăng nhập")
