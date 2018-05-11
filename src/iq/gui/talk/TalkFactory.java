// CatfoOD 2008-6-13 ����08:15:48

package iq.gui.talk;

import java.util.ArrayList;

import iq.event.IMessageAdmit;
import iq.event.UserEntity;
import iq.gui.JUserDisplay;

/**
 * ����Ի��򹤳���ÿ���û�ֻ�ܿ���һ���Ի���
 */
public class TalkFactory {
	private TalkFactory() {}
	private static ArrayList<TalkPack> ts = new ArrayList<TalkPack>();
	
	public static synchronized Talk creatTalk(
			JUserDisplay j, UserEntity ud, IMessageAdmit i) 
	{
		if (isOpened(ud)) return null;
		
		TalkPack talk = new TalkPack(j, ud, i);
		ts.add(talk);
		return talk.getTalk();
	}
	
	public static synchronized void removeTalk(Talk t) {
		for (int i=0; i<ts.size(); ++i) {
			TalkPack tp = ts.get(i);
			if (tp.checkEqu(t)) {
				tp.remove();
				ts.remove(tp);
				return;
			}
		}
		throw new RuntimeException("�߼�����:�Ҳ���ָ����Talk");
	}
	
	private static boolean isOpened(UserEntity ue) {
		for (int i=0; i<ts.size(); ++i) {
			if (ts.get(i).isOpened(ue)) {
				return true;
			}
		}
		return false;
	}
}

class TalkPack {
	private JUserDisplay userDisp;
	private IMessageAdmit oldi;
	private Talk current;
	private UserEntity userEnti;
	
	protected TalkPack(JUserDisplay u, UserEntity ue, IMessageAdmit i) {
		userDisp = u;
		oldi = i;
		current = new Talk(ue, i);
		userEnti = ue;
	}
	
	public boolean isOpened(UserEntity ue) {
		if(userEnti == ue) {
			current.setAlwaysOnTop(true);
			current.setAlwaysOnTop(false);
		}
		return userEnti == ue;
	}
	
	public Talk getTalk() {
		return current;
	}
	
	public boolean checkEqu(Talk t) {
		return current==t;
	}
	
	public void remove() {
		userDisp.removeDialog(oldi);
	}
}