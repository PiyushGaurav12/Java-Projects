package miniprojet;

import java.io.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Insert {
	
	public static void insert(  ArrayList<Student> student)   {
		Scanner sc = new Scanner(System.in);
		
		Connection con=null;
		Statement stmt=null;
	
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","Piyush");
			stmt=con.createStatement();
			String sql="insert into student(StudentId,FirstName,LastName,Department,Contactno,Email,City,State,Country,ZIP,Marks)values(?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement pstmt=con.prepareStatement(sql);
			for(int i=0;i<student.size();i++) {
			
			
			
			//String sql="insert into student(StudentId,FirstName,LastName,Department,Contactno,Email,City,State,Country,ZIP,Marks)values(?,?,?,?,?,?,?,?,?,?,?)";
			//PreparedStatement pstmt=con.prepareStatement(sql);
			pstmt.setInt(1,student.get(i).StudentId);
			pstmt.setString(2,student.get(i).FirstName);
			pstmt.setString(3,student.get(i).LastName);
			pstmt.setString(4,student.get(i).Department);
			pstmt.setInt(5,student.get(i).Contactno);
			pstmt.setString(6,student.get(i).Email);
			pstmt.setString(7,student.get(i).City);
			pstmt.setString(8,student.get(i).State);
			pstmt.setString(9,student.get(i).Country);
			pstmt.setInt(10,student.get(i).ZIP);
			pstmt.setInt(11,student.get(i).Marks);
			pstmt.executeUpdate();
			}
			System.out.println("Successfully inserted");
			
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally {
            try
            {
                if(stmt!=null)
                {
                    stmt.close();
                    stmt=null;
                }
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
 
            try
            {
                if(con!=null)
                {
                    con.close();
                    con=null;
                }
            }catch(SQLException e) {
            	e.printStackTrace();            
            }
        }
	}
	}


