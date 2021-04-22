package http.https相關;

import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.X509TrustManager;

public class NewX509TrustManager implements X509TrustManager {

	/**
	 * Constructor for NewX509TrustManager.
	 */
	public NewX509TrustManager(KeyStore keystore) throws NoSuchAlgorithmException, KeyStoreException {
		super();

	}

	/**
	 * @see javax.net.ssl.X509TrustManager#checkClientTrusted(X509Certificate[], String authType)
	 */
	public void checkClientTrusted(X509Certificate[] certificates, String authType) throws CertificateException {

	}

	/**
	 * @see javax.net.ssl.X509TrustManager#checkServerTrusted(X509Certificate[], String authType)
	 */
	public void checkServerTrusted(X509Certificate[] certificates, String authType) throws CertificateException {

	}

	/**
	 * @see javax.net.ssl.X509TrustManager#getAcceptedIssuers()
	 */
	public X509Certificate[] getAcceptedIssuers() {
		return null;
	}

	public NewX509TrustManager() {
		super();
	}

	public boolean isClientTrusted(X509Certificate[] certificates) {
		return true;
	}

	public boolean isServerTrusted(X509Certificate[] certificates) {
		return true;
	}
}