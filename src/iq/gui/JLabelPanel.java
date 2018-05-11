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
	 * ���һ���ڲ���Ŀ
	 * @param com
	 */
	public void addAComponent(JUserEntityTemplet com) {
		jPanel.add(com);
	}
	
	/**
	 * �Ƴ�һ���ڲ���Ŀ
	 * @param com
	 */
	public void removeAComponent(JUserEntityTemplet com) {
		jPanel.remove(com);
	}
	
	/**
	 * �Ӵ��������Ƴ�����������˷�����֪ͨ���ֹ�������<br>
	 * ͨ�� removeLayoutComponent �����Ӵ������Ĳ������Ƴ���Щ����� <br>
	 */
	public void removeAll() {
		jPanel.removeAll();
	}
}
