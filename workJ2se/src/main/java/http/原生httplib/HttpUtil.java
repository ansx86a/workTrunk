package http.原生httplib;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

//這裡份還沒有要著墨，先用書凱的版本頂住

public class HttpUtil {

	public static String doGetRequest(String urlStr) throws IOException {
		return doGetRequest(urlStr, "UTF-8");
	}

	public static String doGetRequest(String urlStr, String encode) throws IOException {
		StringBuffer response = new StringBuffer();
		URL url = null;
		HttpURLConnection conn = null;
		try {
			url = new URL(urlStr);
			conn = (HttpURLConnection) url.openConnection();
			conn.setConnectTimeout(10000);
			conn.setReadTimeout(10000);
			conn.setDoInput(true);

			BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream(), encode));
			String line;
			while ((line = rd.readLine()) != null) {
				response.append(line);
			}
			rd.close();
			return response.toString();

		} finally {
			if (conn != null) {
				conn.disconnect();
			}
		}

	}

	public static String doPostRequest(String urlStr, String postData) throws IOException {
		return doPostRequest(urlStr, postData, "UTF-8");
	}

	public static String doPostRequest(String urlStr, String postData, String encode) throws IOException {
		StringBuffer response = new StringBuffer();
		URL url = null;
		HttpURLConnection conn = null;
		try {
			url = new URL(urlStr);
			conn = (HttpURLConnection) url.openConnection();
			conn.setConnectTimeout(10000);
			conn.setReadTimeout(10000);
			conn.setDoOutput(true);
			conn.setDoInput(true);
			OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
			wr.write(postData);
			wr.flush();
			wr.close();

			BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream(), encode));
			String line;
			while ((line = rd.readLine()) != null) {
				response.append(line);
			}
			rd.close();
			return response.toString();

		} finally {
			if (conn != null) {
				conn.disconnect();
			}
		}

	}

	public static String doSoapPostRequest(String urlStr, String postData) throws IOException {
		return doSoapPostRequest(urlStr, postData, "UTF-8");
	}

	public static String doSoapPostRequest(String urlStr, String postData, String encode) throws IOException {
		StringBuffer response = new StringBuffer();
		URL url = null;
		HttpURLConnection conn = null;
		try {
			url = new URL(urlStr);
			conn = (HttpURLConnection) url.openConnection();
			conn.setConnectTimeout(30000);
			conn.setReadTimeout(30000);
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setRequestProperty("Content-Type", "text/xml; charset=utf-8");
			conn.setRequestProperty("SOAPAction", "http://billhunter.com.tw/SendMail_Now");
			conn.setRequestProperty("Content-Length", "" + postData.getBytes().length);

			OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
			wr.write(postData);
			wr.flush();
			wr.close();

			BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream(), encode));
			String line;
			while ((line = rd.readLine()) != null) {
				response.append(line);
			}
			rd.close();
			return response.toString();

		} finally {
			if (conn != null) {
				conn.disconnect();
			}
		}

	}

	public static String doSoapSSLPostRequest(String urlStr, String postData) throws IOException {
		return doSoapSSLPostRequest(urlStr, postData, "UTF-8");
	}

	public static String doSoapSSLPostRequest(String urlStr, String postData, String encode) throws IOException {
		StringBuffer response = new StringBuffer();
		URL url = null;
		HttpsURLConnection conn = null;
		try {
			url = new URL(urlStr);
			conn = (HttpsURLConnection) url.openConnection();
			conn.setConnectTimeout(10000);
			conn.setReadTimeout(10000);
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setRequestProperty("Content-Type", "text/xml; charset=utf-8");
			conn.setRequestProperty("SOAPAction", "http://billhunter.com.tw/SendMail_Now");
			conn.setRequestProperty("Content-Length", "" + postData.getBytes().length);

			OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
			wr.write(postData);
			wr.flush();
			wr.close();

			BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream(), encode));
			String line;
			while ((line = rd.readLine()) != null) {
				response.append(line);
			}
			rd.close();
			return response.toString();

		} finally {
			if (conn != null) {
				conn.disconnect();
			}
		}
	}
}
