package global;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcTest {
	private static Connection connection;
	private static JdbcTest instance = new JdbcTest();
	private JdbcTest() {
		try {
			Class.forName(Constants.HSQL_DRIVER);
			connection = DriverManager.getConnection(
					Constants.HSQL_URL,
					Constants.HSQL_ID,
					Constants.HSQL_PASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static JdbcTest getInstance() {
		return instance;
	}
	public Connection getConnection() {
		return connection;
	}

	public static void main(String[] args) {
        PreparedStatement pstmt = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
    		String sql = "SELECT * FROM TEST";
    		connection = JdbcTest
    				.getInstance()
    				.getConnection();
    		if(connection == null){
				System.out.println("Connection 이 널");
			} else {
				stmt = connection.createStatement();
			}
			rs = stmt.executeQuery(sql);
			String temp = null;
			while (rs.next()) {
				temp = rs.getString("TEST");
			}
			System.out.println("임시값 : "+temp);
        } catch (Exception e ) {
            System.out.println("HSQLDB 에러발생 !!");
            e.printStackTrace();
            return;
        } 
	}
	
}
