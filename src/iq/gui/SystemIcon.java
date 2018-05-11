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
 *	ϵͳ������ͼ��
 */
public class SystemIcon implements ActionListener {
	private final static SystemIcon instance = new SystemIcon();
	
	/**
	 * ȡ��ȫ��Ψһʵ��
	 */
	public static SystemIcon getInstance() {
		return instance;
	}
	
	// ----------------------- ʵ���ָ��� ----------------------------
	
	private TrayIcon ti;
	private StringBuffer buff = new StringBuffer();
	private volatile boolean running = false;
	private ISystemIconMessage currentMess = null;
	private Image currentFlashIcon;
	
	/** ����ͼ����Ϣ�Ķ��� */
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
			Tools.show("����ϵͳ������ͼ�����.");
		}
	}

	/**
	 * ���ô� TrayIcon �ĵ����˵������ popup Ϊ null����û���κε����˵���� TrayIcon ������ 
	 * ע�⣬������ͼ�������ô� popup ֮ǰ��֮�󣬶����ý�����ӵ��κθ��������˵���
	 * ���������ӵ�ĳ�����������˵�������ܴӸø��������˵����Ƴ� popup�� 
	 * 	
	 * 	popup ֻ��������һ�� TrayIcon �ϡ��ڶ�� TrayIcon ������ͬһ�� popup 
	 * 	������ IllegalArgumentException�� 
	 * 	
	 * 	ע�� һЩƽ̨���ܲ�֧�����û��Ҽ���������ͼ��ʱ��ʾ�û�ָ���ĵ����˵������
	 * 	����������£����ܲ���ʾ�κβ˵�����ĳЩϵͳ�У�Ҳ������ʾ�˵��ı��ذ汾�� 
	 * 	
	 * @param popup - һ�� PopupMenu������ò���Ϊ null�����Ƴ����е����˵� 
	 * @exception IllegalArgumentException - ����Ѿ�Ϊ��һ�� TrayIcon ���� popup
	 */
	public void setPopupMenu(PopupMenu popup) {
		ti.setPopupMenu(popup);
	}
	
	/**
	 * ���ô� TrayIcon �Ĺ�����ʾ�ַ������������ͣ��ͼ����ʱ���Զ���ʾ������ʾ��
	 * ��������ʾ����Ϊ null ���Ƴ����й�����ʾ�ı��� 
	 * ��ĳЩƽ̨����ʾʱ��������ʾ�ַ������ܱ��ضϣ�
	 * ������ʾ���ַ�����ƽ̨�йء� 
	 * 
	 * @param tooltip - ������ʾ���ַ��������ֵΪ null������ʾ�κι�����ʾ
	 */
	public void setToolTip(String tooltip) {
		ti.setToolTip("iQ2008 "+tooltip);
	}
	
	/**
	 * ϵͳ������һ����Ϣ
	 * @param mess - ��Ϣ�ķ�װ
	 */
	public void addMessage(ISystemIconMessage mess) {
		if (mess==null) throw 
			new NullPointerException("�����ISystemIconMessage���ܿ�.");
		
		if (queue.contains(mess)) return;
		
		buff.append(mess.getUserName()+"\n");
		
		ti.displayMessage("��������Ϣ:", 
				buff.toString(), TrayIcon.MessageType.NONE);
		
		// �׸�Ԫ�ز�������������
		if (running==false) {
			currentMess = mess;
			setCurrentFlashIcon(mess);
			new flashIcon().start();
		} else {
			queue.add(mess);
		}
	}
	
	/**
	 * �Ƴ������Ϣ�������������ķ�����Ӧ�������Ϣ
	 * @param mess - Ҫ�Ƴ�����Ϣ
	 */
	public void removeMessage(ISystemIconMessage mess) {
		if (queue.remove(mess)) return;
		if (mess==currentMess) {
			nextMessage();
		}
	}
	
	/**
	 * �������˫���¼�����������ص�������
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
	 * �˳�,�ر�ϵͳ��ͼ��
	 */
	public void exit() {
		SystemTray st = SystemTray.getSystemTray();
		st.remove(ti);
		queue.clear();
	}
	
	/**
	 * ͼ���������¼�����رյ�����ʾ
	 */
	public void actionPerformed(ActionEvent e) {
		buff.delete(0, buff.length());
	}
		
	// ͼ����˸�߳�
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
			// �˳��̲߳���ԭԭʼͼ��
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
	
	// ���˫���¼�
	private class MA extends MouseAdapter {
		public void mouseClicked(MouseEvent e) {
			if (e.getClickCount()>=2) {
				callMessage();
			}
		}
	}
}


