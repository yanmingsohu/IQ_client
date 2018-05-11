package iq.test;

import iq.assist.CodexMaker;
import iq.assist.Tools;
import iq.net.MsgFactory;

import java.io.IOException;

public class testMessageAsk {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		for (int i=0; i<100; i++) {
			Tools.pl( affirmResponses (Tools.getCodes()+".$link") );
		}

	}

	private static String affirmResponses(String s) {
		int dot1 = s.indexOf('.');
		if (dot1>0) {
			String respon = s.substring(0, dot1);
			if (respon.startsWith(CodexMaker.RESPONSES)) {
				if ( respon.length()==Tools.getCodesLength() ) {
					//respon = respon.substring(CodexMaker.RESPONSES.length());
					//MsgFactory.getMsgSender().send("$ASK."+respon);
					Tools.pl("\t $ASK."+respon);
					return s.substring(dot1+1);
				}
			}
		}
		return s;
	}
}
