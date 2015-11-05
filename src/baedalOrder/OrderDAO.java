package baedalOrder;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import global.Constants;
import global.DAO;
import global.DatabaseFactory;
import global.Vendor;

public class OrderDAO extends DAO{
	private Connection con;
	private Statement stmt;
	private ResultSet rs;
	OrderVO vo = new OrderVO();
	
	private static OrderDAO instance = new OrderDAO();
	public static OrderDAO getInstance() {
		return instance;
	}
	
	public OrderDAO() {
	con = DatabaseFactory.getDatabase(Vendor.ORACLE, Constants.ORACLE_ID, Constants.ORACLE_PASSWORD).getConnection();
	}
	
	@Override
	public void selectOrderMember() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void selectOrderMenu() {
	
		
	}
	//=================================//
	
	public String searchPrices(String seq) {
		String result = "";
		try {
			rs = con.createStatement().executeQuery(vo.selectPrice(seq));
			while (rs.next()) {
				result = rs.getString("price");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println(result+"테이블 비교 결과 가격");
		return result;
	}
	
	public String[] searchMember(String userid) {
		String[] result = new String[4];
		try {
			rs = con.createStatement().executeQuery(vo.selectMember(userid));
			while (rs.next()) {
				result[0] = rs.getString("userid");
				result[1] = rs.getString("name");
				result[2] = rs.getString("phone");
				result[3] = rs.getString("addr");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
	public String searchMenu(String seq) {
		String result = "";
		try {
			rs = con.createStatement().executeQuery(vo.selectMenu(seq));
			while(rs.next()){
				result = rs.getString("food_name");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}


}
