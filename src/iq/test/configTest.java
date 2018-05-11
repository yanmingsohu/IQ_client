package iq.test;

import iq.assist.Tools;

public class configTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Tools.pl( Tools.getServerAddress() );
		Tools.pl( Tools.getServerPort());
	}

}
