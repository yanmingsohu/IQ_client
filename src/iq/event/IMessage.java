// CatfoOD 2008-6-12 上午08:47:10

package iq.event;

/**
 * 简单消息借口，GUI组件用这个接口互相之间传递消息
 */
public interface IMessage {
	/**
	 * 发送给消息监听者感兴趣的消息
	 * @param o - 一般为null
	 */
	public void msg(Object o);
}
