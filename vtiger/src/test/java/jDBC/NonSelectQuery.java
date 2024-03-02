package jDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

public class NonSelectQuery {
public static void main(String[] args) throws SQLException {
	//My Sql Instance
		Driver dataBaseDriver = new Driver();
		////JDBC register with My Sql
		DriverManager.registerDriver(dataBaseDriver);
		//Connection Establish
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/vtiger2", "root", "root");
		//Query Pass
		  int result = connection.createStatement().executeUpdate("insert into lead value(3,'king kong','jungie');");
		//Result
		if(result==1) {
			System.out.println("The Database has been updated");
		}
		else
			System.out.println("The Database has not been updated");
		
		
	connection.close();
}
}
