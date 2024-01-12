import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Scanner;

public class ConnectionProvider
{
    public static void main(String[] args) {
        getConnnection();
    }
    private static Connection conn;
    public static Connection getConnnection()
    {
        try
        {
//            String driver = "com.mysql.cj.jdbc.Driver";
//            String url = "jdbc:mysql://localhost:3306/testjdbc";
//            String url = "jdbc:mysql://localhost:3306/Photos";
//            String username = "root";
//            String password = "rna@2004";
            if(conn == null)
            {
                Class.forName("com.mysql.cj.jdbc.Driver");
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/schoolarshipmanagementsystem","root","rna@2004");
            }
            System.out.println("Database Connected..!");

//            String q1 = "create table UserLogin(User_ID varchar(20), Password varchar(20))";
//            // create a statement
//            Statement stmt = conn.createStatement();
//            stmt.executeUpdate(q1);
//            System.out.println("Table is created in database!");
//            conn.close();


//            String q2 = "create table UserSignUp(User_ID varchar(20), Name varchar(20) , Email_address varchar(20), Contact_no bigint(20), Password bigint(20), Confirmed_password bigint(20))";
//            // create a statement
//            Statement stmt = conn.createStatement();
//            stmt.executeUpdate(q2);
//            System.out.println("Table is created in database!");
//            conn.close();

//            String q3 = "create table Student_Details_1(Admission_no bigint(30),Enrollment_no bigint(30), Roll_no bigint(30), First_name varchar(20) , Last_name varchar(20) , Email_address varchar(20), Contact_no bigint(20), Date_of_Birth varchar(20), Gender varchar(20), Aadhaar_no bigint(20), Address varchar(50), City varchar(50), Pin_code bigint(20), State varchar(20), Religion varchar(10), Category varchar(120), Department varchar(300), Course varchar(50), Branch varchar(20), Admission_Type varchar(20), Admission_Quota varchar(20), Transportation_Required varchar(20), Hostel_Required varchar(20))";
//            // create a statement
//            Statement stmt = conn.createStatement();
//            stmt.executeUpdate(q3);
//            System.out.println("Table is created in database!");
//            conn.close();

//            String q3 = "create table Student1_Details(Admission_no bigint(30),Enrollment_no bigint(30), Roll_no bigint(30) primary key, First_name varchar(20) , Last_name varchar(20) , Email_address varchar(20), Contact_no bigint(20), Date_of_Birth varchar(20), Gender varchar(20), Aadhaar_no bigint(20), Address varchar(50), City varchar(50), Pin_code bigint(20), State varchar(20), Religion varchar(10), Category varchar(120), Department varchar(300), Course varchar(50), Branch varchar(20), Admission_Type varchar(20), Admission_Quota varchar(20), Transportation_Required varchar(20), Hostel_Required varchar(20))";
//            // create a statement
//            Statement stmt = conn.createStatement();
//            stmt.executeUpdate(q3);
//            System.out.println("Table is created in database!");
//            conn.close();

//            String q4 = "create table Student_Details_2(Roll_no bigint(30), Father_Name varchar(30), Father_Occupation varchar(200) , Income varchar(100), Contact_Number varchar(50), Mother_Name varchar(30))";
//            // create a statement
//            Statement stmt = conn.createStatement();
//            stmt.executeUpdate(q4);
//            System.out.println("Table is created in database!");
//            conn.close();

//            String q4 = "create table Student2_Details(Roll_no bigint(30) foreign key References Student1_Details(Roll_no), Father_Name varchar(30), Father_Occupation varchar(200) , Income varchar(100), Contact_Number varchar(50), Mother_Name varchar(30))";
//            // create a statement
//            Statement stmt = conn.createStatement();
//            stmt.executeUpdate(q4);
//            System.out.println("Table is created in database!");
//            conn.close();

//            String q5 = "create table Check_for_Scholarships(Name varchar(50), Father_Name varchar(50), Selected_Course varchar(100),10th_Roll_no bigint(50), 10th_Obtained_Marks varchar(100), 10th_Passing_Year varchar(50) , 10th_Board varchar(20), 12th_Obtained_Marks varchar(100), 12th_Passing_Year varchar(100) , 12th_Board varchar(20), 12th_Stream varchar(20), Diploma varchar(50), Diploma_Branch varchar(30), Diploma_Obtained_Marks varchar(100), Diploma_Passing_Year varchar(10) , Graduation varchar(50), Graduation_University varchar(300), Graduation_Obtained_Marks varchar(50), Graduation_Passing_Year varchar(50))";
//            // create a statement
//            Statement stmt = conn.createStatement();
//            stmt.executeUpdate(q5);
//            System.out.println("Table is created in database!");
//            conn.close();

//            String q5 = "create table Transaction(Pin_Number int(10),Date varchar(200),Transaction_Type varchar(200), Amount varchar(50))";
//            // create a statement
//            Statement stmt = conn.createStatement();
//            stmt.executeUpdate(q5);
//            System.out.println("Table is created in database!");
//            conn.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return conn;
    }
}