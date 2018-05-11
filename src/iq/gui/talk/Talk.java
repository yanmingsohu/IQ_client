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
	
	private final String NULLTIP = "�����ı�����Ϊ��!\n����������!";
	
    protected Talk(UserEntity ue, IMessageAdmit i) {
    	user = ue;
    	ctrl = new TalkControl(this, ue);
        jbInit();
        init();
        ctrl.getBufferText(i);
        this.setTitle("���ں� "+ue.getName()+" ("+ue.getID()+") ����");
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
    	SoundEffect.playSE("����");
        this.setVisible(true);
    }
    
    private void computeLocation() {
    	Tools.ComponentMoveCenter(this);
    	int x = this.getLocation().x+(talkCount*15);
    	int y = this.getLocation().y+(talkCount*15);
    	this.setLocation(x, y);
    	talkCount++;
    }

    /** ȡ�ú��ѵ��û����� */
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
        mingpian.setToolTipText("��δ����");
        mingpian.setText("��Ƭ");
        yaoqing.setEnabled(false);
        yaoqing.setForeground(Color.blue);
        yaoqing.setToolTipText("��δ����");
        yaoqing.setText("����");
        duanxin.setEnabled(false);
        duanxin.setForeground(Color.blue);
        duanxin.setToolTipText("��δ����");
        duanxin.setText("����");
        fasongwenjian.setEnabled(false);
        fasongwenjian.setForeground(Color.blue);
        fasongwenjian.setToolTipText("��δ����");
        fasongwenjian.setText("�����ļ�");
        yuyinshipin.setEnabled(false);
        yuyinshipin.setForeground(Color.blue);
        yuyinshipin.setToolTipText("��δ����");
        yuyinshipin.setText("������Ƶ");
        jPanel6.setLayout(borderLayout4);
        jButton13.setForeground(Color.blue);
        jButton13.setText("�鿴��������");
        
        jButton13.addMouseListener(new Face_jButton13_mouseAdapter(this));
        
        jSplitPane2.setDividerSize(5);
        jSplitPane2.setDividerLocation(0.8);

        
        this.setJMenuBar(jMenuBar1);
        jMenu1.setText("�ļ�(F)");
        jMenu2.setText("�༭(E)");
        jMenu3.setText("����(V)");
        jMenu4.setText("����(T)");
        jMenuItem1.setEnabled(false);
        jMenuItem1.setText("�鿴��̸��¼(H)");
        jMenuItem2.setEnabled(false);
        jMenuItem2.setText("�ϴ���̸��¼(U)");
        jMenuItem3.setEnabled(false);
        jMenuItem3.setText("���ؽ�̸��¼(D)");
        jMenuItem4.setText("�鿴��ϵ������(Z)");
        jMenuItem5.setText("�ر�(C)   Alt+C");
        jMenuItem6.setText("����(Z)");
        jMenuItem7.setText("����(C)");
        jMenuItem9.setText("ճ��(V)");
        jMenuItem10.setText("ɾ��(D)");
        jMenuItem11.setText("ȫѡ(A)");
        jMenuItem12.setEnabled(false);
        jMenuItem12.setText("��������(T)");
        jMenuItem13.setText("����ĳ�˼���Ի�(T)");
        jMenu5.setEnabled(false);
        jMenu5.setText("������Ƶ");
        jMenuItem14.setEnabled(false);
        jMenuItem14.setText("������Ƶ");
        jMenuItem15.setEnabled(false);
        jMenuItem15.setText("��������");
        jMenuItem16.setEnabled(false);
        jMenuItem16.setText("����Ӱ���ļ�");
        jMenuItem17.setEnabled(false);
        jMenuItem17.setText("��Ƶ����");
        jMenuItem18.setEnabled(false);
        jMenuItem18.setText("�����ļ�(F)");
        jMenuItem19.setEnabled(false);
        jMenuItem19.setText("�����ļ�(A)");
        jMenuItem20.setEnabled(false);
        jMenuItem20.setText("�����ֻ�����(M)");
        jMenuItem21.setEnabled(false);
        jMenuItem21.setText("����(C)");
        jMenuItem23.setEnabled(false);
        jMenuItem23.setText("Զ��Э��(H)");
        jMenuItem24.setEnabled(false);
        jMenuItem24.setText("Զ����ʾ�ĵ�(D)");
        jMenuItem25.setEnabled(false);
        jMenuItem25.setText("������������(G)");
        jMenuItem26.setEnabled(false);
        jMenuItem26.setText("���ô����ö�(T)");
        jMenuItem27.setEnabled(false);
        jMenuItem27.setText("�������Զ������(V)");
        jMenuItem28.setEnabled(false);
        jMenuItem28.setText("��ֹ����ϵ�˵���Ϣ(P)");
        jMenuItem29.setEnabled(false);
        jMenuItem29.setText("��Ϣģʽ(M)");
        jMenuItem30.setEnabled(false);
        jMenuItem30.setText("��̸ģʽ(C)");
        jMenu6.setText("���ٻظ�");
        jRadioButtonMenuItem1.setToolTipText("");
        jRadioButtonMenuItem1.setAction(null);
        jRadioButtonMenuItem1.setText("Hi~ ^_^");
        
        jRadioButtonMenuItem1.addMouseListener(new
                Face_jRadioButtonMenuItem1_mouseAdapter(this));
        
        jRadioButtonMenuItem2.setText("OK,û����!");
        ziti.setEnabled(false);
        ziti.setForeground(Color.blue);
        ziti.setToolTipText("��δ����");
        biaoqing.setEnabled(false);
        biaoqing.setForeground(Color.blue);
        biaoqing.setToolTipText("��δ����");
        tupian.setEnabled(false);
        tupian.setForeground(Color.blue);
        tupian.setToolTipText("��δ����");
        jieping.setEnabled(false);
        jieping.setForeground(Color.blue);
        jieping.setToolTipText("��δ����");
        kuaihui.setEnabled(false);
        kuaihui.setForeground(Color.blue);
        kuaihui.setToolTipText("��δ����");
        
        xieru.setText("Hi.");
        jilu.setText("<font color=gray face=\"Georgia, " +
        		"Times New Roman, Times, serif\">iQ 2008</font> ");
        jilu.setEditable(false);
        
        xieru.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyPressed(java.awt.event.KeyEvent e) {
				// ͬʱ���� atl+enter
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
        
        fasong.setText("����(CTRL+Enter)");
        guanbi.setText("�ر�");
        
        
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
    	String[] tips = {"����������ɫ�͸�ʽ", "ѡ�����", "����ħ������",
    			"���ʹ��ڶ���", "����ͼƬ", "ѡ�����ֳ���", "ѡ�������", "����",
    			"��׽��Ļ", "�����¼"};
    	
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
    	b[9].setText("�����¼");
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

    // ���Ͱ�ť
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
//        ��������Ķ���-���ٻظ�-��ѡ��ť�¼�
    }

    // ����
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
