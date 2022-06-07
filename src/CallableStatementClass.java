import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CallableStatementClass {

	public static void main(String[] args) throws ClassNotFoundException, SQLException
	{
 System.out.println("connecting to database");
		 
		 Class.forName("com.mysql.cj.jdbc.Driver");
		 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/neon","root","root");
		 //need to create storedproceuder in db
		    
		    
		
		  /*
		   
		  delimiter //
Create PROCEDURE insert_studentinfo(IN p_id int, IN p_name varchar(20),IN p_Address Varchar(20), IN p_subject Varchar(20))
	BEGIN
     insert into student_info(id, name, address, subject) values (p_id, p_name,p_address, p_subject);
     END//
      // this is created in db
		   
		   */
		 
		 /*
		 CallableStatement statement = con.prepareCall("{call insert_studentinfo2(?,?,?,?)}");
		 statement.setInt(1, 1);
		 statement.setString(2, "abu");
		 statement.setString(3, "mparade");
		 statement.setString(4, "geog");
		 int n = statement.executeUpdate();
		 
		 statement.setInt(1, 2);
		 statement.setString(2, "mohali");
		 statement.setString(3, "ara");
		 statement.setString(4, "rrr");
		 int n1 = statement.executeUpdate();
		 
		 System.out.println("connection established");
		 */
		 
		 /*
		  DELIMITER //
create procedure getstudentinfo( in p_idin int, 
								 out p_address varchar(20),
								 out p_subject varchar(20))
                                 begin
                                 select p_address,p_subject from student_info where p_id = p_idin;
                                 
                                 END //
                                 DELIMITER ;
		  */
		 
		 CallableStatement st1= con.prepareCall("{call getstudentinfo3()}");
		 //st1.setInt(1,3);
		 //st1.registerOutParameter(2,java.sql.Types.VARCHAR);
		 //st1.registerOutParameter(3,java.sql.Types.VARCHAR);
		 //st1.executeQuery();
		 
		// String add=st1.getString(2);
		// String subj=st1.getString(3);
		 
		// System.out.println(add + subj);
		 
		 int rs = st1.executeUpdate();
		 
		 ResultSet rr = st1.getResultSet();
		 
		 while (rr.next())
		 {
			 System.out.println(rr.getString("p_address"));
		
		 }
		 
		 /*
		  DELIMITER //
create procedure getstudentinfo3 ()
                                 begin
                                 select * from student_info where p_id = p_id;
                                 
                                 END //
                                 DELIMITER ;
		  */
		 
	}
}
