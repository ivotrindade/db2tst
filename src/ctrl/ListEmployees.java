/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ctrl;

import model.Employee;
import dao.*;

import java.sql.SQLException;
import java.util.List;
import java.util.*;
import java.text.*; // SimpleDateFormat


/**
 *
 * @author ivo
 */
public class ListEmployees {
    
    private static int totEmp = 0;
    
    public static void main(String[] args) throws SQLException {
        
        
        Date dIni = new Date();
        SimpleDateFormat ft = new SimpleDateFormat ("E yyyy.MM.dd 'at' hh:mm:ss a zzz");
        
        System.out.println("Starting Employee Display - " + ft.format(dIni));
        
        // db connection

        EmployeeDAO dao = new EmployeeDAO();
        
        List<Employee> empList = dao.getLista();
                
        System.out.println("1st Name |  Last Name  |   Dept  |  Job  <List Header>" + "\n");
      
        for (Employee emp : empList) {
            
            System.out.println(emp.getFirstname() + "  |  " +
                    emp.getLastname() + "  |  " +
                    emp.getWkdept() + "  |  " +
                    emp.getJob() + "\n");
            totEmp++;

        }
        
        System.out.println("Employees List Completed - Total Employees Listed = " + 
                Integer.toString(totEmp));
        
        /* 
        Fim da Cópia dos Centros
        */
        // sessão ssh
        
        Date dFim = new Date();
        System.out.println("Fim do Processamento - " + ft.format(dFim));
        
    }
    
}
