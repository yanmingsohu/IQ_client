package iq.gui.layout;

// CatfoOD 2008.6.10

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import javax.swing.JPanel;

public class PopPanelLayout implements LayoutManager {
//	private HashMap<String,Component> map = new HashMap<String,Component>();
//	private String currentkey;

	private ArrayList<CompPack> list = new ArrayList<CompPack>();
	
	public int BUTTONHIGH = 30;
	private volatile boolean complete = true;
	private int current = 1;
	private int step=3;
	
	/**
	 * 设置当前显示的面板
	 * @param key - 面板的名字
	 */
	public void setCurrentPanel(JPanel key) {
		CompPack cp = find(key);
		current = cp.getCount();
		cp.movePosition();
		complete = false;
	}
	
	public boolean isComplete() {
		return complete;
	}
	
	/**
	 * 设置探出面板在改变时，移动的步长
	 * @param step - 移动的步长
	 */
	public void setStep(int step) {
		this.step = step;
	}

	public Dimension minimumLayoutSize(Container c) {
		return new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE);
	}

	public Dimension preferredLayoutSize(Container c) {
		return null;
	}

	public void addLayoutComponent(String s, Component com) {
		CompPack cp = new CompPack(com);
		cp.position = cp.UP;
		int size = list.size();
		if (size>0 && list.get(size-1)!=null) {
			for (int i=0; i<list.size(); ++i) {
				list.get(i).position = cp.DOWN;
			}
		}
		list.add(cp);
	}

	public void removeLayoutComponent(Component c) {
		list.remove(find(c));
	}
	
	public void p(Object o) {
		System.out.println(o.toString());
	}
	
	private CompPack find(Component c) {
		for (int i=0; i<list.size(); ++i) {
			if (list.get(i).equals(c)) {
				return list.get(i);
			}
		}
		return null;
	}
	
	private CompPack find(int c) {
		for (int i=0; i<list.size(); ++i) {
			if (list.get(i).getCount()==c) {
				return list.get(i);
			}
		}
		return null;
	}
	
	public void layoutContainer(Container c) {
		synchronized (c.getTreeLock()) {
			Rectangle cr = c.getBounds();
			int size = list.size();
			int comh = cr.height - BUTTONHIGH*(size-1);

			complete = true;
			for (int i=0; i<size; ++i) {
				list.get(i).layoutContainer(cr, comh);
			}
		}
	}
	
	private class CompPack {
		
		public final boolean UP = true;
		public final boolean DOWN = false;
		
		private Component com;
		private boolean position;
		private Point newp, oldp;
		private int count;
		
		private boolean isMoveing = false; 
		
		public CompPack(Component c) {
			com = c;
			count = countsize;
			countsize++;
		}
		
		/**
		 * 从一个位置移动到另一个位置
		 */
		public void movePosition() {
			if (position==DOWN) {
				isMoveing = true;
				CompPack cpo = find(count+1);
				if (cpo!=null) {
					if (cpo.position==DOWN) {
						cpo.movePosition();
					}
				}
			} else {
				if (count!=current) {
					isMoveing = true;
				}
				if (count>1) {
					CompPack cpo = find(count-1);
					if (cpo.position==UP) {
						cpo.movePosition();
					}
				}
			}
		}
		
		/** 1~100% */
		private int present = 1;
		/**
		 * 让组件自己布置自己
		 * @param r - 上级容器的尺寸
		 * @param height - 每个内部面板的高度
		 */
		public void layoutContainer(Rectangle r, int height) {
			if (isMoveing) {
				present += step;
				int h = (height/100)*present;
				
				int space = ((r.height-count*BUTTONHIGH)-
							(countsize-count-1)*BUTTONHIGH)/100;
				
				if (position==UP) {
					com.setBounds(0, 
							(countsize-count-1)*BUTTONHIGH+ space*present, 
							r.width, height-h);
				} else {
					com.setBounds(0, 
							r.height-count*BUTTONHIGH- space*present, 
							r.width, h);
				}
				
				if (present>=100) {
					position = !position;
					isMoveing = false;
					present = 1;
				}
			}
			if (!isMoveing) {
				if (position==DOWN) {
					com.setBounds(0, r.height-count*BUTTONHIGH, r.width, height);
				}
				else if (position==UP) {
					com.setBounds(0, (countsize-count-1)*BUTTONHIGH, r.width, height);
				}
			}
			complete = complete && (!isMoveing);
		}
		
		public boolean equals(Object o) {
			if (o==com) return true;
			else return false;
		}
		
		public int getCount() {
			return count;
		}
	}

	private static int countsize = 1;
}
