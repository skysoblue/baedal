package baedalLogin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import global.Constants;
import global.DAO;
import global.DatabaseFactory;
import global.Vendor;

public class LoginDAO extends DAO{
	private Connection con;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private List<LoginVO> list = new ArrayList<LoginVO>();
	private LoginVO login = new LoginVO();
	String aaa;
	
	private static LoginDAO instance = new LoginDAO();
	public static LoginDAO getInstance() {
		return instance;
	}
	public LoginDAO() {
	con = DatabaseFactory.getDatabase(Vendor.ORACLE, Constants.ORACLE_ID, Constants.ORACLE_PASSWORD).getConnection();
	}
	
	//--------------- 회원가입
		@Override
		public int insert(LoginVO o) {
			int result = 0;
			try {
				pstmt = con.prepareStatement(o.insert());
				pstmt.setString(1, o.getUserid());
				pstmt.setString(2, o.getPassword());
				pstmt.setString(3, o.getName());
				pstmt.setString(4, o.getPhone());
				pstmt.setString(5, o.getAddr());
				pstmt.setString(6, o.getBirth());
				pstmt.setString(7, o.getQue());
				pstmt.setString(8, o.getAns());
				result = pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return result;
		}
	
		@Override // -----------------로그인
		public String login(String userid, String pass) {
			String result = "";
			
			try {
				
			//	stmt = con.createStatement();
			//	rs = stmt.executeQuery("select * from member where userid = 'lee' and password = '1'");
				pstmt = con.prepareStatement("select * from member where userid = ? and password = ?");
				System.out.println("userid"+userid);
				System.out.println("password"+pass);
				pstmt.setString(1, userid);
				pstmt.setString(2, pass);
				rs = pstmt.executeQuery();
				/*
				while (rs.next()) {
					temp.setUserid(rs.getString("userid"));
					temp.setPassword(rs.getString("password"));
					temp.setName(rs.getString("name"));
					temp.setPhone(rs.getString("phone"));
					temp.setAddr(rs.getString("addr"));
					temp.setBirth(rs.getString("birth"));
					temp.setQue(rs.getString("que"));
					temp.setAns(rs.getString("ans"));
				}
				*/
				if (rs.next()) {
					do {
						System.out.println("******************TRUE********************* ");
						result = "로그인 성공";
					
					} while (rs.next());
					
				} else {
					
					System.out.println("******************FALSE********************* ");
					result = "로그인 실패";
					
				}
					
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return result;
		}		
	
		public List<LoginVO> selectAll() {
			List<LoginVO>temp = new ArrayList<LoginVO>();
			
			try {
				stmt = con.createStatement();
				rs = stmt.executeQuery(login.selectAll());
				while (rs.next()) {
					LoginVO vo = new LoginVO();
					vo.setUserid(rs.getString("userid"));
					vo.setPassword(rs.getString("password"));
					vo.setName(rs.getString("name"));
					vo.setPhone(rs.getString("phone"));
					vo.setAddr(rs.getString("addr"));
					vo.setBirth(rs.getString("birth"));
					vo.setQue(rs.getString("que"));
					vo.setAns(rs.getString("ans"));
					temp.add(vo);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			
			return temp;
			
		}

		public List<LoginVO> searchById(String name, String birth) {
			List<LoginVO> list = new ArrayList<LoginVO>();
			
			try {
				stmt = con.createStatement();
				rs = stmt.executeQuery(login.selectByID(name, birth));
				System.out.println("디버깅");
				while (rs.next()) {
					LoginVO result = new LoginVO();
					result.setUserid(rs.getString("userid"));
					result.setPassword(rs.getString("password"));
					result.setName(rs.getString("name"));
					result.setPhone(rs.getString("phone"));
					result.setAddr(rs.getString("addr"));
					result.setBirth(rs.getString("birth"));
					result.setQue(rs.getString("que"));
					result.setAns(rs.getString("ans"));
					list.add(result);

					/* list.add(result); */
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			System.out.println("디버깅");
			return list;
		}

		public List<LoginVO> searchByPass(String id, String que, String ans) {
			List<LoginVO> list = new ArrayList<LoginVO>();
			try {
				stmt = con.createStatement();
				rs = stmt.executeQuery(login.selectByPass(id, que, ans));
				while (rs.next()) {
					LoginVO result = new LoginVO();
					result.setUserid(rs.getString("userid"));
					result.setPassword(rs.getString("password"));
					result.setName(rs.getString("name"));
					result.setPhone(rs.getString("phone"));
					result.setAddr(rs.getString("addr"));
					result.setBirth(rs.getString("birth"));
					result.setQue(rs.getString("que"));
					result.setAns(rs.getString("ans"));
					list.add(result);

				}

			} catch (SQLException e) {
				e.printStackTrace();
			}

			return list;
		}
		@Override
		public void selectOrderMember() {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void selectOrderMenu() {
			// TODO Auto-generated method stub
			
		}
		public boolean checkDupl(String id) {
			// 저장되어 있는 아이디 값과 내가 입력한 아이디값을 비교,

			boolean exist = false;
			LoginVO temp = new LoginVO();
			try {	
				stmt = con.createStatement();
				rs = stmt.executeQuery(login.checkID(id));
				
				while (rs.next()) { // 있을 떄
					if (rs.getString("userid") != null) {//?
						exist = true;				
					} else {
						exist = false;
					}
//					temp.setUserid(rs.getString("userid"));
				}
				System.out.println(exist);
//				System.out.println("실험"+temp.getUserid().equals(id));
//				if (temp.getUserid().equals(id)) {
//					exist = true;
//				} else if (!temp.getUserid().equals(id)) {
//					System.out.println("실험"+(!temp.getUserid().equals(id)));
//					exist = false;
//				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
			return exist;
		}




}