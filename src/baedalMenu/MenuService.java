package baedalMenu;

public interface MenuService {

   // 멤버 검색..
   public void  getOrderMember();
   
   // 메뉴검색..
   public void getOrderMenu();
   
   //메뉴검색
   public int getMenuSeq(String foodName);
   
   // 가격을 넘겨줘
   public int getPrice(int menuSeq);
   
}