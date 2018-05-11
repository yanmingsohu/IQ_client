package iq.assist;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 * 声音工厂
 */
public class SoundEffect {
	private SoundEffect() {}
	
	private static SE[] se = new SE[]{
			new SE("sound/call.wav", "电话"),
			new SE("sound/folder.wav", "切换"),
			new SE("sound/Global.wav", "上线"),
			new SE("sound/InputAlert.wav", "警告"),
			new SE("sound/msg.wav", "消息"),
			new SE("sound/ring.wav", "电话"),
			new SE("sound/security.wav", "钟声"),
			new SE("sound/system.wav", "咳嗽"),
			new SE("sound/up.wav", "气泡"),
			};
	
	/**
	 * 播放name指定的音效
	 * @param name - 可选的音效: 电话, 切换, 上线, 警告, 
	 * 消息, 电话, 钟声, 咳嗽, 气泡
	 */
	public static void playSE(String name) {
		for (int i=0; i<se.length; ++i) {
			if (se[i].equals(name)) {
				se[i].play();
			}
		}
	}
	
	public static Clip getClip(String s) throws Exception {
		AudioInputStream ais = AudioSystem.getAudioInputStream( new File(s) );
		if (ais==null) {
			throw new Exception("无效的音频文件: "+s);
		}
		Clip cl = AudioSystem.getClip();
		cl.open(ais);
		return cl;
	}
}

class SE {
	private Clip c;
	private String e;
	
	public SE(String file, String explain) {
		try {
			c = SoundEffect.getClip(file);
		} catch (Exception e) {
			Tools.pl(file+" "+explain);
			e.printStackTrace();
			c = null;
		}
		e = explain;
	}
	
	public void play() {
		if (c==null) return;
		c.setFramePosition(0);
		c.start();
	}
	
	// 特殊用法
	public boolean equals(Object o) {
		return e.equals(o.toString());
	}
	
	// 不符合习惯
	public String toString() {
		return e;
	}
}