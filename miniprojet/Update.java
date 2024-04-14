package miniprojet;

import java.sql.*;
import java.util.Scanner;



public class Update {
	static
	{
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
	} catch (ClassNotFoundException e) {
	
		e.printStackTrace();
	}
	}
	public static void update()  {
		Scanner sc = new Scanner(System.in);
		Connection con=null;
		Statement stmt=null;
		PreparedStatement ps = null;
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","Piyush");
			stmt=con.createStatement();
			System.out.println("Enter id of the email which is to be updated:");
			int ID = sc.nextInt();
			System.out.println("Enter new Email");
			String NewEmail = sc.next();
			String sql = "UPDATE  student set Email = ? where StudentId= ? ";          
            ps = con.prepareStatement(sql);         
            ps.setString(1, NewEmail); 
            ps.setInt(2, ID); 
            int i = ps.executeUpdate();
            if (i > 0) { 
                System.out.println("Product Updated"); 
            } else {
                System.out.println("Error Occured");
            }
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