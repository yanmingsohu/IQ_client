package iq.test;

import iq.assist.Tools;
import iq.gui.JAHideFrame;
import iq.gui.LookandfeelFactory;
import iq.gui.talk.g_x;

import javax.swing.JFrame;
import javax.swing.JLabel;

// 测试自动窗体隐藏
public class autotest {

	// 测试代码
	public static void main(String[] s) {
//		setLookandfeel();
//		JAHideFrame jf = new JAHideFrame();
//		//jf.setIconImage(null);
//		jf.add(new JLabel("fff"));
//		jf.setBounds(10, 10, 200, 700);
//		jf.setVisible(true);
//		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		g_x g = new g_x();
		for (int i=0; i<20; ++i) 
		Tools.pl(g.getNext());
	}
	
	public static void setLookandfeel() {
		LookandfeelFactory.setRandomLookandFeel();
		JFrame.setDefaultLookAndFeelDecorated(true);
	}
}
