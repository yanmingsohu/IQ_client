// CatfoOD 2008-6-9 上午10:14:07

package iq.history;

import iq.event.UserEntity;

import java.io.*;
import java.util.ArrayList;

public class ChatHistory {
	protected final String rpath = "iq\\";
	protected final String tfexn = ".to";
	
	private ArrayList<ChatHisInfo> list;
	private String id;
	
	protected ChatHistory(String id) {
		list = new ArrayList<ChatHisInfo>();
		this.id = id;
		
		File f = new File(rpath+id);
		if (f.isDirectory()) {
			File[] fs = f.listFiles(new filterFile());
			
			for (int i=0; i<fs.length; ++i) {
				list.add( creatNewChat(fs[i]) );
			}
		} else {
			f.mkdir();
		}
	}
	
	/**
	 * 返回聊天纪录列表
	 * @return ChatHisInfo[];
	 */
	public ChatHisInfo[] getAllHistory() {
		return list.toArray(new ChatHisInfo[0]);
	}
	
	/**
	 * 返回一个uid的聊天纪录，如果不存在就建立他
	 * @param uid - 好友用户id
	 * @return - ChatHisInfo
	 */
	public ChatHisInfo getChatHisInfo(UserEntity uid) {
		int i = list.indexOf(uid);
		if (i>=0) {
			return list.get(i);
		} else {
			ChatHisInfo newc = creatNewChat(
					new File(rpath+id+'\\'+uid.getID()+tfexn));
			list.add(newc);
			return newc;
		}
	}
	
	private ChatHisInfo creatNewChat(File f) {
		try {
			return new ChatHisInfo(id, getFriendId(f), f);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	// 文件过滤策略
	private class filterFile implements FilenameFilter {
		public boolean accept(File dir, String name) {
			int il = name.indexOf(tfexn);
			if (il>0) {
				return true;
			} else {
				return false;
			}
		}
	}
	
	private String getFriendId(File f) {
		String fname = f.getName();
		int il = fname.indexOf(tfexn);
		return fname.substring(0, il);
	}
}