// CatfoOD 2008-6-11 下午12:48:58

package iq.gui.other;

import iq.event.UserInfo;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

public class FriendTableModel extends DefaultTableModel {
	private String[] columns = {"iQ","昵称", "年龄", "性别", "城市"};
	private ArrayList<UserInfo> list = new ArrayList<UserInfo>();
	
	public FriendTableModel(String[] s) {
		for (int i=0; i<s.length; ++i) {
			if (s[i]!=null && s[i].length()>0) {
				list.add(new UserInfo(s[i]));
			}
		}
	}
	
	public Object getValueAt(int rowIndex, int columnIndex) {
		UserInfo u = list.get(rowIndex);
		switch(columnIndex) {
		case 0:
			return u.getID();
		case 1:
			return u.getName();
		case 2:
			return u.get("age");
		case 3:
			return u.get("sex");
		case 4:
			return u.get("city");
		default:
			return "";
		}
	}
	
	public int getColumnCount() {
		return columns.length;
	}
	
	public int getRowCount() {
		if (list==null) return 0;
		return list.size();
	}
	
	public boolean isCellEditable(int r, int c) {
		return false;
	}
	
	public String getColumnName(int columnIndex) {
		return columns[columnIndex];
	}
}
