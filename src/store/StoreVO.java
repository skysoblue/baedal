package store;

import java.io.Serializable;

import global.SQL;

public class StoreVO implements Serializable, SQL{
	private static final long serialVersionUID = 1L;
	private int storeSeq;
	private String bizName;
	private int foodCateSeq;
	
	public StoreVO() {}
	
	public StoreVO(int stroeSeq, String bizName, int foodCateSeq) {
		this.storeSeq = stroeSeq;
		this.bizName = bizName;
		this.foodCateSeq = foodCateSeq;
	}
	
	public int getStoreSeq() {
		return storeSeq;
	}

	public String getBizName() {
		return bizName;
	}

	public int getFoodCateSeq() {
		return foodCateSeq;
	}

	public void setStoreSeq(int storeSeq) {
		this.storeSeq = storeSeq;
	}

	public void setBizName(String bizName) {
		this.bizName = bizName;
	}

	public void setFoodCateSeq(int foodCateSeq) {
		this.foodCateSeq = foodCateSeq;
	}

	@Override
	public String toString() {
		return "StoreVO [상호명=" + bizName + "]";
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

