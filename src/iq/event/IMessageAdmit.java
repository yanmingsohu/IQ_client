// CatfoOD 2008-6-13 ����07:41:44

package iq.event;

/**
 * IMessageAdmit������һ����Ϣ�ļ����ߣ������԰ѻ����
 * ����ת����admit()�ĵ�����
 */
public interface IMessageAdmit extends IMessage {
	/**
	 * ͨ����������õ�IMessageAdmit��һ���յ��Ķ���
	 * @return - ���û�л���Ķ��󷵻�null
	 */
	public Object admit();
}
