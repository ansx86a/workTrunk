package http.原生httplib;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.commons.io.IOUtils;

/**
 * @Title: Restful.java
 * @Package Restful
 * @Description: TODO(用一句話描述該文件做什麼)
 * @author Ishadow
 * @date 2016年6月19日 上午1:15:43
 * @version V1.0
 */
public class Restful {
	public static void main(String[] args) throws Exception {
		HttpURLConnection conn = getConnection("https://172.17.26.61:8443/wsg/api/public/v6_0/session");

		Restful.setRequest(conn, "POST");
		// 自已加的，提內容
		aaa: {
			conn.setDoOutput(true);
			OutputStream output = conn.getOutputStream();
			String s = "{\"userName\":\"admin\",\"password\":\"admin!234\"}";
			output.write(s.getBytes("UTF-8"));
			output.flush();
			output.close();
		}
		Restful.getResponse(conn);

		conn = getConnection("https://172.17.26.61:8443/wsg/api/public/v6_0/rkszones");
		Restful.setRequest(conn, "GET");
		Restful.getResponse(conn);
	}

	static void setRequest(HttpURLConnection conn, String method) throws ProtocolException {
		conn.setRequestMethod(method);// POST GET PUT DELETE
		// 設置訪問提交模式，表單提交
		conn.setRequestProperty("Content-Type", "application/json;charset=utf-8");
		conn.setConnectTimeout(130000);// 連接超時 單位毫秒
		conn.setReadTimeout(130000);// 讀取超時 單位毫秒
	}

	static void getResponse(HttpURLConnection conn) throws IOException {
		// 讀取請求返回值
		String result = IOUtils.toString(conn.getInputStream(), "utf-8");
		System.out.println(result);
	}

	static HttpURLConnection getConnection(String requestUrl) throws Exception {
		HttpsURLConnection.setDefaultHostnameVerifier(new Restful().new NullHostNameVerifier());
		SSLContext sc = SSLContext.getInstance("TLS");
		sc.init(null, trustAllCerts, new SecureRandom());
		HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
		URL url = new URL(requestUrl);
		// 打開restful鏈接
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		return conn;
	}

	static TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {
		@Override
		public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
			// TODO Auto-generated method stub
		}

		@Override
		public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
			// TODO Auto-generated method stub
		}

		@Override
		public X509Certificate[] getAcceptedIssuers() {
			// TODO Auto-generated method stub
			return null;
		}
	} };

	public class NullHostNameVerifier implements HostnameVerifier {
		/*
		 * (non-Javadoc)
		 * 
		 * @see javax.net.ssl.HostnameVerifier#verify(java.lang.String,
		 * javax.net.ssl.SSLSession)
		 */
		@Override
		public boolean verify(String arg0, SSLSession arg1) {
			// TODO Auto-generated method stub
			return true;
		}
	}
}