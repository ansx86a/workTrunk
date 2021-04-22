package http.原生httplib;

import http.https相關.實作MyX509TrustManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

public class HttpsClientUtils implements Serializable {

	private static final long serialVersionUID = 1L;

	public HttpsClientUtils(String urlString, Map parameters) {
		this.urlString = urlString;

		// 增加一個參數，指定是由API發出的請求
		parameters.put("source", "API");
		this.parameters = parameters;
	}

	public void sendRequest() throws Exception {
		// 組成URL字串
		StringBuffer urlParameters = new StringBuffer();
		if (parameters != null && !parameters.isEmpty()) {
			for (Iterator it = parameters.keySet().iterator(); it.hasNext();) {
				String name = it.next().toString();

				if (urlParameters.length() != 0) {
					urlParameters.append("&");
				}

				urlParameters.append(name).append("=").append(parameters.get(name).toString());

			}
		}

		// 建立SSLContext
		TrustManager[] tm = { new 實作MyX509TrustManager() };
		SSLContext sslContext = SSLContext.getInstance("SSL");
		sslContext.init(null, tm, new java.security.SecureRandom());

		// 取得SSLSocketFactory
		SSLSocketFactory ssf = sslContext.getSocketFactory();

		// 設置連線資訊
		URL myURL = new URL(urlString);
		HttpsURLConnection httpsConn = (HttpsURLConnection) myURL.openConnection();
		httpsConn.setSSLSocketFactory(ssf);
		httpsConn.setDoInput(true);
		httpsConn.setDoOutput(true);
		httpsConn.setUseCaches(false);
		httpsConn.setRequestMethod("POST");

		// 設置Content-Type
		httpsConn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

		// 走POST
		byte[] outputBytes = urlParameters.toString().getBytes("UTF-8");
		OutputStream os = httpsConn.getOutputStream();
		os.write(outputBytes);
		os.flush();
		os.close();

		// 開啟連線
		httpsConn.connect();

		// 設置HTTP Status-Code
		setHttpStatusCode(httpsConn.getResponseCode());

		if (HttpURLConnection.HTTP_OK == getHttpStatusCode()) {
			// 讀取訊息, httpsConn.getInputStream()時才發送請求出去
			BufferedReader br = null;
			StringBuffer sb = new StringBuffer();
			try {
				br = new BufferedReader(new InputStreamReader(httpsConn.getInputStream(), "UTF-8"));
				String readLine;
				while ((readLine = br.readLine()) != null) {
					sb.append(readLine);
				}
				// 設置訊息
				setResponseBody(sb.toString());

			} finally {
				try {
					if (br != null) {
						br.close();
					}
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			}
		}

		// 關閉連線
		httpsConn.disconnect();
	}

	private String urlString;
	private Map parameters;
	private int httpStatusCode;
	private String responseBody;

	public String getUrlString() {
		return urlString;
	}

	public void setUrlString(String urlString) {
		this.urlString = urlString;
	}

	public Map getParameters() {
		return parameters;
	}

	public void setParameters(Map parameters) {
		this.parameters = parameters;
	}

	public int getHttpStatusCode() {
		return httpStatusCode;
	}

	public void setHttpStatusCode(int httpStatusCode) {
		this.httpStatusCode = httpStatusCode;
	}

	public String getResponseBody() {
		return responseBody;
	}

	public void setResponseBody(String responseBody) {
		this.responseBody = responseBody;
	}

}
