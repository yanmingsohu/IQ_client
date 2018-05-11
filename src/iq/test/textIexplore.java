// CatfoOD 2008-6-14 ионГ08:22:17

package iq.test;

import iq.assist.Tools;

import java.io.IOException;

public class textIexplore {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			String path = System.getProperty("user.dir");
			Tools.pl(path);
			Runtime.getRuntime().exec(
					"cmd /c start iexplore.exe file://"+path+"/skin/index.html");
		} catch (IOException e1) {
			Tools.error(e1);
		}
	}

}
