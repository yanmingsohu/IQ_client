// CatfoOD 2008-6-13 上午08:05:04

package iq.gui.talk;

import java.awt.Point;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JEditorPane;

import iq.assist.StringTool;
import iq.event.FriendList;
import iq.event.IMessageAdmit;
import iq.event.UserEntity;
import iq.history.ChatHisInfo;
import iq.history.HistoryFactory;
import iq.history.HistoryFrame;
import iq.net.MsgFactory;

public class TalkControl {
	private Talk f;
	private ChatHisInfo chatlog;
	
	protected TalkControl(Talk t, UserEntity u) {
		f = t;
		chatlog = HistoryFactory.getHistory().getChatHisInfo(u);
	}
	
	protected void recvMsg(String s) {
		if (StringTool.haveSign(s, "$SHAKE")) {
			shake();
		} else {
			String msg = StringTool.getSign(s, "$UM");
			appendText(msg, f.getUserEntity());
		}
	}
	
	private StringBuffer buff = new StringBuffer();
	protected void appendText(String t, UserEntity user) {
		t = formatText(t, user);
		buff.append(t);
		JEditorPane out = f.getOutpane();
		out.setText(buff.toString());
		out.setCaretPosition(out.getDocument().getLength());
		
		chatlog.write(t);
	}
	
	private String formatText(String s, UserEntity name) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd   HH:mm:ss");
		
		String out = "<B>"+name.getName()+"</B> "+
			"<font color=gray style=\"font-size:8px;" +
			"font-family:Verdana\">"+df.format(new Date())+"</font><br>" +
			"<font color=\"#0066FF\" size=\"3\"><strong>"+s+"</strong></font><br>";

		return out;
	}
	
	protected void close() {
		f.setVisible(false);
		f.talkCount--;
		TalkFactory.removeTalk(f);
		f.dispose();
	}
	
	/**
	 * 取得所有缓存的聊天资料
	 * @param i
	 */
	protected void getBufferText(IMessageAdmit i) {
		String s = (String)i.admit();
		if (s!=null) {
			recvMsg(s);
		}
	}
	
	// 向网络发送消息
	private void send(String command) {
		String s = "$MSG.$S"+f.getUserEntity().getID()+command;
		MsgFactory.send(s);
	}
	
	protected void sendTalk(String msg) {
		send(".$UM"+msg);
		appendText(msg, FriendList.getMainUser());
	}
	
	protected void sendShake() {
		send(".$SHAKE");
		shake();
	}
	
	private void shake() {
		final int RANGE = 10;
		Point p = f.getLocation();
		int x,y;
		for (int i=0; i<10; ++i) {
			x = p.x + (int)(Math.random()*RANGE);
			y = p.y + (int)(Math.random()*RANGE);
			f.setLocation(x, y);
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {}
		}
		f.setLocation(p);
	}
	
	protected void openHistory() {
		new HistoryFrame(f.getUserEntity());
	}
}
