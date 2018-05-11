package iq.gui;

import iq.assist.ImagesFactory;
import iq.assist.Tools;
import iq.assist.VersionControl;

import java.awt.Dimension;
import java.awt.GraphicsConfiguration;
import java.awt.MouseInfo;
import java.awt.Point;

import javax.swing.JFrame;

// 实现细节
// 隐藏条件： 位于屏幕上方 && 鼠标移出
// 显示条件： 隐藏的 && 鼠标移入

/**
 *  可以自动隐藏的窗体
 */
public class JAHideFrame extends JFrame {
	// 鼠标检查线程休眠的时间，
	private final int waittime = 200;
	
	public JAHideFrame() {
		super();
		init();
	}
	public JAHideFrame(GraphicsConfiguration gc) {
		super(gc);
		init();
	}
	public JAHideFrame(String title) {
		super(title);
		init();
	}
	public JAHideFrame(String title, GraphicsConfiguration gc) {
		super(title, gc);
		init();
	}
	
	private final void init() {
		new CheckThread().start();
		this.setAlwaysOnTop(true);
		this.setMinimumSize(new Dimension(200, 400));
		Tools.setMainFrameBounds(this);
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.setIconImage(ImagesFactory.creatImage("images/p16a.jpg"));
		this.setTitle(VersionControl.programNameEN);
	}
		
	private class CheckThread extends Thread {
		public CheckThread() {
			this.setPriority(MIN_PRIORITY);
			this.setDaemon(true);
		}
		public void run() {
			while (true) {
				if (mouseInWindow()) {
					showit();
				} else {
					hideit();
				}
				try {
					sleep(waittime);
				} catch (InterruptedException e) {}
			}
		}
	}
	
	private boolean mouseInWindow() {
		Point mousePoint = MouseInfo.getPointerInfo().getLocation();
		return this.getBounds().contains(mousePoint);
	}
	
	private boolean isHide = false;
	
	private void showit() {
		if (!isHide) return;
		processOfChange(this.getY(), 0);
		isHide = false;
	}
	
	private void hideit() {
		if (isHide) return;
		if (this.getY()<3) {
			processOfChange(this.getY(), 5-this.getHeight());
			isHide = true;
		}
	}
	
	private void processOfChange(int oldy, int newy) {
		final int step = 60;
		int way = oldy>newy ? -step : step;
		int y = oldy;
		while (Math.abs(y-newy)>step) {
			this.setLocation(this.getX(), y);
			y += way;
			try {
				Thread.sleep(8);
			} catch (InterruptedException e) {}
		}
		this.setLocation(this.getX(), newy);
	}
	
}
