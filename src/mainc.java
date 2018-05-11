import java.io.IOException;

import javax.swing.JDialog;
import javax.swing.JFrame;

import iq.assist.Tools;
import iq.gui.LookandfeelFactory;
import iq.gui.logon.LogonFrame;
import iq.net.MsgFactory;

// CatfoOD 2008-6-8 下午11:21:42

public class mainc {
	private static final String defaultfeel = 
		"org.jvnet.substance.skin.SubstanceAutumnLookAndFeel";

	public static void main(String[] args) {
		autoLoadFeelconfig();
		try {
			MsgFactory.init();
			LogonFrame logon = new LogonFrame();
		} catch (IOException e) {
			Tools.show("建立网络连接失败."+e);
			e.printStackTrace();
			System.exit(1);
		}
	}

	private static void autoLoadFeelconfig() {
		try {
			LookandfeelFactory.loadConfig();
		} catch (IOException e) {
			LookandfeelFactory.set(defaultfeel);
		}
		JFrame.setDefaultLookAndFeelDecorated(true);
		JDialog.setDefaultLookAndFeelDecorated(true);
	}
}
