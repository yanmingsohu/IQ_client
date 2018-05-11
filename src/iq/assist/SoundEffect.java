package iq.assist;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 * ��������
 */
public class SoundEffect {
	private SoundEffect() {}
	
	private static SE[] se = new SE[]{
			new SE("sound/call.wav", "�绰"),
			new SE("sound/folder.wav", "�л�"),
			new SE("sound/Global.wav", "����"),
			new SE("sound/InputAlert.wav", "����"),
			new SE("sound/msg.wav", "��Ϣ"),
			new SE("sound/ring.wav", "�绰"),
			new SE("sound/security.wav", "����"),
			new SE("sound/system.wav", "����"),
			new SE("sound/up.wav", "����"),
			};
	
	/**
	 * ����nameָ������Ч
	 * @param name - ��ѡ����Ч: �绰, �л�, ����, ����, 
	 * ��Ϣ, �绰, ����, ����, ����
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
			throw new Exception("��Ч����Ƶ�ļ�: "+s);
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
	
	// �����÷�
	public boolean equals(Object o) {
		return e.equals(o.toString());
	}
	
	// ������ϰ��
	public String toString() {
		return e;
	}
}