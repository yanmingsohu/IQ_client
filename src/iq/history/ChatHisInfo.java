// CatfoOD 2008-6-9 上午10:26:31

package iq.history;

import iq.assist.Tools;

import java.io.*;

/**
 * 操作聊天纪录文件的class
 */
public class ChatHisInfo {
	private String sid;
	private String uid;
	private File hisFile;
	
	private FileOutputStream out;
	private FileInputStream in;
	
	/**
	 * 读取/写入聊天信息
	 * @param sid - 用户的id
	 * @param uid - 好友的id
	 * @throws IOException - 如果建立文件出错跑出这个异常
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
	 * 向聊天历史文件写入消息,在末尾自动添加换行
	 * @param msg - String文本,text格式
	 */
	public void write(String msg) {
		try {
			out.write(msg.concat("\n").getBytes());
		} catch (IOException e) {
			Tools.error(e);
		}
	}
	
	/**
	 * 读取聊天消息
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
	 * 重写的方法，只判断给定对象toString方法与本对象的uid是否相等
	 */
	public boolean equals(Object o) {
		return o.toString().equals(uid);
	}
	
	public String toString() {
		return uid;
	}
}
