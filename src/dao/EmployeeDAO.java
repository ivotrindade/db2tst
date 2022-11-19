/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ivo
 */
public class EmployeeDAO {
    
    private Connection connection;
    private ResultSet result = null;
    private int columnCount = 0;


    public EmployeeDAO() throws SQLException {
        this.connection = ConnFactoryDB2.getConnection();
    }
    
    public List<Employee> getLista() throws SQLException {
        // System.out.println("Selecting Employees!");
        PreparedStatement stmt = 
                this.connection.prepareStatement(
                        "select FIRSTNME, "
                                + "LASTNAME, "
                                + "WORKDEPT, "
                                + "JOB from IBMUSER.EMP");
        ResultSet rs = stmt.executeQuery();
        List<Employee> empList = new ArrayList<Employee>();
        while (rs.next()) {
                //		 criando o objeto Contato
        Employee emp = new Employee();
        emp.setFirstname(rs.getString("FIRSTNME"));
        emp.setLastname(rs.getString("LASTNAME"));
        emp.setWkdept(rs.getString("WORKDEPT"));
        emp.setJob(rs.getString("JOB"));


        // adicionando o objeto à lista
        empList.add(emp);
        }
        rs.close();
        stmt.close();
        return empList;
    }
    
    
}
