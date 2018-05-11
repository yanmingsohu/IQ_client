// CatfoOD 2008-6-11 上午11:32:29

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
	 * 查找按钮
	 */
	public void seachButton(int i) {
		if (i==0) {
			blueSeach();
		} else if (i==1){
			rigorSeach();
		}
	}
	
	/**
	 * 高级查找，模糊查找
	 */
	private void blueSeach() {
		if (f.getId().trim().length()<2) {
			Tools.show("请输入ID");
			return;
		}
		waitd.start();
		new checkIdThread(f.getId());
	}
	
	/**
	 * 精确查找
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
			Tools.show("连接超时，查找用户失败..");
		}
		public String getCodex() {
			return "$FIND";
		}
	}
	
	// 发送添加好友的消息
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
				Tools.show("不存在的用户"+id);
				waitd.stop();
			}
		}

		public void overTime() {
			waitd.stop();
			Tools.show("不存在的用户"+id);
		}

		public String getCodex() {
			return "$NAME.$ID"+id;
		}
	}
}
