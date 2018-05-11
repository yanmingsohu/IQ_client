package iq.assist;

import iq.gui.SystemIcon;
import iq.net.MsgFactory;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Window;
import java.io.IOException;
import java.net.InetAddress;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public final class Tools {
	/** System.out.println(o); */
	public static void pl(Object o) {
		System.out.println(o);
	}
	
	/** 输出一条错误消息 */
	public static void error(Exception e) {
		e.printStackTrace();
	}
	
	/** 用对话框显示消息 */
	public static void show(Object o) {
		javax.swing.JOptionPane.showMessageDialog(null, o.toString());
	}
	
	private static InetAddress serverAdd = null;
	/** 返回服务器地址 */
	public static InetAddress getServerAddress() {
		if (serverAdd==null) {
			int i=0;
			while (++i<10) {
				try {
					serverAdd = InetAddress.getByName(
							SystemConfig.get(SystemConfig.SERVERIP+i));
					break;
				} catch (IOException e) {
					Tools.pl("服务器地址不可用."+e);
				}
			}
		}
		return serverAdd;
	}
	
	/** 返回服务器端口 */
	public static int getServerPort() {
		try {
			return Integer.parseInt(SystemConfig.get(SystemConfig.SERVERPORT));
		} catch (Exception e) {
			error(e);
		}
		return 5000;
	}
	
	/** 返回32字节掩码 */
	public static String getCodes() {
		return CodexMaker.getCodes();
	}
	
	/** 返回掩码的固定长度 */
	public static int getCodesLength() {
		return CodexMaker.getCodesLength();
	}
	
	/** 返回本地端口 */
	public static int getLocalPort() {	
		try {
			return Integer.parseInt(SystemConfig.get(SystemConfig.CLIENTPORT));
		} catch (Exception e) {
			error(e);
		}
		return 6000;
	}
	
	public static Image getRadomImage() {
		int i = (int)(Math.random()*134);
		return ImagesFactory.creatImage("face/"+i+".GIF");
	}
	
	public static ImageIcon getRadomIcon() {
		int i = (int)(Math.random()*134);
		return ImagesFactory.creatIcon("face/"+i+".GIF");
	}
	
	/** 将组件居中 */
	public static void ComponentMoveCenter(Component c) {
		int w = c.getWidth();
		int h = c.getHeight();
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int)((d.getWidth()-w) /2);
		int y = (int)((d.getHeight()-h)/2);
		c.setLocation(x, y);
		if (c instanceof Window) {
			Window jf = (Window)c;
			jf.setIconImage(ImagesFactory.ICON1);
			jf.setAlwaysOnTop(true);
			jf.setAlwaysOnTop(false);
		}
	}
	
	/**
	 * 设置窗口的位置，在屏幕偏右方(固定的)
	 * @param f
	 */
	public static void setMainFrameBounds(Frame f) {
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int w = 200;
		int h = (int)(d.height-100);
		int x = (int)((d.getWidth()-w) -10);
		int y = (int)(10);
		f.setBounds(x, y, w, h);
	}
	
	/**
	 * 系统退出必须调用这个方法
	 */
	public static void exit() {
		pl("正常退出..");
		SystemIcon.getInstance().exit();
		MsgFactory.send("$LOGOUT");
		System.exit(0);
	}
	
	/**
	 * iq.com 的主页地址
	 */
	public static String getIQnet() {
//		这是获取本地文件的方法
//		String path = System.getProperty("user.dir");
//		path = "file://"+path+"/skin/index.html";
		return "yanming.byethost16.com";
	}
}
