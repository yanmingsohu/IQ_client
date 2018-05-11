package iq.test;

import java.net.InetAddress;
import java.net.UnknownHostException;

import iq.assist.Tools;

public class testdate {
	public final static void main(String[] s ){
		for (int i=0; i<100; ++i) {
			Tools.pl( Tools.getCodes()+"  "+Tools.getCodesLength() );
		}
	}
}
