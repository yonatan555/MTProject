package com.app.sqlconnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Properties;
import org.springframework.stereotype.Component;
@Component
public class MysqlConnect {
//	public static void main(String[] args) {
//		try
//		{
//		MysqlConnect a = new MysqlConnect();
//		Connection ab = a.connect();
//		String query = "Select * from students;";
//		Statement st = ab.createStatement();  
//	    ResultSet rs = st.executeQuery(query);
//	    
//		 while (rs.next())
//	      {
//	        int id = rs.getInt("studentId");
//	        String firstName = rs.getString("firstName");
//	        String lastName = rs.getString("lastName");
//	        String password = rs.getString("password");
//	        String Email = rs.getString("Email");
//	        // print the results
//	        System.out.format("%s, %s, %s, %s, %s\n", id, firstName, lastName, password,Email);
//	      }
//		}catch (Exception e) {
//			System.out.println(e);
//		}
//	}
	// init database constants
    private static final String DATABASE_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DATABASE_URL = "jdbc:mysql://database-3.cbtp5hb0aaai.us-east-2.rds.amazonaws.com:3306/studies";
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "Daniel10!";
    
    // init connection object
    private Connection connection;
    // init properties object
    private Properties properties;

    // create properties
    private Properties getProperties() {
        if (properties == null) {
            properties = new Properties();
            properties.setProperty("user", USERNAME);
            properties.setProperty("password", PASSWORD);
        }
        return properties;
    }

    // connect database
    public Connection connect() {
        if (connection == null) {
            try {
                Class.forName(DATABASE_DRIVER);
                connection = DriverManager.getConnection(DATABASE_URL, getProperties());
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    // disconnect database
    public void disconnect() {
        if (connection != null) {
            try {
                connection.close();
                connection = null;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}