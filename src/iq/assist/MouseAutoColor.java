// CatfoOD 2008-6-9 下午12:59:01

package iq.assist;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * 一个鼠标悬停适配器，当鼠标停留在组件上，组建前景色变为蓝色
 */
public class MouseAutoColor extends MouseAdapter {
	private Component c;
	
	/**
	 * 参数中的组件当鼠标悬停，可以自动变色
	 * @param c - 需要这个功能的组件
	 */
	public MouseAutoColor(Component c) {
		this.c = c;
		c.setCursor(new Cursor(Cursor.HAND_CURSOR));
		c.addMouseListener(this);
	}
	
	public void mouseEntered(MouseEvent e) {
		c.setForeground(Color.blue);
	}

	public void mouseExited(MouseEvent e) {
		c.setForeground(null);
	}
}
