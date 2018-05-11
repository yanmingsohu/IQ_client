// CatfoOD 2008-6-10 上午08:48:10

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
 * 登陆过程，封装在这个方法中
 */
public class LogonProcess {
	private LogonProcess() {}
	
	public static void init(String id, JFrame logonframe) {
		// 建立当前登陆用户的尸体 :)
		UserEntity user = new UserEntity(id);
		// 初始化用户列表
		FriendList.init(user);
		// 初始化历史纪录
		HistoryFactory.getHistory();
		// 初始化好友消息线程
		AddFriendEventThread.init();
		// 系统任务栏图标
		SystemIcon.getInstance();
	
		
		// 建立主窗口
		MainUI main = new MainUI();
		JPopPanel pop = new JPopPanel();
		pop.addPanel(new NextVersion(), "最近联系人");
		pop.addPanel(new NextVersion(), "iQ群");
		pop.addPanel(new NextVersion(), "通讯录");
		pop.addPanel(creatFriendPane(), "iQ好友");
		
		main.setMainPane(pop);
		SoundEffect.playSE("切换");
		main.setVisible(true);
		
		logonframe.setVisible(false);
		FriendList.requestList();
		// 取得离线消息
		MsgFactory.send("$OFFLINE");
	}
	
	private static JPanel creatFriendPane() {
		JPanel p = new JPanel();
		p.setLayout(new BorderLayout());
		p.add(new JFriendPanel());
		return p;
	}
}
