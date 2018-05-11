package iq.net;

import java.net.InetAddress;

public class UdpPackage {
	private String msg;
	private InetAddress remote;
	private int remoteport;
	
	public UdpPackage(String msg, InetAddress ip, int port) {
		this.msg = msg;
		remote = ip;
		remoteport = port;
	}

//	public UdpPackage(String msg, ConnectInfo remoteinfo) {
//		this.msg = msg;
//		remote = remoteinfo.ip;
//		remoteport = remoteinfo.msgPort;
//	}
	
	public String getMsg() {
		return msg;
	}
	
	public InetAddress getRemoteIP() {
		return remote;
	}
	
	public int getPort() {
		return remoteport;
	}
}
