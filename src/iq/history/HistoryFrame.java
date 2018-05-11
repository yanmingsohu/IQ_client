package iq.history;

import iq.assist.Tools;
import iq.event.UserEntity;

import java.awt.Dimension;
import java.io.*;

public class HistoryFrame extends javax.swing.JFrame {
    
    public HistoryFrame(UserEntity uid) {
        initComponents();
        String text = 
        	HistoryFactory.getHistory().getChatHisInfo(uid).read();
        jTextArea1.setText(text);
        
        this.setTitle("历史纪录");
        this.setSize(300,200);
        this.setMinimumSize(getSize());
        Tools.ComponentMoveCenter(this);
        this.setVisible(true);
    }
    
    private void initComponents() {
        jButton1 = new javax.swing.JButton();
        jToolBar1 = new javax.swing.JToolBar();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JEditorPane("text/html","");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jButton1.setForeground(new java.awt.Color(255, 0, 255));
        jButton1.setText("历史聊天纪录");
        getContentPane().add(jButton1, java.awt.BorderLayout.PAGE_START);

        jToolBar1.setRollover(true);

        jLabel1.setForeground(new java.awt.Color(0, 0, 255));
        jLabel1.setText("您的聊天纪录");

        jButton2.setText("关闭");
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton2);
        jToolBar1.addSeparator(new Dimension(5,10));
        jToolBar1.add(jLabel1);

        getContentPane().add(jToolBar1, java.awt.BorderLayout.PAGE_END);

//        jTextArea1.setColumns(20);
//        jTextArea1.setRows(8);
        jTextArea1.setEditable(false);
        jScrollPane1.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        pack();
    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {                                         

//         创建一个txt文本文档，将jTextAreal里的内容写进去
    }                                        

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        this.setVisible(false);
    }                                        

    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JEditorPane jTextArea1;
    private javax.swing.JToolBar jToolBar1;
    
}
