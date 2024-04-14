package miniprojet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
public class Delete {
	static
	{
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
	} catch (ClassNotFoundException e) {
	
		e.printStackTrace();
	}
	}
	public static void delete()  {
		Scanner sc = new Scanner(System.in);
		Connection con=null;
		Statement stmt=null;
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","Piyush");
			
			System.out.println("Enter the StudentId to delete a record: ");
			int ID = sc.nextInt();
			stmt=con.createStatement();
			PreparedStatement st = con.prepareStatement("DELETE FROM student WHERE StudentId = ?");
		        st.setInt(1,ID);
		        st.executeUpdate(); 
		        System.out.println("The enetered id no has been deleted check the database.....");
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
