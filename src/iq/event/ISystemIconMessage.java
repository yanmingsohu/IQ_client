package iq.event;

import java.awt.Image;

public interface ISystemIconMessage {
	/**
	 * 这个方法返回用户的昵称，或者ID,由使用者确定
	 * 返回的值用以确定在系统图标上弹出的提示文本。
	 * 
	 * @return - 系统图标上弹出的提示文本。
	 */
	public String getUserName();
	
	/**
	 * 返回用户的头像，返回空则使用默认的头像
	 * 
	 * @return - 头像的图标
	 */
	public Image getUserIcon();
	
	/**
	 * 这个方法一般在用户双击图标时产生回调
	 * 以便通知添加入系统图标的组件去执行相应的操作
	 */
	public void callbackOpenEvent();
}
