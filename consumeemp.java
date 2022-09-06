/**
 *  Illustrating to ADD DATA TO DATABASE AND PRINT DATA OF ONE OR ALL EMPLOYEE USING DATA ACCESS OBJECT
 *  By Prashant Bansal
 */

package com.slot2jdbc;

import java.util.Scanner;


public class consumeemp {
    public static void main(String[] args) throws Exception{
        //TODO Auto-generated method stub

        int empid=111,empsalary = 40000;
        String empName="Anuu", empDomain=".net";
        Scanner bs = new Scanner(System.in);
        System.out.println("------Welcome to Employee Management-------");
        System.out.println("Press 1 for add emp\n Press 2 for retrieve emp");
        int op = bs.nextInt();
        empDAO dao = new empDAO();
        dao.connect();

        switch(op){

        case 1-> {
            System.out.print("Employee Id :");
            empid = bs.nextInt();
            System.out.print("Employee Name :");
            empName = bs.next();
            System.out.print("Employee domain :");
            empDomain = bs.next();
            System.out.println("Employee Salary :");
            empsalary = bs.nextInt();


            emp e1 = new emp();
            e1.eid = empid;
            e1.eName = empName;
            e1.eDomain = empDomain;
            e1.eSalary = empsalary;
            dao.addEmp(e1);
        }
        case 2->{
            System.out.println("Enter eid for details :");
            int eid = bs.nextInt();
            emp e2 = dao.getEmp(eid);
            System.out.println(e2.eid+" is "+e2.eName+" working in "+e2.eDomain+" with "+e2.eSalary+" salary");
        }
        }
        
    }
}

