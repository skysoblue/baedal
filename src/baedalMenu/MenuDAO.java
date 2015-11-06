package baedalMenu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import global.Constants;
import global.DAO;
import global.DatabaseFactory;
import global.Vendor;

public class MenuDAO extends DAO{
   private Connection connection;
   private Statement stmt;
   private ResultSet rs;
   private MenuVO menu = new MenuVO();
   private StoreMenuVO smv = new StoreMenuVO();
   
   private static MenuDAO instance = new MenuDAO();
   
   public static MenuDAO getInstance(){
      return instance;
   }
   
   public MenuDAO() {
	   try {
			/**
			 * 오라클 커넥션
			 * connection = DatabaseFactory.getDatabase(Vendor.ORACLE,
			 *               Constants.ORACLE_ID, 
			 *               Constants.ORACLE_PASSWORD)
			 *               .getConnection();
			 */
			// HSQL 커넥션
			Class.forName(Constants.HSQL_DRIVER);
			connection = DriverManager.getConnection(
					Constants.HSQL_URL,
					Constants.HSQL_ID,
					Constants.HSQL_PASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
		}
   }
   @Override
   public void selectOrderMember() {
      // TODO Auto-generated method stub
      
   }
   
   public MenuVO selectOrderMenu(String foodName) {
	      MenuVO menu = new MenuVO();
	      try {
	         stmt = connection.createStatement();
	         rs= stmt.executeQuery(menu.selectMenu(foodName));
	         while (rs.next()) {
	            menu.setFoodName(rs.getString("food_Name"));
	         }
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }
	      return menu;
	   }
   
   public int selectMenuSeq(String foodName) {
      MenuVO temp = new MenuVO();
      System.out.println("DAO 셀렉메뉴시퀀스 진입");
      try {
         rs= connection.createStatement().executeQuery(temp.selectMenu(foodName));
         while (rs.next()) {
            temp.setMenuSeq(rs.getInt("menu_seq"));
         }
      } catch (SQLException e) {
         e.printStackTrace();
      }
      System.out.println("DAO 셀렉 결과 : " + temp.getMenuSeq());
      return temp.getMenuSeq();
   }
   
   // === 가격을 넘겨주는 메소드 ====
   public int selectPrice(int menuSeq) {
      MenuVO temp = new MenuVO();
      try {
         stmt = connection.createStatement();
         rs= stmt.executeQuery(menu.selectPrice(menuSeq));
         while (rs.next()) {
            smv.setPrice(rs.getInt("price"));
         }
      } catch (SQLException e) {
         e.printStackTrace();
      }
      
      return smv.getPrice();
   }

@Override
public void selectOrderMenu() {
	// TODO Auto-generated method stub
	
}


}