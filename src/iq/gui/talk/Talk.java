package iq.gui.talk;

import iq.assist.ImagesFactory;
import iq.assist.SoundEffect;
import iq.assist.Tools;
import iq.event.IMessageAdmit;
import iq.event.UserEntity;
import iq.gui.other.PData;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JSplitPane;
import javax.swing.JPanel;
import java.awt.BorderLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JToolBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;



public class Talk extends JFrame implements IMessageAdmit {
	//private static final long serialVersionUID = -7504180388535718145L;
	protected static int talkCount = 0;
	
	private TalkControl ctrl;
	private UserEntity user;
	
	private final String NULLTIP = "发送文本不能为空!\n请重新输入!";
	
    protected Talk(UserEntity ue, IMessageAdmit i) {
    	user = ue;
    	ctrl = new TalkControl(this, ue);
        jbInit();
        init();
        ctrl.getBufferText(i);
        this.setTitle("正在和 "+ue.getName()+" ("+ue.getID()+") 聊天");
    }
    
    private void init() {
    	setSize(490,400);
    	this.setMinimumSize(getSize());
    	computeLocation();
    	this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    	this.addWindowListener(new WindowAdapter() {
		public void windowClosing(WindowEvent e) {
				ctrl.close();
			}
    	});
    	SoundEffect.playSE("气泡");
        this.setVisible(true);
    }
    
    private void computeLocation() {
    	Tools.ComponentMoveCenter(this);
    	int x = this.getLocation().x+(talkCount*15);
    	int y = this.getLocation().y+(talkCount*15);
    	this.setLocation(x, y);
    	talkCount++;
    }

    /** 取得好友的用户引用 */
    public UserEntity getUserEntity() {
    	return user;
    }
    
    private void jbInit() {
    	creatToolbarDown();
    	creatToolbarTop();
    	
        this.getContentPane().setLayout(gridLayout1);
        jPanel1.setLayout(borderLayout2);
        jPanel5.setLayout(borderLayout3);
        mingpian.setEnabled(false);
        mingpian.setForeground(Color.blue);
        mingpian.setToolTipText("暂未开放");
        mingpian.setText("名片");
        yaoqing.setEnabled(false);
        yaoqing.setForeground(Color.blue);
        yaoqing.setToolTipText("暂未开放");
        yaoqing.setText("邀请");
        duanxin.setEnabled(false);
        duanxin.setForeground(Color.blue);
        duanxin.setToolTipText("暂未开放");
        duanxin.setText("短信");
        fasongwenjian.setEnabled(false);
        fasongwenjian.setForeground(Color.blue);
        fasongwenjian.setToolTipText("暂未开放");
        fasongwenjian.setText("发送文件");
        yuyinshipin.setEnabled(false);
        yuyinshipin.setForeground(Color.blue);
        yuyinshipin.setToolTipText("暂未开放");
        yuyinshipin.setText("语音视频");
        jPanel6.setLayout(borderLayout4);
        jButton13.setForeground(Color.blue);
        jButton13.setText("查看好友资料");
        
        jButton13.addMouseListener(new Face_jButton13_mouseAdapter(this));
        
        jSplitPane2.setDividerSize(5);
        jSplitPane2.setDividerLocation(0.8);

        
        this.setJMenuBar(jMenuBar1);
        jMenu1.setText("文件(F)");
        jMenu2.setText("编辑(E)");
        jMenu3.setText("动作(V)");
        jMenu4.setText("设置(T)");
        jMenuItem1.setEnabled(false);
        jMenuItem1.setText("查看交谈记录(H)");
        jMenuItem2.setEnabled(false);
        jMenuItem2.setText("上传交谈记录(U)");
        jMenuItem3.setEnabled(false);
        jMenuItem3.setText("下载交谈记录(D)");
        jMenuItem4.setText("查看联系人资料(Z)");
        jMenuItem5.setText("关闭(C)   Alt+C");
        jMenuItem6.setText("撤销(Z)");
        jMenuItem7.setText("拷贝(C)");
        jMenuItem9.setText("粘贴(V)");
        jMenuItem10.setText("删除(D)");
        jMenuItem11.setText("全选(A)");
        jMenuItem12.setEnabled(false);
        jMenuItem12.setText("更改字体(T)");
        jMenuItem13.setText("邀请某人加入对话(T)");
        jMenu5.setEnabled(false);
        jMenu5.setText("语音视频");
        jMenuItem14.setEnabled(false);
        jMenuItem14.setText("超级视频");
        jMenuItem15.setEnabled(false);
        jMenuItem15.setText("超级语音");
        jMenuItem16.setEnabled(false);
        jMenuItem16.setText("播放影音文件");
        jMenuItem17.setEnabled(false);
        jMenuItem17.setText("视频调节");
        jMenuItem18.setEnabled(false);
        jMenuItem18.setText("传送文件(F)");
        jMenuItem19.setEnabled(false);
        jMenuItem19.setText("发送文件(A)");
        jMenuItem20.setEnabled(false);
        jMenuItem20.setText("发送手机短信(M)");
        jMenuItem21.setEnabled(false);
        jMenuItem21.setText("截屏(C)");
        jMenuItem23.setEnabled(false);
        jMenuItem23.setText("远程协助(H)");
        jMenuItem24.setEnabled(false);
        jMenuItem24.setText("远程演示文档(D)");
        jMenuItem25.setEnabled(false);
        jMenuItem25.setText("个人形象设置(G)");
        jMenuItem26.setEnabled(false);
        jMenuItem26.setText("设置窗口置顶(T)");
        jMenuItem27.setEnabled(false);
        jMenuItem27.setText("不接收自定义表情(V)");
        jMenuItem28.setEnabled(false);
        jMenuItem28.setText("阻止该联系人的消息(P)");
        jMenuItem29.setEnabled(false);
        jMenuItem29.setText("消息模式(M)");
        jMenuItem30.setEnabled(false);
        jMenuItem30.setText("交谈模式(C)");
        jMenu6.setText("快速回复");
        jRadioButtonMenuItem1.setToolTipText("");
        jRadioButtonMenuItem1.setAction(null);
        jRadioButtonMenuItem1.setText("Hi~ ^_^");
        
        jRadioButtonMenuItem1.addMouseListener(new
                Face_jRadioButtonMenuItem1_mouseAdapter(this));
        
        jRadioButtonMenuItem2.setText("OK,没问题!");
        ziti.setEnabled(false);
        ziti.setForeground(Color.blue);
        ziti.setToolTipText("暂未开放");
        biaoqing.setEnabled(false);
        biaoqing.setForeground(Color.blue);
        biaoqing.setToolTipText("暂未开放");
        tupian.setEnabled(false);
        tupian.setForeground(Color.blue);
        tupian.setToolTipText("暂未开放");
        jieping.setEnabled(false);
        jieping.setForeground(Color.blue);
        jieping.setToolTipText("暂未开放");
        kuaihui.setEnabled(false);
        kuaihui.setForeground(Color.blue);
        kuaihui.setToolTipText("暂未开放");
        
        xieru.setText("Hi.");
        jilu.setText("<font color=gray face=\"Georgia, " +
        		"Times New Roman, Times, serif\">iQ 2008</font> ");
        jilu.setEditable(false);
        
        xieru.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyPressed(java.awt.event.KeyEvent e) {
				// 同时按下 atl+enter
				if (e.getModifiersEx()==128 && e.getKeyCode()==10) {
					sendMsg();
				}
			}
		});
        
        fasong.addMouseListener(new Face_fasong_mouseAdapter(this));
        guanbi.addMouseListener(new Face_guanbi_mouseAdapter(this));
        
        jPanel3.setLayout(gridLayout2);
        jSplitPane3.setOrientation(JSplitPane.VERTICAL_SPLIT);
        this.getContentPane().add(jSplitPane1);
        jSplitPane2.setOrientation(JSplitPane.VERTICAL_SPLIT);
        jPanel2.setLayout(borderLayout1);
        
        fasong.setText("发送(CTRL+Enter)");
        guanbi.setText("关闭");
        
        
        jSplitPane1.add(jSplitPane2, JSplitPane.LEFT);
		jSplitPane1.setDividerSize(5);
		jSplitPane1.setDividerLocation(0.8);
        
        jSplitPane2.add(jPanel1, JSplitPane.TOP);
        jSplitPane2.add(jPanel2, JSplitPane.BOTTOM);
        jPanel2.add(jPanel4, java.awt.BorderLayout.SOUTH);
        jPanel4.add(guanbi);
        jPanel4.add(fasong);
        jPanel2.add(jToolBar1, java.awt.BorderLayout.NORTH);
        
        jPanel2.add(jScrollPane1, java.awt.BorderLayout.CENTER);
        jScrollPane1.getViewport().add(xieru);
        jSplitPane1.add(jPanel3, JSplitPane.RIGHT);
        jPanel3.add(jSplitPane3);
        jPanel1.add(jPanel5, java.awt.BorderLayout.NORTH);
        jPanel5.add(jToolBar2, java.awt.BorderLayout.WEST);

        jPanel1.add(jPanel6, java.awt.BorderLayout.CENTER);
        jPanel6.add(jButton13, java.awt.BorderLayout.NORTH);
        jPanel6.add(jScrollPane2, java.awt.BorderLayout.CENTER);
        jScrollPane2.getViewport().add(jilu);
        jMenuBar1.add(jMenu1);
        jMenuBar1.add(jMenu2);
        jMenuBar1.add(jMenu3);
        jMenuBar1.add(jMenu4);
        jMenu1.add(jMenuItem1);
        jMenu1.add(jMenuItem2);
        jMenu1.add(jMenuItem3);
        jMenu1.addSeparator();
        jMenu1.add(jMenuItem4);
        jMenu1.addSeparator();
        jMenu1.add(jMenuItem5);
        jMenu2.add(jMenuItem6);
        jMenu2.add(jMenuItem7);
        jMenu2.add(jMenuItem9);
        jMenu2.add(jMenuItem10);
        jMenu2.add(jMenuItem11);
        jMenu2.addSeparator();
        jMenu2.add(jMenuItem12);
        jMenu3.add(jMenuItem13);
        jMenu3.addSeparator();
        jMenu3.add(jMenu5);
        jMenu3.addSeparator();
        jMenu3.add(jMenuItem18);
        jMenu3.add(jMenuItem19);
        jMenu3.add(jMenuItem20);
        jMenu3.addSeparator();
        jMenu3.add(jMenuItem21);
        jMenu3.addSeparator();
        jMenu3.add(jMenu6);
        jMenu3.addSeparator();
        jMenu3.add(jMenuItem23);
        jMenu3.add(jMenuItem24);
        jMenu5.add(jMenuItem14);
        jMenu5.add(jMenuItem15);
        jMenu5.add(jMenuItem16);
        jMenu5.add(jMenuItem17);
        jMenu4.add(jMenuItem25);
        jMenu4.addSeparator();
        jMenu4.add(jMenuItem26);
        jMenu4.addSeparator();
        jMenu4.add(jMenuItem27);
        jMenu4.add(jMenuItem28);
        jMenu4.addSeparator();
        jMenu4.add(jMenuItem29);
        jMenu4.add(jMenuItem30);
        jMenu6.add(jRadioButtonMenuItem1);
        jMenu6.add(jRadioButtonMenuItem2);
        jSplitPane2.setDividerLocation(220);
        jSplitPane1.setDividerLocation(340);
        
		jSplitPane1.setResizeWeight(0.8);
		jSplitPane2.setResizeWeight(0.8);

        jSplitPane3.setDividerLocation(200);
		jSplitPane3.setResizeWeight(0.5);
		jSplitPane3.add(new TalkInfoPane(user), JSplitPane.TOP);
		jSplitPane3.add(new LaughablyPanel(), JSplitPane.BOTTOM);
				
        goup.add(jRadioButtonMenuItem1);
        goup.add(jRadioButtonMenuItem2);
    }
    
    private void creatToolbarDown() {
    	String[] tips = {"设置字体颜色和格式", "选择表情", "发送魔法表情",
    			"发送窗口抖动", "发送图片", "选择音乐场景", "选择主体包", "炫铃",
    			"捕捉屏幕", "聊天纪录"};
    	
    	JButton b[] = new JButton[tips.length];
    	for (int i=0; i<tips.length; ++i) {
    		b[i] = new JButton();
    		b[i].setToolTipText(tips[i]);
    		b[i].setIcon(ImagesFactory.creatIcon("images/ti/"+(i+1)+".png"));
    		if (i%4==0) {
    			jToolBar1.addSeparator();
    		}
    		jToolBar1.add(b[i]);
    	}
    	
    	b[3].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctrl.sendShake();
			}
    	});
    	
    	b[9].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctrl.openHistory();
			}
    	});
    	b[9].setText("聊天纪录");
    }
    
    private void creatToolbarTop() {
    	//jToolBar2
    	String[] tips = {"", "", "", "", "", "", "", "", "", };
    	for (int i=0; i<tips.length; ++i) {
    		JButton b = new JButton();
    		b.setToolTipText(tips[i]);
    		b.setIcon(ImagesFactory.creatIcon("images/ti/T"+i+".png"));

    		jToolBar2.add(b);
    	}
    }
    
    ButtonGroup goup =new ButtonGroup();
    GridLayout gridLayout1 = new GridLayout();
    JSplitPane jSplitPane1 = new JSplitPane();
    JSplitPane jSplitPane2 = new JSplitPane();
    JPanel jPanel1 = new JPanel();
    JPanel jPanel2 = new JPanel();
    JPanel jPanel3 = new JPanel();
    BorderLayout borderLayout1 = new BorderLayout();
    JPanel jPanel4 = new JPanel();
    JButton fasong = new JButton();
    JButton guanbi = new JButton();
    JToolBar jToolBar1 = new JToolBar();
    JButton kuaihui = new JButton();
    JButton jieping = new JButton();
    JButton tupian = new JButton();
    JButton biaoqing = new JButton();
    JButton ziti = new JButton();
    JScrollPane jScrollPane1 = new JScrollPane();
    JTextArea xieru = new JTextArea();
    JPanel jPanel5 = new JPanel();
    BorderLayout borderLayout2 = new BorderLayout();
    BorderLayout borderLayout3 = new BorderLayout();
    JToolBar jToolBar2 = new JToolBar();
    JButton mingpian = new JButton();
    JButton yaoqing = new JButton();
    JButton duanxin = new JButton();
    JButton fasongwenjian = new JButton();
    JButton yuyinshipin = new JButton();
    JPanel jPanel6 = new JPanel();
    BorderLayout borderLayout4 = new BorderLayout();
    JButton jButton13 = new JButton();
    JScrollPane jScrollPane2 = new JScrollPane();
    JEditorPane jilu = new JEditorPane("text/html","");
    JMenuBar jMenuBar1 = new JMenuBar();
    JMenu jMenu1 = new JMenu();
    JMenu jMenu2 = new JMenu();
    JMenu jMenu3 = new JMenu();
    JMenu jMenu4 = new JMenu();
    JMenuItem jMenuItem1 = new JMenuItem();
    JMenuItem jMenuItem2 = new JMenuItem();
    JMenuItem jMenuItem3 = new JMenuItem();
    JMenuItem jMenuItem4 = new JMenuItem();
    JMenuItem jMenuItem5 = new JMenuItem();
    JMenuItem jMenuItem6 = new JMenuItem();
    JMenuItem jMenuItem7 = new JMenuItem();
    JMenuItem jMenuItem9 = new JMenuItem();
    JMenuItem jMenuItem10 = new JMenuItem();
    JMenuItem jMenuItem11 = new JMenuItem();
    JMenuItem jMenuItem12 = new JMenuItem();
    JMenuItem jMenuItem13 = new JMenuItem();
    JMenu jMenu5 = new JMenu();
    JMenuItem jMenuItem14 = new JMenuItem();
    JMenuItem jMenuItem15 = new JMenuItem();
    JMenuItem jMenuItem16 = new JMenuItem();
    JMenuItem jMenuItem17 = new JMenuItem();
    JMenuItem jMenuItem18 = new JMenuItem();
    JMenuItem jMenuItem19 = new JMenuItem();
    JMenuItem jMenuItem20 = new JMenuItem();
    JMenuItem jMenuItem21 = new JMenuItem();
    JMenuItem jMenuItem23 = new JMenuItem();
    JMenuItem jMenuItem24 = new JMenuItem();
    JMenuItem jMenuItem25 = new JMenuItem();
    JMenuItem jMenuItem26 = new JMenuItem();
    JMenuItem jMenuItem27 = new JMenuItem();
    JMenuItem jMenuItem28 = new JMenuItem();
    JMenuItem jMenuItem29 = new JMenuItem();
    JMenuItem jMenuItem30 = new JMenuItem();
    JMenu jMenu6 = new JMenu();
    JRadioButtonMenuItem jRadioButtonMenuItem1 = new JRadioButtonMenuItem();
    JRadioButtonMenuItem jRadioButtonMenuItem2 = new JRadioButtonMenuItem();
    GridLayout gridLayout2 = new GridLayout();
    JSplitPane jSplitPane3 = new JSplitPane();

    // 发送按钮
    public void fasong_mouseClicked(MouseEvent e) {
    	sendMsg();
    }

    public void guanbi_mouseClicked(MouseEvent e) {
        ctrl.close();
    }

    public void jButton13_mouseClicked(MouseEvent e) {
    	new PData(user);
    }

    public void jRadioButtonMenuItem1_mouseClicked(MouseEvent e) {
//        工具栏里的动作-快速回复-单选按钮事件
    }

    // 无用
	public Object admit() {return null;}

	public void msg(Object o) {
		ctrl.recvMsg((String)o);
	}
	
	public JEditorPane getOutpane() {
		return jilu;
	}
	
	private void sendMsg() {
	   String xieru1= xieru.getText();
	   if(xieru1.trim().length()>0 && !xieru1.equals(NULLTIP)) 
	   {
	       ctrl.sendTalk(xieru.getText());
	       xieru.setText("");
	   } else {
		   xieru.setText(NULLTIP);
		   xieru.selectAll();
	   }
	}
}


class Face_jRadioButtonMenuItem1_mouseAdapter extends MouseAdapter {
    private Talk adaptee;
    Face_jRadioButtonMenuItem1_mouseAdapter(Talk adaptee) {
        this.adaptee = adaptee;
    }

    public void mouseClicked(MouseEvent e) {
        adaptee.jRadioButtonMenuItem1_mouseClicked(e);
    }
}


class Face_fasong_mouseAdapter extends MouseAdapter {
    private Talk adaptee;
    Face_fasong_mouseAdapter(Talk adaptee) {
        this.adaptee = adaptee;
    }

    public void mouseClicked(MouseEvent e) {
        adaptee.fasong_mouseClicked(e);
    }
}


class Face_guanbi_mouseAdapter extends MouseAdapter {
    private Talk adaptee;
    Face_guanbi_mouseAdapter(Talk adaptee) {
        this.adaptee = adaptee;
    }

    public void mouseClicked(MouseEvent e) {
        adaptee.guanbi_mouseClicked(e);
    }
}


class Face_jButton13_mouseAdapter extends MouseAdapter {
    private Talk adaptee;
    Face_jButton13_mouseAdapter(Talk adaptee) {
        this.adaptee = adaptee;
    }

    public void mouseClicked(MouseEvent e) {
        adaptee.jButton13_mouseClicked(e);
    }
}
