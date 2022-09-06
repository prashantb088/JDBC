/* This is java program in which we retrive the data from the database 
 * By Prashant Bansal
 *
 package com.slot1jdbc;


import java.sql.*;
public class demoonjdbc1 {
    public static void main(String[] args) throws Exception {
        //TODO Auto-generated method stub
        //loading and register
        Class.forName("com.msql.cj.jdbc.Driver");
        String url="jdbc:mysql://localhost:3306/anudipdeeptech";
        String username="root";
        String password="root";
        String query = "select * from anudipdeeptech ";


        //getting connection
        Connection con=DriverManager.getConnection(url,username,password);
        //creation of statement
        Statement st= con.createStatement();
        //execute statement
        ResultSet rs = st.executeQuery(query);
        //go to next element
        rs.next();
        //process the result
        String emp ="Employee name is "+rs.getString("ename")+" and his/her working in"+rs.getString("edomain")+"with package"+rs.getString("esalary");
        System.out.println(emp);
        //close connection
        con.close();
    }
}

 
 
