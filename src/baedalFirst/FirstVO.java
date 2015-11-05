package baedalFirst;

import java.io.Serializable;

import global.SQL;

public class FirstVO implements Serializable, SQL{
	
	private static final long serialVersionUID = 1L;
	private String temp1;
	

	public String getTemp1() {
		return temp1;
	}

	public void setTemp1(String temp1) {
		this.temp1 = temp1;
	}

//	=================카테고리 검색==================
	public String selectCate() {
		// TODO Auto-generated method stub
		return null;
	}

	
	public String selectCate(String s) {
		String qurey = "select * from food_cate where store_menu = "+make(s);
		return qurey;
	}
	
	@Override
	public String make(String s) {
		return "'"+s+"'";
	}

	

}
