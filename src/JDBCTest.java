import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTest {

	 public static void main(String[] args) throws ClassNotFoundException, SQLException
	 {
		 System.out.println("connecting to database");
		 
		 Class.forName("com.mysql.cj.jdbc.Driver");
		 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/neon","root","root");
		 //need to 
		 System.out.println("connection established");
		 Statement st = con.createStatement();
		 ResultSet rs = st.executeQuery("Select * from alien");
		 
		 while (rs.next())
		 {
			 System.out.println(rs.getInt("aid"));
			 System.out.println(rs.getString("aname"));
			 System.out.println(rs.getString("color"));
			 System.out.println("-------------");
		
		 }
		 
		 
		 int n = st.executeUpdate("Create table pubneshwar(emp_id int, emp_name varchar(30), emp_salary int)");
		 
		 //table created
		 
		 
		 
		 System.out.println("number of rows affected " + n) ;
		 
		 int n1= st.executeUpdate("insert into pubneshwar values (1,'harami',2000)");
		 System.out.println("number of rows affected" + n1);
		 
		 int n2 = st.executeUpdate("update pubneshwar set emp_name = 'phulwari' where emp_id=1");
		 System.out.println("number of rows affected" + n2);
		 
		 int n3 = st.executeUpdate("delete from pubneshwar where emp_id = 1");
		 System.out.println("number of rows affected" + n3);
	 }
}
