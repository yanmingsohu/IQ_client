// CatfoOD 2008-6-10 ����08:40:16

package iq.event;

public class UserEntity {
	private String id;
	private UserInfo info;
	
	public UserEntity(String id) {
		this.id = id;
		info = new UserInfo(id);
	}
	
	public String getID() {
		return id;
	}
	
	public String getName() {
		return info.getName();
	}
	
	public UserInfo getInfo() {
		return info;
	}
	
	/** ���Ƿ��ص�ǰ�û��ĺ����б���������û��� */
	public static FriendList getFriendList() {
		return FriendList.getList();
	}
	
	/**
	 * �Ժ����б��ж�ָ���û��Ƿ����б������������
	 */
	public String toString() {
		return id;
	}
	
	/** 
	 * ��Ҫ�����Ժ����б��ж�ָ���û��Ƿ����б������������
	 */
	public boolean equals(Object o) {
		return id.equals(o.toString());
	}
}
