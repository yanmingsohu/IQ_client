// CatfoOD 2008-6-13 上午07:41:44

package iq.event;

/**
 * IMessageAdmit本身是一个消息的监听者，它可以把缓存的
 * 对象转发给admit()的调用者
 */
public interface IMessageAdmit extends IMessage {
	/**
	 * 通过这个方法得到IMessageAdmit上一次收到的对象
	 * @return - 如果没有缓存的对象返回null
	 */
	public Object admit();
}
