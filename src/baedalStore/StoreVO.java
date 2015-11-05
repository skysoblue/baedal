package baedalStore;

import java.io.Serializable;

import global.SQL;

public class StoreVO implements Serializable, SQL{
	private static final long serialVersionUID = 1L;
	private String temp;
	private String storeSeq;
	private String bizName;
	private String foodCateSeq;
	
	public StoreVO() {
		// TODO Auto-generated constructor stub
	}
	
	public StoreVO(String temp, String stroeSeq, String bizName, String foodCateSeq) {
		this.temp = temp;
		this.storeSeq = stroeSeq;
		this.bizName = bizName;
		this.foodCateSeq = foodCateSeq;
	}
	
	
	
	public String getStoreSeq() {
		return storeSeq;
	}

	public String getBizName() {
		return bizName;
	}

	public String getFoodCateSeq() {
		return foodCateSeq;
	}

	public void setStoreSeq(String storeSeq) {
		this.storeSeq = storeSeq;
	}

	public void setBizName(String bizName) {
		this.bizName = bizName;
	}

	public void setFoodCateSeq(String foodCateSeq) {
		this.foodCateSeq = foodCateSeq;
	}

	
	
	
	
	
	@Override
	public String toString() {
		return "StoreVO [상호명=" + bizName + "]";
	}

	public String getTemp() {
		return temp;
	}

	public void setTemp(String temp) {
		this.temp = temp;
	}

	
//	=================식당 검색==================

	public String selectStore() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String make(String s) {
		// TODO Auto-generated method stub
		return null;
	}


}

