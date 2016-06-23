package http;

import java.security.KeyStore;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

/**
 * 
 * @author ai
 *
 */
public class 實作MyX509TrustManager implements X509TrustManager {

	private X509TrustManager standardTrustManager;

	/**
	 * 感覺是拿到tomcat上的keystore和密碼後，實作X509TrustManager<br>
	 * 不太懂這邊為什麼只checkClent，意思是這是server的程式，然後要驗証client有沒有用ok的keystore嗎？
	 * @throws Exception
	 */
	public 實作MyX509TrustManager() throws Exception {
		KeyStore keyStore = KeyStore.getInstance("JKS");
		keyStore.load(getClass().getClassLoader().getResourceAsStream("key.keystore"), "12345678".toCharArray());

		TrustManagerFactory tmf = TrustManagerFactory.getInstance("SunX509", "SunJSSE");
		tmf.init(keyStore);
		TrustManager[] tms = tmf.getTrustManagers();

		for (int i = 0; i < tms.length; i++) {
			if (tms[i] instanceof X509TrustManager) {
				standardTrustManager = (X509TrustManager) tms[i];
			}
		}
	}

	public void checkClientTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
		standardTrustManager.checkClientTrusted(arg0, arg1);
	}

	public void checkServerTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
		// standardTrustManager.checkServerTrusted(arg0, arg1);
	}

	public X509Certificate[] getAcceptedIssuers() {
		return standardTrustManager.getAcceptedIssuers();
	}
}
