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
 * 给与用户实体类使用
 */
public class JUserEntityTemplet extends JLabel {
	private static final long serialVersionUID = 342589294257964423L;

	private FlickerIcon ficon = null;
	
	private static Font common = null;
	private static Font select = null;
	
	/** 判断鼠标是否在组件上 */
	private boolean isEnter = false;
	/** 触发鼠标停滞事件的时间，ms */
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
	 * 初始化方法
	 */
	private void init() {
		// 实现手型鼠标指针
		setCursor(new Cursor(Cursor.HAND_CURSOR));
		// 初始化字体
		if (common==null) {
			common = this.getFont();
			select = new Font(common.getFontName(), 
					Font.ITALIC, common.getSize()+2);
		}
		// 当鼠标进入，改变字体等
		this.addMouseListener( new ML() );
		// 设置边框
		this.setBorder(new EmptyBorder(5, 10, 1, 1));
	}
	
	/**
	 * 简单的实现了当鼠标移入、移出时的外观响应<br>
	 * 简化了鼠标事件的代码
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
	 * 检查鼠标停留的时间,是否达到指定的指
	 * 达到则通知mouseStasis()方法
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
	 * 重写父类的方法，以包装会抖动的Icon
	 */
	public void setIcon(Icon icon) {
		if (icon!=null) ficon = new FlickerIcon(icon);
		super.setIcon(ficon);
	}
	
	/**
	 * 让Label中的图标抖动，
	 * @param run - 开始抖动true, 停止抖动false
	 */
	public void flicker(boolean run) {
		if (ficon==null) return;
		ficon.flicker(run, this);
	}
	
	
	/**
	 * 鼠标双击事件，由子类重写，默认不做任何事情
	 */
	protected void mouseTwoClick() {}
	/**
	 * 鼠标停滞事件，由子类重写，默认不做任何事情
	 * 当鼠标停滞在这个组件1秒钟，这个方法被触发
	 * 
	 * @param x,y - 取得当前鼠标的坐标
	 */
	protected void mouseStasis(int x, int y) {}
	/**
	 * 鼠标移出事件，由子类重写，默认不做任何事情
	 */
	protected void mouseExited() {}
}

/**
 * 会抖动的Icon
 */
class FlickerIcon implements Icon {
	private Icon icon = null;
	/** 抖动的偏移量，根据需求设置 */
	private int OFFSET = 5;
	/** 抖动的速度，次/秒 */
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
	 * 图标抖动
	 */
	public void flicker(boolean run, Component c) {
		if ( (!running) && run) {
			new flickerThread(c);
		}
		running = run;
	}
	
	/**
	 * 图标下沉
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