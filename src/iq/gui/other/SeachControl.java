// CatfoOD 2008-6-11 ����11:32:29

package iq.gui.other;

import iq.assist.MessageThread;
import iq.assist.StringTool;
import iq.assist.Tools;
import iq.net.MsgFactory;

public class SeachControl {
	private Seach f;
	
	protected SeachControl(Seach s) {
		f = s;
	}
	
	private JWaitDialog waitd = new JWaitDialog(f);
	
	/**
	 * ���Ұ�ť
	 */
	public void seachButton(int i) {
		if (i==0) {
			blueSeach();
		} else if (i==1){
			rigorSeach();
		}
	}
	
	/**
	 * �߼����ң�ģ������
	 */
	private void blueSeach() {
		if (f.getId().trim().length()<2) {
			Tools.show("������ID");
			return;
		}
		waitd.start();
		new checkIdThread(f.getId());
	}
	
	/**
	 * ��ȷ����
	 */
	private void rigorSeach() {
		String s = "$FIND.$S"+f.getSex()+".$A"+f.getAge()+
							".$C"+f.getCity()+".$N"+f.getName();
		waitd.start();
		new SeachThread(s);
	}
	
	private class SeachThread extends MessageThread {
		public SeachThread(String s) {
			start(10);
			MsgFactory.send(s);
		}
		public void complete(String src) {
			String s = StringTool.getSign(src, "$L");
			String[] list = s.split(":");
			f.setTable(list);
			waitd.stop();
		}
		public void overTime() {
			waitd.stop();
			Tools.show("���ӳ�ʱ�������û�ʧ��..");
		}
		public String getCodex() {
			return "$FIND";
		}
	}
	
	// ������Ӻ��ѵ���Ϣ
	public void addFriendThread(String id, String info) {
		String s = "$FRI.$ADD.$FID"+id+".$INFO"+info;
		MsgFactory.send(s);
	}
	
	private class checkIdThread extends MessageThread {
		private String id;
		public checkIdThread(String id) {
			start(2);
			MsgFactory.send("$NAME.$ID"+id);
			this.id = id;
		}

		public void complete(String msgpack) {
			String name = StringTool.getSign(msgpack, "$UN");
			if (name.length()>1) {
				waitd.stop();
				String[] s = new String[]{id};
				f.setTable(s);
			} else {
				Tools.show("�����ڵ��û�"+id);
				waitd.stop();
			}
		}

		public void overTime() {
			waitd.stop();
			Tools.show("�����ڵ��û�"+id);
		}

		public String getCodex() {
			return "$NAME.$ID"+id;
		}
	}
}
