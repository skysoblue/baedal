package global;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcTest {
	private Connection connection;
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
        Statement stmt = null;
        ResultSet rs = null;
        try {
            
				stmt = JdbcTest.getInstance().getConnection()
						.createStatement();
				rs = stmt.executeQuery("select * from member where userid = 'hong'");
				String temp = null;
				while (rs.next()) {
					temp = rs.getString("name");
				}
				System.out.println("임시값 : "+temp);
        } catch (Exception e ) {
            System.out.println("HSQLDB 에러발생 !!");
            e.printStackTrace();
            return;
        } 
	}
}
