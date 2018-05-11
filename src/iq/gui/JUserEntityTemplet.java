package iq.gui;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;

/**
 * �����û�ʵ����ʹ��
 */
public class JUserEntityTemplet extends JLabel {
	private static final long serialVersionUID = 342589294257964423L;

	private FlickerIcon ficon = null;
	
	private static Font common = null;
	private static Font select = null;
	
	/** �ж�����Ƿ�������� */
	private boolean isEnter = false;
	/** �������ͣ���¼���ʱ�䣬ms */
	public static final int mouseWaitTime = 500;
	
	public JUserEntityTemplet(String text, Icon icon, int horizontalAlignment) {
		super(text, horizontalAlignment);
		init();
	}
	public JUserEntityTemplet(String text, int horizontalAlignment) {
		super(text, horizontalAlignment);
		init();
	}
	public JUserEntityTemplet(String text) {
		super(text);
		init();
	}
	public JUserEntityTemplet(Icon image, int horizontalAlignment) {
		super(image, horizontalAlignment);
	}
	public JUserEntityTemplet(Icon image) {
		super(image);
		init();
	}
	public JUserEntityTemplet() {
		super();
		init();
	}
	
	/**
	 * ��ʼ������
	 */
	private void init() {
		// ʵ���������ָ��
		setCursor(new Cursor(Cursor.HAND_CURSOR));
		// ��ʼ������
		if (common==null) {
			common = this.getFont();
			select = new Font(common.getFontName(), 
					Font.ITALIC, common.getSize()+2);
		}
		// �������룬�ı������
		this.addMouseListener( new ML() );
		// ���ñ߿�
		this.setBorder(new EmptyBorder(5, 10, 1, 1));
	}
	
	/**
	 * �򵥵�ʵ���˵�������롢�Ƴ�ʱ�������Ӧ<br>
	 * ��������¼��Ĵ���
	 */
	private class ML extends MouseAdapter {
		public void mouseEntered(MouseEvent e) {
			JUserEntityTemplet.this.setFont(select);
			ficon.sinking(true);
			isEnter = true;
			new MouseEnterCheck();
		}
		public void mouseExited(MouseEvent e) {
			JUserEntityTemplet.this.setFont(common);
			ficon.sinking(false);
			isEnter = false;
			JUserEntityTemplet.this.mouseExited();
		}
		public void mouseClicked(MouseEvent e) {
			if (e.getButton()==e.BUTTON1) {
				if (e.getClickCount()==2) {
					mouseTwoClick();
				}
			}
		}
	}
	
	/**
	 * ������ͣ����ʱ��,�Ƿ�ﵽָ����ָ
	 * �ﵽ��֪ͨmouseStasis()����
	 */
	private class MouseEnterCheck extends Thread {
		public MouseEnterCheck() {
			start();
		}
		public void run() {
			try {
				sleep(mouseWaitTime);
			} catch (InterruptedException e) {}
			
			if (isEnter) {
				Point p = MouseInfo.getPointerInfo().getLocation();
				mouseStasis(p.x, p.y);
			}
		}
	}
	
	/**
	 * ��д����ķ������԰�װ�ᶶ����Icon
	 */
	public void setIcon(Icon icon) {
		if (icon!=null) ficon = new FlickerIcon(icon);
		super.setIcon(ficon);
	}
	
	/**
	 * ��Label�е�ͼ�궶����
	 * @param run - ��ʼ����true, ֹͣ����false
	 */
	public void flicker(boolean run) {
		if (ficon==null) return;
		ficon.flicker(run, this);
	}
	
	
	/**
	 * ���˫���¼�����������д��Ĭ�ϲ����κ�����
	 */
	protected void mouseTwoClick() {}
	/**
	 * ���ͣ���¼�����������д��Ĭ�ϲ����κ�����
	 * �����ͣ����������1���ӣ��������������
	 * 
	 * @param x,y - ȡ�õ�ǰ��������
	 */
	protected void mouseStasis(int x, int y) {}
	/**
	 * ����Ƴ��¼�����������д��Ĭ�ϲ����κ�����
	 */
	protected void mouseExited() {}
}

/**
 * �ᶶ����Icon
 */
class FlickerIcon implements Icon {
	private Icon icon = null;
	/** ������ƫ������������������ */
	private int OFFSET = 5;
	/** �������ٶȣ���/�� */
	private int speed = 11;

	public FlickerIcon(String iconname) throws FileNotFoundException {
		if ( !new File(iconname).isFile() ) 
			throw new FileNotFoundException();
		
		Image img = Toolkit.getDefaultToolkit().createImage(iconname);
		icon = new ImageIcon(img);
	}
	
	public FlickerIcon(Image img) {
		if (img==null) throw new NullPointerException();
		this.icon = new ImageIcon(img);
	}
	
	public FlickerIcon(Icon img) {
		if (img==null) throw new NullPointerException();
		icon = img;
	}
	
	/**
	 * ͼ�궶��
	 */
	public void flicker(boolean run, Component c) {
		if ( (!running) && run) {
			new flickerThread(c);
		}
		running = run;
	}
	
	/**
	 * ͼ���³�
	 */
	public void sinking(boolean sink) {
		if (sink) {
			offy = 2;
		} else {
			offy = 0;
		}
	}
	
	public int getIconHeight() {
		return icon.getIconHeight();
	}

	public int getIconWidth() {
		return icon.getIconWidth();
	}

	public void paintIcon(Component c, Graphics g, int x, int y) {
		icon.paintIcon(c, g, x + offx, y + offy);
	}
	
	private int offx, offy;
	private boolean running = false;
	
	private class flickerThread extends Thread {
		private Component c;
		public flickerThread(Component c) {
			this.c = c;
			start();
		}
		public void run() {
			long slep = 1000/speed;
			while (running) {
				offx = (int)(Math.random()*OFFSET);
				offy = (int)(Math.random()*OFFSET);
				c.repaint();
				try {
					sleep(slep);
				} catch (InterruptedException e) {}
			}
			offx = offy = 0;
			c.repaint();
		}
	}
}