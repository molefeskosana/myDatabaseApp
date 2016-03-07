package jdbcdemo;

//My login
import java.sql.*;
public class Driver {

	public static void main(String[] args) {
		try{
			// 1.Get a connection to a database 
				Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/churchdb","root","molefe");
			// 2.Create a statement.
				Statement myStmt = myConn.createStatement();
				
			// 3.Execute a SQL query.
				ResultSet myRs = myStmt.executeQuery("select * from congregantstb;");
			
			// 4.Process the result set.
				while(myRs.next()){
					System.out.println(myRs.getString("first_name")+ ", " + myRs.getString("last_name")+", "+myRs.getString("birth_date")+", "+myRs.getString("gender")+
						","+	myRs.getString("contact")+", "+myRs.getString("email")+", "+myRs.getString("address")+", "+myRs.getString("membership_duration")
						+", "+ myRs.getString("baptism_status"));
				}
		}catch(Exception exc){
			exc.printStackTrace();
		}
	}

}
