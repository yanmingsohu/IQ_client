// CatfoOD 2008-6-9 ионГ10:12:29

package iq.history;

import iq.event.FriendList;

import java.io.File;

public class HistoryFactory {
	private HistoryFactory() {}
	
	public static ChatHistory getHistory() {
		if (his==null) {
			his = new ChatHistory(FriendList.getMainUser().getID());
		}
		return his;
	}
		
	private static ChatHistory his = null;
}
