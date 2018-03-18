/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.main;

import assignment.entity.Student;
import assignment.model.StudentModel;
import java.util.ArrayList;

/**
 *
 * @author daolinh
 */
public class MainThread {
    public static void main(String[] args) {
        StudentModel model = new StudentModel();
        ArrayList<Student> list = model.getListStudent();
        for (int i = 0; i < list.size(); i++) {
            Student st = list.get(i);
            System.out.println(st.getId() + " - " + st.getName());
        }
    }
}
