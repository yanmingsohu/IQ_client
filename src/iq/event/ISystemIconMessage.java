package iq.event;

import java.awt.Image;

public interface ISystemIconMessage {
	/**
	 * ������������û����ǳƣ�����ID,��ʹ����ȷ��
	 * ���ص�ֵ����ȷ����ϵͳͼ���ϵ�������ʾ�ı���
	 * 
	 * @return - ϵͳͼ���ϵ�������ʾ�ı���
	 */
	public String getUserName();
	
	/**
	 * �����û���ͷ�񣬷��ؿ���ʹ��Ĭ�ϵ�ͷ��
	 * 
	 * @return - ͷ���ͼ��
	 */
	public Image getUserIcon();
	
	/**
	 * �������һ�����û�˫��ͼ��ʱ�����ص�
	 * �Ա�֪ͨ�����ϵͳͼ������ȥִ����Ӧ�Ĳ���
	 */
	public void callbackOpenEvent();
}
