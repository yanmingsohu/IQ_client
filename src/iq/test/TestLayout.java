package iq.test;


import iq.gui.LookandfeelFactory;
import iq.gui.layout.JPopPanel;
import iq.gui.layout.PopPanelLayout;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Rectangle;
import java.io.IOException;

import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

/**
 * <p>Title: </p>
 *
 * <p>Description: </p>
 *
 * <p>Copyright: Copyright (c) 2008</p>
 *
 * <p>Company: </p>
 *
 * @author not attributable
 * @version 1.0
 */
public class TestLayout extends JFrame {
    public static void main(String s[]) {
    	try {
			LookandfeelFactory.loadConfig();
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
    	JPopPanel jp = new JPopPanel();
    	jp.addPanel(new JPanel(), "a");
    	jp.addPanel(new JPanel(), "b");
    	jp.addPanel(new JPanel(), "c");
    	jp.addPanel(new JPanel(), "d");
    	jp.addPanel(new JPanel(), "e");
    	
    	JFrame f = new JFrame();
    	f.add(jp);
    	f.setBounds(1, 1, 200, 300);
    	f.setVisible(true);
    	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}


