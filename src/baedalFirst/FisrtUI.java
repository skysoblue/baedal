package baedalFirst;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import baedalLogin.LoginVO;
import baedalStore.StoreUI;
import global.StdDimention;

public class FisrtUI extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	Canvas canvas;
	JButton btnHan,btnJoong,btnIl,btnChi,btnPi,btnBo;
	JPanel panelNorth, panelCenter,panelSouth;
	ImageIcon icon;
	LoginVO lo = new LoginVO();
	FirstVO vo = new FirstVO();
	
	public FisrtUI() {
		init();
	}
	public void init(){
		this.setTitle("배달의기수");
		panelNorth = new JPanel();
		panelCenter = new JPanel();
		panelSouth = new JPanel();
		btnHan = new JButton("한식");
		URL imageHan = getClass().getClassLoader().getResource("images/cate_korean_food.jpg");
		btnHan.setIcon(new ImageIcon(imageHan));
		btnJoong = new JButton("중식");
		URL imageJoong = getClass().getClassLoader().getResource("images/cate_chinese_food.jpg");
		btnJoong.setIcon(new ImageIcon(imageJoong));
		btnIl = new JButton("일식");
		URL imageIl = getClass().getClassLoader().getResource("images/cate_japanese_food.jpg");
		btnIl.setIcon(new ImageIcon(imageIl));
		btnChi = new JButton("치킨");
		URL imageChi = getClass().getClassLoader().getResource("images/cate_chicken.jpg");
		btnChi.setIcon(new ImageIcon(imageChi));
		btnPi = new JButton("피자");
		URL imagePi = getClass().getClassLoader().getResource("images/cate_pizza.jpg");
		btnPi.setIcon(new ImageIcon(imagePi));
		btnBo = new JButton("보쌈,족발");
		URL imageBo = getClass().getClassLoader().getResource("images/cate_bossam.jpg");
		btnBo.setIcon(new ImageIcon(imageBo));
		btnHan.addActionListener(this);
		btnJoong.addActionListener(this);
		btnIl.addActionListener(this);
		btnChi.addActionListener(this);
		btnPi.addActionListener(this);
		btnBo.addActionListener(this);
		panelCenter.add(btnHan);
		panelCenter.add(btnJoong);
		panelCenter.add(btnIl);
		panelSouth.add(btnChi);
		panelSouth.add(btnPi);
		panelSouth.add(btnBo);
		this.add(panelNorth, BorderLayout.NORTH);
		this.add(panelCenter, BorderLayout.CENTER);
		this.add(panelSouth, BorderLayout.SOUTH);
		StdDimention.setPosition(this,1200,600);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "한식":
			this.dispose();
			this.repaint();
			StoreUI ui = new StoreUI();
			break;
		case "중식":
			this.dispose();
			this.repaint();
			StoreUI ui2 = new StoreUI();
			break;
		case "일식":
			this.dispose();
			this.repaint();
			StoreUI ui3 = new StoreUI();
			break;
		case "치킨":
			this.dispose();
			this.repaint();
			StoreUI ui4 = new StoreUI();
			break;
		case "피자":
			this.dispose();
			this.repaint();
			StoreUI ui5 = new StoreUI();
			break;
		case "보쌈,족발":
			this.dispose();
			this.repaint();
			StoreUI ui6 = new StoreUI();
		default:	
			break;
		}		
	}

}
