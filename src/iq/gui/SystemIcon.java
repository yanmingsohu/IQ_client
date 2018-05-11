package iq.gui;
// CatfoOD 2008.3.25

import iq.assist.ImagesFactory;
import iq.assist.Tools;
import iq.event.ISystemIconMessage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayDeque;
import java.util.Queue;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *	系统任务栏图标
 */
public class SystemIcon implements ActionListener {
	private final static SystemIcon instance = new SystemIcon();
	
	/**
	 * 取得全局唯一实例
	 */
	public static SystemIcon getInstance() {
		return instance;
	}
	
	// ----------------------- 实例分割线 ----------------------------
	
	private TrayIcon ti;
	private StringBuffer buff = new StringBuffer();
	private volatile boolean running = false;
	private ISystemIconMessage currentMess = null;
	private Image currentFlashIcon;
	
	/** 加入图标消息的队列 */
	private ArrayDeque<ISystemIconMessage> queue = 
				new ArrayDeque<ISystemIconMessage>();
	
	private Image img1;
	private Image img2;
	
	private SystemIcon() {
		try {
			SystemTray st = SystemTray.getSystemTray();

			img1 = ImagesFactory.ICON1;
			img2 = ImagesFactory.INULL;
			
			ti = new TrayIcon(img1, "iQ2008");
			ti.setImageAutoSize(true);
			ti.addActionListener(this);
			ti.addMouseListener(new MA());
			st.add(ti);
		}catch(Exception e){
			Tools.show("建立系统任务栏图标错误.");
		}
	}

	/**
	 * 设置此 TrayIcon 的弹出菜单。如果 popup 为 null，则没有任何弹出菜单与此 TrayIcon 关联。 
	 * 注意，在托盘图标上设置此 popup 之前或之后，都不得将它添加到任何父级弹出菜单。
	 * 如果将它添加到某个父级弹出菜单，则可能从该父级弹出菜单中移除 popup。 
	 * 	
	 * 	popup 只能设置在一个 TrayIcon 上。在多个 TrayIcon 上设置同一个 popup 
	 * 	将导致 IllegalArgumentException。 
	 * 	
	 * 	注： 一些平台可能不支持在用户右键单击托盘图标时显示用户指定的弹出菜单组件。
	 * 	在这种情况下，可能不显示任何菜单，在某些系统中，也可能显示菜单的本地版本。 
	 * 	
	 * @param popup - 一个 PopupMenu，如果该参数为 null，则移除所有弹出菜单 
	 * @exception IllegalArgumentException - 如果已经为另一个 TrayIcon 设置 popup
	 */
	public void setPopupMenu(PopupMenu popup) {
		ti.setPopupMenu(popup);
	}
	
	/**
	 * 设置此 TrayIcon 的工具提示字符串。当鼠标悬停在图标上时，自动显示工具提示。
	 * 将工具提示设置为 null 将移除所有工具提示文本。 
	 * 在某些平台上显示时，工具提示字符串可能被截断；
	 * 可以显示的字符数与平台有关。 
	 * 
	 * @param tooltip - 工具提示的字符串；如果值为 null，则不显示任何工具提示
	 */
	public void setToolTip(String tooltip) {
		ti.setToolTip("iQ2008 "+tooltip);
	}
	
	/**
	 * 系统栏弹出一条消息
	 * @param mess - 消息的封装
	 */
	public void addMessage(ISystemIconMessage mess) {
		if (mess==null) throw 
			new NullPointerException("传入的ISystemIconMessage不能空.");
		
		if (queue.contains(mess)) return;
		
		buff.append(mess.getUserName()+"\n");
		
		ti.displayMessage("有您的消息:", 
				buff.toString(), TrayIcon.MessageType.NONE);
		
		// 首个元素并不能添加入队列
		if (running==false) {
			currentMess = mess;
			setCurrentFlashIcon(mess);
			new flashIcon().start();
		} else {
			queue.add(mess);
		}
	}
	
	/**
	 * 移除这个消息，可能有其他的方法响应了这个消息
	 * @param mess - 要移除的消息
	 */
	public void removeMessage(ISystemIconMessage mess) {
		if (queue.remove(mess)) return;
		if (mess==currentMess) {
			nextMessage();
		}
	}
	
	/**
	 * 出现鼠标双击事件，这个方法回调加入者
	 */
	protected void callMessage() {
		if (currentMess==null) {
			running = false;
			return;
		}
		
		currentMess.callbackOpenEvent();
		nextMessage();
	}
	
	/**
	 * 退出,关闭系统栏图标
	 */
	public void exit() {
		SystemTray st = SystemTray.getSystemTray();
		st.remove(ti);
		queue.clear();
	}
	
	/**
	 * 图标引发的事件，会关闭弹出提示
	 */
	public void actionPerformed(ActionEvent e) {
		buff.delete(0, buff.length());
	}
		
	// 图标闪烁线程
	private class flashIcon extends Thread {
		public void run() {
			running = true;
			while (running) {				
				try {
					ti.setImage(currentFlashIcon);
					sleep(500);
					ti.setImage(img2);
					sleep(500);
				} catch(Exception e) {}
			}
			// 退出线程并还原原始图标
			ti.setImage(img1);
		}
	}
	
	private void setCurrentFlashIcon(ISystemIconMessage i) {
		currentFlashIcon = i.getUserIcon();
		if (currentFlashIcon==null) {
			currentFlashIcon = img1;
		}
	}

	private void nextMessage() {
		currentMess = queue.poll();
		if (currentMess!=null) {
			setCurrentFlashIcon(currentMess);
		} else {
			running = false;
		}
	}
	
	// 鼠标双击事件
	private class MA extends MouseAdapter {
		public void mouseClicked(MouseEvent e) {
			if (e.getClickCount()>=2) {
				callMessage();
			}
		}
	}
}


