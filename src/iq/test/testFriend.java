package iq.test;
import iq.assist.SoundEffect;
import iq.assist.Tools;
import iq.event.ISystemIconMessage;
import iq.gui.JAHideFrame;
import iq.gui.JLabelPanel;
import iq.gui.JUserEntityTemplet;
import iq.gui.SystemIcon;
import iq.gui.layout.JPopPanel;

import javax.swing.SwingUtilities;
import java.awt.BorderLayout;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JFrame;

public class testFriend extends JAHideFrame {

	private static final long serialVersionUID = 1L;
	private JPopPanel jContentPane = null;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		autotest.setLookandfeel();

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				testFriend thisClass = new testFriend();
				thisClass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				thisClass.setVisible(true);
			}
		});
	}

	private void addLabel() {
		setVisible(true);
		
		final ArrayList<JUserEntityTemplet> list = 
			new ArrayList<JUserEntityTemplet>();
		
		JUserEntityTemplet e = new JUserEntityTemplet() {
			public void mouseTwoClick() {
				SoundEffect.playSE("ø»À‘");
				flicker(false);
			}
			public void mouseStasis() {
				SoundEffect.playSE("«–ªª");
			}
		};
		e.setText("Œ“ «”–…˘“Ùµƒ£°£°£°£°");
		e.setIcon(new ImageIcon("images/p32a.jpg"));
		list.add(e);
		pane.addAComponent(e);
		
		for (int i=1;i<135; ++i) {
			JUserEntityTemplet l = new JLabel2();
			l.setText("iQ2008 test user "+"face/"+i+".bmp");
			l.setIcon(new ImageIcon("face/"+i+".gif"));
			pane.addAComponent(l);
			list.add(l);
		}
		
		new Thread() {
			public void run() {
				while (true) {
					int i = (int)(9*Math.random());
					boolean fl = true;//(Math.random()>0.7f)? true: false;
					list.get(i).flicker(fl);
					
					try {
						sleep((int)(8000*Math.random()));
					} catch (InterruptedException e) {}
					
					SoundEffect.playSE("œ˚œ¢");
				}
			}
		}.start();
	}
	/**
	 * This is the default constructor
	 */
	public testFriend() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setBounds(20, 20, 200, 500);
		this.setContentPane(getJContentPane());
		this.setTitle("JFrame");
		addLabel();
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPopPanel();
			jContentPane.setLayout(new BorderLayout());
			pane = new JLabelPanel();
			jContentPane.addPanel(pane, "test");
		}
		return jContentPane;
	}

	private JLabelPanel pane;
}

class JLabel2 extends JUserEntityTemplet implements ISystemIconMessage {
	private Image img = null;

	public void callbackOpenEvent() {
		Tools.pl(this.getText()+" ±ªÀ´ª˜.");
		flicker(false);
	}

	public Image getUserIcon() {
		return img;
	}

	public String getUserName() {
		return getText();
	}
	
	public void mouseTwoClick() {
		SoundEffect.playSE("ø»À‘");
		flicker(false);
		SystemIcon.getInstance().removeMessage(this);
	}
	
	public void mouseStasis() {
		SoundEffect.playSE("«–ªª");
	}
	
	public void setIcon(ImageIcon icon) {
		img = icon.getImage();
	}
	
	public void setIcon(Icon icon) {
		super.setIcon(icon);
		if (icon instanceof ImageIcon) {
			setIcon((ImageIcon)icon);
		}
	}
	
	public void flicker(boolean f) {
		super.flicker(f);
		if (f) {
			SystemIcon.getInstance().addMessage(this);
		}
	}
}