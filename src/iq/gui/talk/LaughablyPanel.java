// CatfoOD 2008-6-13 ÏÂÎç01:58:50

package iq.gui.talk;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import iq.assist.ImagesFactory;
import iq.assist.Tools;

import javax.swing.JPanel;

public class LaughablyPanel extends JPanel {
	private Image img = ImagesFactory.creatImage("images/laug.png");
	private g_x g = new g_x();
	
	public LaughablyPanel() {
		new animThread().start();
	}
	
	private class animThread extends Thread {
		animThread() {
			this.setDaemon(true);
		}
		public void run() {
			int c = 0;
			while (LaughablyPanel.this.isDisplayable()||c<5) {
				repaint();
				try {
					sleep((int)(Math.random()*1000+2000));
					++c;
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			Tools.pl("exit");
		}
	}
	
	int x;
	int y;
	
	public void paint(Graphics g) {
		g.clearRect(0, 0, getWidth(), getHeight());
		random();
		g.drawImage(img, x, y, this);
		
		if (y>20) y = 20;
		else y = getHeight()-20;
		x = (int)(Math.random()* 5+5);
		String s = this.g.getNext();
		f = g.getFont();
		if (s.startsWith("ÎÒ°®Äã")) {
			g.setFont(new Font(f.getFontName(), f.getStyle(), 25));
		}
		g.drawString(s, x, y);
		g.setFont(f);
	}
	
	private Font f;
	
	private void random() {
		x = (int)(Math.random()* (getWidth()-img.getWidth(null)) );
		y = (int)(Math.random()* (getHeight()-img.getHeight(null)) );
	}
}
