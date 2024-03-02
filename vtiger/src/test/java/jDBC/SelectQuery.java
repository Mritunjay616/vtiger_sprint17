package jDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

public class SelectQuery {
public static void main(String[] args) throws SQLException {
	//My Sql Instance
	Driver dataBaseDriver = new Driver();
	////JDBC register with My Sql
	DriverManager.registerDriver(dataBaseDriver);
	//Connection Establish
	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/vtiger2", "root", "root");
	//Query Pass
	ResultSet result = connection.createStatement().executeQuery("select * from lead;");
	//Result
	while(result.next()) {
		System.out.println(result.getString(2));
	}
	
	connection.close();
}
}
