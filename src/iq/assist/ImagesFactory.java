package iq.assist;

import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class ImagesFactory {
	private ImagesFactory(){}
	
	public static final String logo = "images/mainpsd.psd";
	public static final String icon1 = "images/p32a.jpg";
	public static final String icon2 = "images/p32b.jpg";
	public static final String inull = "images/null.png";
	
	public static final Image LOGO;
	public static final Image ICON1;
	public static final Image ICON2;
	public static final Image INULL;
	
	static {
		LOGO = creatImage(logo);
		ICON1 = creatImage(icon1);
		ICON2 = creatImage(icon2);
		INULL = creatImage(inull);
	}
	
	/**
	 * 建立图片
	 * @param path - 文件路径
	 */
	public static Image creatImage(String path) {
		return Toolkit.getDefaultToolkit().createImage( path );
	}
	
	/**
	 * 建立图标
	 * @param path - 文件路径
	 */
	public static ImageIcon creatIcon(String path) {
		return new ImageIcon(path);
	}
}
