package com.infogalaxy;
import java.sql.*;
import java.util.*;
public class DBCon {

        public static void main(String args[]){



            try
            {
                //.......................	(1) REGISTER DRIVER.............................

                Driver d = new oracle.jdbc.driver.OracleDriver();
                System.out.println(" Driver Regiteret successfully...");

                //.................... (2) GET CONNECTION   ...........................

                Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","9145739978pkp");
                System.out.println("Connection ID : "+con);

                //..............  (3) Create Statement Object  ...................

                Statement stmt = con.createStatement();

                //...............(4) EXECUTE THE QUERY .............................

                //diseaseinfo values('D106','hypothermia','low');

                String DISID , DISNAME , SEVERITY ;
                System.out.println("\n Enter the Disease ID , Name and Severity ");
                Scanner sc = new Scanner(System.in);
                DISID = sc.next();
                DISNAME = sc.next();
                SEVERITY = sc.next();
                stmt.executeUpdate("insert into diseaseinfo values('"+DISID+"','"+DISNAME+"'s,'"+SEVERITY+"')");
                System.out.println("Query Executed");

                //............... (5) Close Connection ................
                con.close();
            }
            catch(SQLException ex)
            {
                System.out.println("ERROR plz check DBConnection");
            }
        }
    }


