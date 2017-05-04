import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class main {
	public static void main(String[] args){
		JFrame f=new JFrame();
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		//f.setSize(screenSize.width, screenSize.height);
		f.setSize(1000, 700);
		f.setResizable(false);
		JPanel p=new JPanel();
		Canvas c=new Canvas();
		Canvas c2=new Canvas();
		Canvas c3=new Canvas();
		c3.setBackground(Color.black);
		c2.setBackground(Color.black);
		p.setLayout(new BorderLayout());
		c.setBackground(Color.black);
		p.add(c);
		p.add(c2);
		p.add(c3);
		f.add(p);
		Player player=new Player();
		player.setJFrame(f);
		player.setCanvas(c);
		player.setSize(f.getWidth(), f.getHeight()/2);
		player.initVideoFile("http://192.168.0.102:8080");
		Player dua=new Player();
		dua.setJFrame(f);
		dua.setCanvas(c2);
		dua.setSize(f.getWidth()/2, (f.getHeight())-(f.getHeight()/2));
		dua.setPosition(0, f.getHeight()/2);
		dua.initVideoFile("wildlife.wmv");
		Player tiga=new Player();
		tiga.setJFrame(f);
		tiga.setCanvas(c3);
		tiga.setSize(f.getWidth()-(f.getWidth()/2), (f.getHeight())-(f.getHeight()/2));
		tiga.setPosition(f.getWidth()/2, f.getHeight()/2);
		tiga.initVideoFile("wildlife.wmv");
		tiga.playVideo();
		dua.playVideo();
		player.playVideo();
		player.getMediaController().setScale(1.0f);
		dua.getMediaController().setScale(1.0f);
		tiga.getMediaController().setScale(1.0f);
	}
}
