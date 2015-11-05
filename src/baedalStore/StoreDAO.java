package baedalStore;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.ResultSet;

import global.Constants;
import global.DAO;
import global.DatabaseFactory;
import global.Vendor;

public class StoreDAO extends DAO{
	
	private Connection con;
	private Statement stmt;
	private ResultSet res;
	
	
	private static StoreDAO instance = new StoreDAO();
	public static StoreDAO getInstance() {
		return instance;
	}
	
	public StoreDAO() {
	con = DatabaseFactory.getDatabase(Vendor.ORACLE, Constants.ORACLE_ID, Constants.ORACLE_PASSWORD).getConnection();
	}
	
	@Override
	public String login(String id, String pass) {
		String result= "";
		return result;
		
	}

	@Override
	public void selectOrderMember() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void selectOrderMenu() {
		// TODO Auto-generated method stub
		
	}


}
