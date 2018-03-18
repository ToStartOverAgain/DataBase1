/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.model;

import assignment.entity.Student;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Làm nhiệm vụ thao tác với bảng students trong database. Các thao tác gồm có:
 * thêm mới một sinh viên, sửa sinh viên, lấy danh sách sinh viên, xoá thông tin
 * sinh viên.
 *
 * @author daolinh
 */
public class StudentModel {

    /*    
      * Lấy danh sách sinh viên trong database và trả về 
      * một arraylist các đối tượng Student.
     */
    public ArrayList<Student> getListStudent() {
        // Khởi tạo một array líst rỗng để chứa dữ liệu trả về.
        ArrayList<Student> listStudent = new ArrayList<>();

        // Tạo kết nối tới database, thực thi câu lệnh "select * from students";
        Connection connection = null;
        try {
            // Tạo kết nối với tài khoản root, password rỗng.
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/aptech_fpt", "root", "");
            // Tạo đối tượng statement để thực thi lệnh sql.
            Statement statement = connection.createStatement();
            // Thực thi câu lệnh sql với kết quả trả về đưa vào resultset.
            ResultSet rs = statement.executeQuery("select * from students");
            // Với từng dòng trả về trong resultset, lấy ra các cột tương ứng và tạo đối tượng student.
            while(rs.next()){
                int id = rs.getInt("id");
                String rollNumber = rs.getString("rollNumber");
                String name = rs.getString("name");
                String phone = rs.getString("phone");
                String email = rs.getString("email");
                int status = rs.getInt("status");
                // Tạo ra đối tượng student tương ứng với các trường vừa lấy ra.
                Student student = new Student(id, rollNumber, name, phone, email, status);
                // Thêm đối tượng vừa tạo vào arraylist (tạo ở trên cùng).
                listStudent.add(student);
            }            
        } catch (SQLException ex) {
            System.err.println("Can not connect to database.");
        } finally {
            try {
                connection.close();
            } catch (SQLException ex) {
                System.err.println("Can not close connection.");
            }
        }

        // trả về kết quả default;
        return listStudent;
    }
}
