package tool;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class IpUtils {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * 參考網路的範例
	 * @param request
	 * @return
	 */
	public String getIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}

	/**
	 * 參考中信的撰寫而成
	 * @param request
	 * @return
	 */
	public String doDisplayRemoteData(HttpServletRequest request) {
		// 取得使用者的相關資訊
		String remoteAddr = getIpAddr(request);
		String remoteHost = remoteAddr;
		// String remoteURL = ((HttpServletRequest)request).getHeader("referer");
		String remoteURL = ((HttpServletRequest) request).getRequestURI();
		// String remoteUserAgent = ((HttpServletRequest)request).getHeader("user-agent");
		String aUserData = remoteHost + "," + remoteAddr + "," + remoteURL + ",Parameters=>"
				+ request.getParameterMap();
		return aUserData;
	}

}
