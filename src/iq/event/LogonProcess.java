// CatfoOD 2008-6-10 ����08:48:10

package iq.event;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import iq.assist.SoundEffect;
import iq.gui.NextVersion;
import iq.gui.SystemIcon;
import iq.gui.layout.JPopPanel;
import iq.gui.main.JFriendPanel;
import iq.gui.main.MainUI;
import iq.history.HistoryFactory;
import iq.net.MsgFactory;

/**
 * ��½���̣���װ�����������
 */
public class LogonProcess {
	private LogonProcess() {}
	
	public static void init(String id, JFrame logonframe) {
		// ������ǰ��½�û���ʬ�� :)
		UserEntity user = new UserEntity(id);
		// ��ʼ���û��б�
		FriendList.init(user);
		// ��ʼ����ʷ��¼
		HistoryFactory.getHistory();
		// ��ʼ��������Ϣ�߳�
		AddFriendEventThread.init();
		// ϵͳ������ͼ��
		SystemIcon.getInstance();
	
		
		// ����������
		MainUI main = new MainUI();
		JPopPanel pop = new JPopPanel();
		pop.addPanel(new NextVersion(), "�����ϵ��");
		pop.addPanel(new NextVersion(), "iQȺ");
		pop.addPanel(new NextVersion(), "ͨѶ¼");
		pop.addPanel(creatFriendPane(), "iQ����");
		
		main.setMainPane(pop);
		SoundEffect.playSE("�л�");
		main.setVisible(true);
		
		logonframe.setVisible(false);
		FriendList.requestList();
		// ȡ��������Ϣ
		MsgFactory.send("$OFFLINE");
	}
	
	private static JPanel creatFriendPane() {
		JPanel p = new JPanel();
		p.setLayout(new BorderLayout());
		p.add(new JFriendPanel());
		return p;
	}
}
