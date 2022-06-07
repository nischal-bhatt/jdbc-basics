import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PreparedStatementClass {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// processing a query
		// stage 1 - parse the query
		// stage 2 - generate an execution plan
		// stage 3 - execute the query
		// preparedstatement -- will compile only once with the question marks
		// will be replaced with the actual values at runtime
		// prepared statements are more preferable

		System.out.println("connecting to database");

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/neon", "root", "root");
		// need to
		System.out.println("connection established");

		PreparedStatement ps = con.prepareStatement("insert into pubneshwar values (?,?,?)");
		ps.setInt(1, 101);
		ps.setString(2, "ratlam");
		ps.setInt(3, 3000);
		ps.executeUpdate();
		
		ps.setInt(1, 102);
		ps.setString(2, "ratlamkigali");
		ps.setInt(3, 3000);
		ps.executeUpdate();
		
		
		PreparedStatement ps2 = con.prepareStatement("update pubneshwar set emp_name=? where emp_id = ?");
		ps2.setString(1, "nish");
		ps2.setInt(2,101);
		int numOfRowsAffected=ps2.executeUpdate();
		
		PreparedStatement ps3 = con.prepareStatement("delete from pubneshwar where emp_id = ?");
		ps3.setInt(1, 102);
		ps3.executeUpdate();
		
		System.out.println("hi");
	}
}
