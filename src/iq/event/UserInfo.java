// CatfoOD 2008-6-10 ����08:49:29

package iq.event;

import iq.assist.ImagesFactory;
import iq.assist.MessageThread;
import iq.assist.StringTool;
import iq.assist.Tools;
import iq.net.MsgFactory;

import java.util.HashMap;
import java.util.Map;

import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 * �û�����
 */
public class UserInfo {
	/**
	 * info���ڲ����ݸ�ʽ:
	 * [ÿ��һ������]
	 * <��������>=<����>\n
	 */	
	private Map<String, String> infos = 
					new HashMap<String, String>();
	
	private boolean initialize = false;
	private String id;
	private volatile String name = null;
	
	private final static int REFUSE = 0;
	private final static int COMPLETE = 1;
	
	private IMessage nameChangeListener;	
	private int state;
	
	public UserInfo(String id) {
		this.id = id;
	}
	
	public String getName() {
		if (name==null) {
			name = "";
			new nameThread();
		}
		return name;
	}
	
	/**
	 * ȡ��ָ�����Ե�ֵ���Ҳ������ؿ��ַ���""
	 * ���������Ѱ��ʱ������������������ֱ�����緵��
	 * 
	 * @param propertiy - "Ҫȡ�õ�������"
	 * @return - String
	 */
	public String get(String propertiy) {
		initInfo();
		String v = infos.get(propertiy);
		if (v==null) {
			return "";
		}
		return v;
	}
	
	public String getID() {
		return id;
	}
	
	/**
	 * �����û�ͷ��
	 */
	public ImageIcon getIcon() {
		String iconpath = get("icon");
		if (iconpath.length()<3) {
			return Tools.getRadomIcon();
		} else {
			return ImagesFactory.creatIcon(iconpath);
		}
	}
	
	/**
	 * ��ָ�������ԣ�����Ϊvalus�������ھʹ�����
	 * @param propertiy - ����
	 * @param value - ֵ
	 */
	public void set(String propertiy, String value) {
		infos.put(propertiy, value);
	}
	
	/**
	 * ������һ��ִ�е�����ص�״̬
	 * @return - refuse, complete
	 */
	public int getState() {
		return state;
	}
	
	/**
	 * ǿ�Ƹ�����Ϣ����
	 */
	public void updata() {
		initialize = false;
		initInfo();
	}
	
	/**
	 * �ѵ�ǰ����Ϣ�ϴ���������
	 */
	public void modifierInfo() {
		StringBuffer b = new StringBuffer();
		Object[] keys = infos.keySet().toArray();
		for (int i=0; i<keys.length; ++i) {
			b.append(keys[i]);
			b.append('=');
			b.append(infos.get(keys[i]));
			b.append('\n');
		}
		Tools.pl(b.toString());
		String s = "$INFO.$PUT.$ID"+id+".$BODY"+b.toString();
		MsgFactory.send(s);
	}
	
	private void initInfo() {
		if (!initialize) {
			nameThread n = new nameThread();
			infoThread it = new infoThread(id);
			//���������,
			//it.waiting();
		}
	}
	
	private final void stringToMap(String info) {
		String[] s1 = info.split("[\n]");
		for (int i=0; i<s1.length; ++i) {
			String[] s2 = s1[i].split("=", 2);
			if (s2.length==2) {
				infos.put(s2[0], s2[1]);
			}
		}
	}
	
	public void registerNameChangeListener(IMessage i) {
		nameChangeListener = i;
	}
	
	// ȡ����Ϣ���߳� ------------------------------------
	private class infoThread extends MessageThread {		
		private infoThread(String id) {
			String s = "$INFO.$GET.$ID"+id;
			MsgFactory.send(s);
			start();
		}
		
		public void complete(String msg) {
			if (StringTool.haveSign(msg, "$OK")) {
				initialize = true;
				String infobody = StringTool.getSign(msg, "$BODY");
				stringToMap(infobody);
				state = COMPLETE;
			} else {
				state = REFUSE;
			}
		}

		public void overTime() {
			state = REFUSE;
		}

		public String getCodex() {
			return "$INFO.$ID"+id;
		}
	}
	
	// ȡ�����ֵ��߳�
	private class nameThread extends MessageThread {
		private nameThread() {
			MsgFactory.send("$NAME.$ID"+id);
			start(3);
		}
		
		public void complete(String msgpack) {
			setnName(StringTool.getSign(msg, "$UN"));
		}

		public void overTime() {
			setnName(null);
		}

		public String getCodex() {
			return "$NAME.$ID"+id;
		}
	}
	
	private synchronized void setnName(String newName) {
		if (newName!=null && newName.length()>0) {
			name = newName;
			if (nameChangeListener!=null) {
				nameChangeListener.msg("name changed.");
			}
		}
	}
}
