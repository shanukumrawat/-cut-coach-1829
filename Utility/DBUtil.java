package Utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

public static Connection provideConnection() {
		
		Connection con =  null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Problem is loading in the driver....");
			e.printStackTrace();
		}
		
		
		String url="jdbc:mysql://localhost:3306/sb101project";
		
		
		try {
			con=DriverManager.getConnection(url,"root","Shaili");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return con;
	}
}
