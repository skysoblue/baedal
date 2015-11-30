package menu;

import java.io.Serializable;

import global.SQL;

public class MenuVO implements Serializable, SQL {

	private static final long serialVersionUID = 1L;
	private int menuSeq;
	private String foodName;
	private String foodImage;

	public int getMenuSeq() {
		return menuSeq;
	}

	public void setMenuSeq(int menuSeq) {
		this.menuSeq = menuSeq;
	}

	// =================메뉴 검색==================

	public String getFoodName() {
		return foodName;
	}

	public String getFoodImage() {
		return foodImage;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public void setFoodImage(String foodImage) {
		this.foodImage = foodImage;
	}

	public String selectMenu(String s) {
		String qurey = "select * from menu where food_name = " + make(s);
		return qurey;
	}

	// =========== 가격 검색 ======================

	public String selectPrice(int menuSeq) {
		String qurey = "select price from store_menu s inner join menu m " + "on s.menu_seq = m.menu_seq "
				+ "where s.menu_seq = " + menuSeq;
		return qurey;
	}

	@Override
	public String make(String s) {
		return "'" + s + "'";
	}
}