// CatfoOD 2008-6-10 上午08:40:16

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
	
	/** 这是返回当前用户的好友列表，而非这个用户的 */
	public static FriendList getFriendList() {
		return FriendList.getList();
	}
	
	/**
	 * 对好友列表判断指定用户是否在列表中起决定作用
	 */
	public String toString() {
		return id;
	}
	
	/** 
	 * 重要！，对好友列表判断指定用户是否在列表中起决定作用
	 */
	public boolean equals(Object o) {
		return id.equals(o.toString());
	}
}
