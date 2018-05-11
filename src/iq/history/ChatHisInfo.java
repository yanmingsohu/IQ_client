// CatfoOD 2008-6-9 ����10:26:31

package iq.history;

import iq.assist.Tools;

import java.io.*;

/**
 * ���������¼�ļ���class
 */
public class ChatHisInfo {
	private String sid;
	private String uid;
	private File hisFile;
	
	private FileOutputStream out;
	private FileInputStream in;
	
	/**
	 * ��ȡ/д��������Ϣ
	 * @param sid - �û���id
	 * @param uid - ���ѵ�id
	 * @throws IOException - ��������ļ������ܳ�����쳣
	 */
	protected ChatHisInfo(String sid, String uid, File f) throws IOException {
		this.sid = sid;
		this.uid = uid;
		hisFile = f;
		if (!f.exists()) {
			f.createNewFile();
		}
		out = new FileOutputStream(f,true);
		in  = new FileInputStream(f);
	}
	
	/**
	 * ��������ʷ�ļ�д����Ϣ,��ĩβ�Զ���ӻ���
	 * @param msg - String�ı�,text��ʽ
	 */
	public void write(String msg) {
		try {
			out.write(msg.concat("\n").getBytes());
		} catch (IOException e) {
			Tools.error(e);
		}
	}
	
	/**
	 * ��ȡ������Ϣ
	 * @return msg text
	 */
	public String read() {
		StringBuffer buff = new StringBuffer();
		byte[] b = new byte[1024];
		try {
			int i = in.read(b);
			while (i>0) {
				buff.append( new String(b, 0, i) );
				i = in.read(b);
			}
		} catch(Exception e) {
			Tools.error(e);
		}
		return buff.toString();
	}
	
	/**
	 * ��д�ķ�����ֻ�жϸ�������toString�����뱾�����uid�Ƿ����
	 */
	public boolean equals(Object o) {
		return o.toString().equals(uid);
	}
	
	public String toString() {
		return uid;
	}
}
