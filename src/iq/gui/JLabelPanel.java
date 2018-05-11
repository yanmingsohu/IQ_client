package iq.gui;
import javax.swing.BoxLayout;
import javax.swing.JScrollPane;
import javax.swing.JPanel;


public class JLabelPanel extends JScrollPane {

	private static final long serialVersionUID = 1L;
	private JPanel jPanel = null;
	/**
	 * This is the default constructor
	 */
	public JLabelPanel() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(300, 200);
		this.setViewportView(getJPanel());
		this.setHorizontalScrollBarPolicy(
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	}

	/**
	 * This method initializes jPanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel() {
		if (jPanel == null) {			
			jPanel = new JPanel();
			BoxLayout layout = new BoxLayout(jPanel, BoxLayout.Y_AXIS);
			
			jPanel.setLayout(layout);
			jPanel.setAlignmentX(TOP_ALIGNMENT);
		}
		return jPanel;
	}
	
	/**
	 * 添加一个内部项目
	 * @param com
	 */
	public void addAComponent(JUserEntityTemplet com) {
		jPanel.add(com);
	}
	
	/**
	 * 移出一个内部项目
	 * @param com
	 */
	public void removeAComponent(JUserEntityTemplet com) {
		jPanel.remove(com);
	}
	
	/**
	 * 从此容器中移除所有组件。此方法还通知布局管理器，<br>
	 * 通过 removeLayoutComponent 方法从此容器的布局中移除这些组件。 <br>
	 */
	public void removeAll() {
		jPanel.removeAll();
	}
}
