package iq.gui.layout;

import iq.assist.SoundEffect;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;


public class JPopPanel extends JPanel {
	private static final long serialVersionUID = -2590504207416805387L;
	private PopPanelLayout ppl;
	
	public JPopPanel() {
		super();
		ppl = new PopPanelLayout();
		ppl.setStep(8);
		this.setLayout(ppl);
		this.setDoubleBuffered(true);
	}
	
	/** 这个方法被禁止 */
	public Component add(Component c) {
		throw new IllegalArgumentException("cannot do is.");
	}
	
	/**
	 * 添加个一内部探出面板
	 * @param comp - 要填加的组件,必须是一个awt容器
	 * @param title - 一个字符串,描述内部面板的标题
	 */
	public void addPanel(Component comp, String title) {
		if (comp instanceof Container) {
			super.add(addInPane(comp, title), title);
		} else {
			throw new IllegalArgumentException("cannot add "+comp);
		}
	}
	
	private JPanel addInPane(Component c, String title) {
		JScrollPane sp = new JScrollPane();
		sp.getViewport().add(c);
		sp.setHorizontalScrollBarPolicy(JScrollPane.
								HORIZONTAL_SCROLLBAR_NEVER);
		
		JButton button = new JButton(title);
		
		JPanel pane = new JPanel();
		pane.setLayout(new BorderLayout());
		pane.add(button, BorderLayout.NORTH);
		pane.add(sp, BorderLayout.CENTER);
		
		new JButtonEven(pane, button);
		return pane;
	}
	
	private class JButtonEven implements ActionListener {
		JPanel key;
		JButtonEven(JPanel key, JButton butt) {
			this.key = key;
			ppl.BUTTONHIGH = butt.getPreferredSize().height;
			butt.addActionListener(this);
		}
		public void actionPerformed(ActionEvent arg0) {
			SoundEffect.playSE("切换");
			ppl.setCurrentPanel(key);
			new Thread() {
				public void run() {
					while (!ppl.isComplete()) {
						JPopPanel.this.doLayout();
						try {
							Thread.sleep(5);
						} catch (InterruptedException e) {}
					}
					JPopPanel.this.repaint();
				}
			}.start();
		}
	}
}
