package baedalLogin;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import baedalFirst.FisrtUI;
import baedalOrder.OrderVO;
public class LoginUI extends JFrame implements ActionListener{
   Connection con;
   PreparedStatement pstmt;
   Timestamp reg_date;
		
   
   LoginService service = LoginServiceImpl.getInstance();
   LoginVO vo = new LoginVO();
   
   
   private String names[] = { "아이디", "비밀번호" };
   private JLabel labels[];
   private JTextField fields[];
   private JButton login, join, search;
   private JPanel panelCenter, panelSouth;
   private int size = 2; 
   public LoginUI(){
    super("배달의 기수");   
	   JMenuBar menubar = new JMenuBar();
	   JMenu file = new JMenu("            언제나,  어디서나,  우리는  배달의 기수");
	   menubar.add( file);
	   this.setJMenuBar( menubar);
    
      labels = new JLabel[ size ];
      fields = new JTextField[ size ];
      for ( int i = 0; i < labels.length; i++ )
         labels[ i ] = new JLabel( names[ i ],JLabel.CENTER );
            
      for ( int i = 0; i < fields.length; i++ )
         fields[ i ] = new JTextField();
      panelCenter = new JPanel();
      panelCenter.setLayout( new GridLayout( size, 2 ) );
      for ( int i = 0; i < size; i++ ) {
    	  
         panelCenter.add( labels[ i ] );
         
         panelCenter.add( fields[ i ] );
      }
	  this.setVisible(true);
      login = new JButton("로그인");
      join = new JButton("회원가입");      
      search = new JButton("ID / PW 찾기");      
      panelSouth = new JPanel();      
      panelSouth.add( login );
      panelSouth.add( join);
      panelSouth.add( search );
      panelSouth.add( search );
      add( panelCenter, "Center" );
      add( panelSouth, "South" );     
	  login.addActionListener(this);
      join.addActionListener(this);
      search.addActionListener(this);
	  this.setBounds(300,300,300,150);
	  Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
      Dimension frm = this.getSize();
      int xpos = (int) (screen.getWidth()/2-frm.getWidth()/2);
      int ypos = (int)(screen.getHeight()/2-frm.getHeight()/2);
      this.setLocation(xpos,ypos);
      this.setResizable(false);
      this.setVisible(true);
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   	  }

   		//Database 연결 부분
   		public void dbConnect(){ 
   			try{
   				Class.forName("");
   			}catch(ClassNotFoundException cnfe){
   				cnfe.printStackTrace();
   				System.out.println("드라이버 로딩에 실패");
   			}
   			try{
   				String url = "";
   				String userId = ""; 
   				String userPass = "";          
        
   				con =DriverManager.getConnection(url,userId,userPass);
   			}catch(SQLException e){
   				e.printStackTrace();
   				System.out.println("커넥션 설정에 실패");
   			}
   		}
   
   		// Event 처리 부분
   		public void actionPerformed(ActionEvent ae){
   			switch (ae.getActionCommand()) {
   			case "회원가입":
   				this.dispose(); //지금있는 화면을 날리고
   			   	this.repaint(); // 새화면을 띄운다.
   			   	JoinUI joinUI = new JoinUI();
   				break;
   			case "로그인":
   			 System.out.println("UI에서 실행중 =================");
  		   if (fields[0].getText().isEmpty()||fields[1].getText().isEmpty()) {
  			   JOptionPane.showMessageDialog(this, "아이디 또는 비밀번호를 다시 입력해 주세요.");
  			   break;
  		}else if (service.login(fields[0].getText(), fields[1].getText()).equals("로그인 실패")) {
  			JOptionPane.showMessageDialog(this, "로그인 실패");
  			break;
  		}else{
  			OrderVO vo = new OrderVO(fields[0].getText());//★
  			
 		   	JOptionPane.showMessageDialog(this, "환영합니다.");	
  		   
  		   	this.dispose();
  		   	this.repaint();
  		   	FisrtUI ui = new FisrtUI();
   				break;
  		}

   			case "ID / PW 찾기":
   				this.dispose();
   				this.repaint();
   				SearchUI searchUI = new SearchUI();
   				break;

   			default:
   				break;
   			}
	   
   		}
   		public void idSelect() throws SQLException{
   			String UsrId = null;
   			ResultSet rs = null;
   			int Cnt = 0;
   			UsrId = fields[0].getText();
   			String SQL1 = "SELECT * FROM MEM02 WHERE ID='"+ UsrId +"'";
   			pstmt = con.prepareStatement(SQL1);
   			rs = pstmt.executeQuery();
   			while(rs.next()){
   				Cnt++;
   			}
    
   			if(Cnt > 0){
   				JOptionPane.showMessageDialog(this,"중복된 아이디가 존재 합니다.");
   			}else{
   				JOptionPane.showMessageDialog(this,"아이디 중복검사가 완료되었습니다.\n중복된 아이디가 없습니다.");
   			}
   		}
}
   
//			회원 가입 처리 부분
//   		public void insertMember(){
//   			Timestamp reg_date = new Timestamp(System.currentTimeMillis());
//   			String data[] = getFieldValues();
//   			// if(data[0].equals("") || data[1].equals("") || data[2].equals("") || data[3].equals("")){
//   			if(fields[0].getText().equals("") ||
//   					fields[1].getText().equals("") ||
//   					fields[2].getText().equals("") ||
//   					fields[3].getText().equals("") ){
//   				JOptionPane.showMessageDialog(this,"모든 정보를 입력 하세요!");
//   			}else if(fields[1].getText().equals(fields[2].getText())){
//   				  }else if(data[1].equals(data[2])){ //비밀 번호가 일치하면 query문 실행
//    
//   				String sql = "insert into mem02 values(?,?,?,?)";
//      
//   				try{
//   					pstmt = con.prepareStatement(sql);
//   					          pstmt.setString(1,data[0]);  //아이디
//   					          pstmt.setString(2,data[1]);  //비밀번호
//   					          pstmt.setString(3,data[3]);  //이름
//    
//   					pstmt.setString(1,fields[0].getText());  //아이디
//   					pstmt.setString(2,fields[1].getText());  //비밀번호
//   					pstmt.setString(3,fields[3].getText());  //이름
//          
//   					pstmt.setTimestamp(4, reg_date); //회원가입 날짜
//   					int result = pstmt.executeUpdate();    
//   					if(result == 1){
//   						JOptionPane.showMessageDialog(this,"회원 가입 완료");
//   						//     this.dispose();    
//   						// MemberManagement management= new MemberManagement();
//   					}else{
//   						JOptionPane.showMessageDialog(this,"회원 가입 실패");
//   					}
//    
//   				}catch(SQLException e){
//   					e.printStackTrace();
//   					System.out.println("새로운 레코드 추가에 실패");
//   				}
//   			}else{ //비밀 번호가 일치하지 않으면 메시지 박스
//   				JOptionPane.showMessageDialog(this,"비밀번호가 일치하지 않습니다.");
//   			}
//   		}  
//   
//   		// 다시 작성 처리 부분
//   		public void clearFields(){
//   			for( int i = 0; i < size; i++ ){
//   				fields[ i ].setText("");
//   			}
//   		}
//   		// 입력한 회원 정보값을 구하는 부분
//   		public String[] getFieldValues(){ 
//   			String values[] = new String[ size ];
//   			for ( int i = 0; i < size; i++ ) 
//   				values[ i ] = fields[ i ].getText();
//   			return values;
//   		}
