// CatfoOD 2008-6-9 ����12:59:01

package iq.assist;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * һ�������ͣ�������������ͣ��������ϣ��齨ǰ��ɫ��Ϊ��ɫ
 */
public class MouseAutoColor extends MouseAdapter {
	private Component c;
	
	/**
	 * �����е�����������ͣ�������Զ���ɫ
	 * @param c - ��Ҫ������ܵ����
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
