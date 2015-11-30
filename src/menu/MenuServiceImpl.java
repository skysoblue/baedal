package menu;

import java.util.List;

public class MenuServiceImpl implements MenuService{
   MenuDAO dao = MenuDAO.getInstance();
   
   private static MenuServiceImpl instance = new MenuServiceImpl();
   public static MenuServiceImpl getInstance(){
      return instance;
   }
   
   @Override
   public void getOrderMember() {
      // TODO Auto-generated method stub
   }

   @Override
   public void getOrderMenu() {
      // TODO Auto-generated method stub
      
   }

   @Override
   public int getMenuSeq(String foodName) {
	   //System.out.println(dao.selectMenuSeq(foodName)+"=====================");
      return dao.selectMenuSeq(foodName);
   }

   @Override
   public int getPrice(int menuSeq) {
      return dao.selectPrice(menuSeq);
   }

	@Override
	public String[] getMenuImagesBy(int CateSeq) {
		// TODO Auto-generated method stub
		return dao.selectMenuImagesBy(CateSeq);
	}
	
	@Override
	public String[] getProfileImages() {
		// TODO Auto-generated method stub
		return null;
	}

}