package http;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class 取得IP相關 {

	public static void main(String[] args) throws Exception {
		取得IP相關 ip = new 取得IP相關();
		ip.$1取得本地主機ip();
		ip.$2取得網卡列表();

	}

	public void $1取得本地主機ip() throws Exception {
		System.out.println(Inet4Address.getLocalHost().getHostAddress());
	}

	public void $2取得網卡列表() throws SocketException {
		System.out.println("$2取得網卡列表============");
		Enumeration e = NetworkInterface.getNetworkInterfaces();
		while (e.hasMoreElements()) {
			NetworkInterface n = (NetworkInterface) e.nextElement();
			Enumeration ee = n.getInetAddresses();
			while (ee.hasMoreElements()) {
				InetAddress i = (InetAddress) ee.nextElement();
				System.out.println(i.getHostAddress());
			}
		}
	}
	
	

}
