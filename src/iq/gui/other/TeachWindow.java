// CatfoOD 2008-6-12 ÏÂÎç11:31:02

package iq.gui.other;

import java.awt.Component;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import iq.assist.Tools;
import iq.gui.NextVersion;

import javax.swing.JWindow;

public class TeachWindow extends JWindow {
	private static TeachWindow tw = new TeachWindow();
	
	public static void start() {
		Tools.ComponentMoveCenter(tw);
		tw.setVisible(true);
	}
	
	// ------------------- instance -----------------------
	private TeachWindow() {
		NextVersion p = new NextVersion(); 
		this.add(p);
		this.setSize(300, 150);
		this.setAlwaysOnTop(true);
		
		Component[] cs = p.getComponents();
		for (int i=0; i<cs.length; ++i) {
			cs[i].addMouseListener(new ML());
		}
	}
	
	private class ML extends MouseAdapter {
		public void mouseEntered(MouseEvent e) {
			TeachWindow.this.setVisible(false);
		}
	}
}
