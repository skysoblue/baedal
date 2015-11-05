package baedalStore;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.net.URL;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import baedalMenu.MenuUI;

public class StoreUI extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	protected JButton b1, b2, b3, b4, b5, b6, b7, b8;
	protected JPanel jpSouth, jpNorth, jpTop;
	ImageIcon top1ButtonIcon, top2ButtonIcon, top3ButtonIcon, top4ButtonIcon, top5ButtonIcon
	,top6ButtonIcon, top7ButtonIcon, top8ButtonIcon;
	JButton jb;
	private String id;
	StoreVO vo = new StoreVO();
	
	public StoreUI() {
		
//		  ImageIcon[] temp = new ImageIcon[8]; for (int i = 1; i < 9; i++) {
//		  temp[i]= new ImageIcon("src/한식종류/i.png"); }
//		  id = service.getId(); 
//		URL imageBo = getClass().getClassLoader().getResource("image/category/Bo.gif");
//		btnBo.setIcon(new ImageIcon(imageBo));			

		
		jpNorth = new JPanel();	
		
		URL imageHan1 = getClass().getClassLoader().getResource("images/han1.PNG");
		top1ButtonIcon = new ImageIcon(imageHan1);
		b1 = new JButton(top1ButtonIcon);
		b1.setPreferredSize(new Dimension(300, 212));
		
		URL imageHan2 = getClass().getClassLoader().getResource("images/han2.PNG");
		top2ButtonIcon = new ImageIcon(imageHan2);
		b2 = new JButton(top2ButtonIcon);
		b2.setPreferredSize(new Dimension(300, 212));
		
		URL imageHan3 = getClass().getClassLoader().getResource("images/han3.PNG");
		top3ButtonIcon = new ImageIcon(imageHan3);
		b3 = new JButton(top3ButtonIcon);
		b3.setPreferredSize(new Dimension(300, 212));
		
		URL imageHan4 = getClass().getClassLoader().getResource("images/han4.PNG");
		top4ButtonIcon = new ImageIcon(imageHan4);
		b4 = new JButton(top4ButtonIcon);
		b4.setPreferredSize(new Dimension(300, 212));
		
		
		jpSouth = new JPanel();
		URL imageHan5 = getClass().getClassLoader().getResource("images/han5.PNG");
		top5ButtonIcon = new ImageIcon(imageHan5);
		b5 = new JButton(top5ButtonIcon);
		b5.setPreferredSize(new Dimension(300, 212));
		
		URL imageHan6 = getClass().getClassLoader().getResource("images/han6.PNG");
		top6ButtonIcon = new ImageIcon(imageHan6);
		b6 = new JButton(top6ButtonIcon);
		b6.setPreferredSize(new Dimension(300, 212));
		
		URL imageHan7 = getClass().getClassLoader().getResource("images/han7.PNG");
		top7ButtonIcon = new ImageIcon(imageHan7);
		b7 = new JButton(top7ButtonIcon);
		b7.setPreferredSize(new Dimension(300, 212));
		
		URL imageHan8 = getClass().getClassLoader().getResource("images/han8.PNG");
		top8ButtonIcon = new ImageIcon(imageHan8);
		b8 = new JButton(top8ButtonIcon);
		b8.setPreferredSize(new Dimension(300, 212));

		// Listen for actions on buttons 1 and 3.

		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		b7.addActionListener(this);
		b8.addActionListener(this);

		/*
		 * b1.setToolTipText("Click this button to disable the middle button.");
		 * b2.setToolTipText(
		 * "This middle button does nothing when you click it.");
		 * b3.setToolTipText("Click this button to enable the middle button.");
		 */

// 		Add Components to this container, using the default FlowLayout.
		jpNorth.add(b1);
		jpNorth.add(b2);
		jpNorth.add(b3);
		jpNorth.add(b4);
		jpSouth.add(b5);
		jpSouth.add(b6);
		jpSouth.add(b7);
		jpSouth.add(b8);

		this.add(jpNorth, BorderLayout.NORTH);
		this.add(jpSouth, BorderLayout.SOUTH);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Display the window.
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frm = this.getSize();
		int xpos = (int) (screen.getWidth()/2-frm.getWidth()/2);
		int ypos = (int)(screen.getHeight()/2-frm.getHeight()/2);
		this.setLocation(xpos,ypos);
		this.setResizable(false);
		this.pack();
		this.setBounds(100, 50, 1400, 800);
		this.setTitle("배달의 기수");
		this.setVisible(true);

	}

	public void actionPerformed(ActionEvent e) {
		JButton temp = (JButton) e.getSource();
		if (temp.equals(b1)) {
			/* service.setStroe(id,"김밥천국");*/
		
			this.dispose();
			this.repaint();
			MenuUI ui = new MenuUI();
		}else if(temp.equals(b2)) {
			this.dispose();
			this.repaint();
			MenuUI ui = new MenuUI();
		}else if(temp.equals(b3)) {
			this.dispose();
			this.repaint();
			MenuUI ui = new MenuUI();
		}else if(temp.equals(b4)) {
			this.dispose();
			this.repaint();
			MenuUI ui = new MenuUI();
		}else if(temp.equals(b5)) {
			this.dispose();
			this.repaint();
			MenuUI ui = new MenuUI();
		}else if(temp.equals(b6)) {
			this.dispose();
			this.repaint();
			MenuUI ui = new MenuUI();
		}else if(temp.equals(b7)) {
			//service.setMenu("육개장");
			this.dispose();
			this.repaint();
			MenuUI ui = new MenuUI();
		}else if(temp.equals(b8)) {
			this.dispose();
			this.repaint();
			MenuUI ui = new MenuUI();
		}		
	}
}

/* 		Returns an ImageIcon, or null if the path was invalid. */
/*
		protected static ImageIcon createImageIcon(String path) {
		java.net.URL imgURL = StoreUI.class.getResource(path);
		if (imgURL != null) {
			return new ImageIcon(imgURL);
		} else {
			System.err.println("파일의 경로가 잘못 되었습니다. : " + path);
			return null;
		}
	}
*/
