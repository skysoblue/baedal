package baedalOrder;

import java.io.Serializable;

import global.SQL;

public class OrderVO implements Serializable, SQL{

	private static final long serialVersionUID = 1L;
	private static String userid;
	private static int seq;
	private String password, name, phone, addr, brith;
	private String foodName, profile, price;
	private int menuSeq;

public static int getSeq() {
		return seq;
	}
	public String getPassword() {
		return password;
	}
	public String getName() {
		return name;
	}
	public String getPhone() {
		return phone;
	}
	public String getAddr() {
		return addr;
	}
	public String getBrith() {
		return brith;
	}
	public String getFoodName() {
		return foodName;
	}
	public String getProfile() {
		return profile;
	}
	public String getPrice() {
		return price;
	}
	public int getMenuSeq() {
		return menuSeq;
	}
	public static void setSeq(int seq) {
		OrderVO.seq = seq;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public void setBrith(String brith) {
		this.brith = brith;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public void setMenuSeq(int menuSeq) {
		this.menuSeq = menuSeq;
	}
	//	================Member====================
	public OrderVO() {
		// TODO Auto-generated constructor stub
	}
	public OrderVO(int seq) {
		this.seq = seq;
	}
	
	public static int getseq(){
		return seq;
	}
	public void setseq(int seq){
		this.seq = seq;
	}
	
	public static String getUserid() {
		return userid;
	}

	public static void setUserid(String userid) {
		OrderVO.userid = userid;
	}

	public OrderVO(String userid) {
		this.userid = userid;
	}

	@Override
	public String make(String s) {
		return "'"+s+"'";
	}
	
	public String selectPrice(String s) {
		String query = "select * from store_menu where menu_seq = " + this.make(s);
		return query;
	}
	public String selectMenu(String s){
		String query = "select * from menu where menu_seq = " + this.make(s);
		return query;
	}
	public String selectMember(String s){
		String query = "select * from member where userid = " +this.make(s);
		return query;
	}

}
