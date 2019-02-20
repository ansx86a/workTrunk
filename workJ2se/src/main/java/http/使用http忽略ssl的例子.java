package http;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Arrays;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.http.HttpEntity;
import org.apache.http.client.config.AuthSchemes;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.poi.util.IOUtils;

/**
 * 
 * @author ai
 *
 */
public class 使用http忽略ssl的例子 {

	private static X509TrustManager xtm = new X509TrustManager() {

		@Override
		public void checkClientTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
			// TODO Auto-generated method stub

		}

		@Override
		public void checkServerTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
			// TODO Auto-generated method stub

		}

		@Override
		public X509Certificate[] getAcceptedIssuers() {

			return new X509Certificate[] {};
		}

	};

	/**
	 * 這個是要登入的，如果不用登入把header拿掉也許就成了
	 * @param url
	 * @throws Exception
	 */
	private static void executeHttp(String url) throws Exception {
		HttpGet request = new HttpGet(url);
		request.setHeader("Authorization", "Basic " + "要加uuid或是帳密加密後的base64？不確定");
		SSLContext context = SSLContext.getInstance("TLS");
		context.init(null, new TrustManager[] { xtm }, null);
		SSLConnectionSocketFactory scsf = new SSLConnectionSocketFactory(context, NoopHostnameVerifier.INSTANCE);
		RequestConfig defaultConfig = RequestConfig.custom().setCookieSpec(CookieSpecs.STANDARD_STRICT)
				.setExpectContinueEnabled(true)
				.setTargetPreferredAuthSchemes(Arrays.asList(AuthSchemes.NTLM, AuthSchemes.DIGEST))
				.setProxyPreferredAuthSchemes(Arrays.asList(AuthSchemes.BASIC)).build();

		Registry<ConnectionSocketFactory> sfr = RegistryBuilder.<ConnectionSocketFactory>create()
				.register("http", PlainConnectionSocketFactory.INSTANCE).register("https", scsf).build();
		PoolingHttpClientConnectionManager pcm = new PoolingHttpClientConnectionManager(sfr);

		try (CloseableHttpClient client = HttpClients.custom().setConnectionManager(pcm)
				.setDefaultRequestConfig(defaultConfig).build()) {
			CloseableHttpResponse response = client.execute(request);
			HttpEntity entity = response.getEntity();
			int responseCode = response.getStatusLine().getStatusCode();
			byte[] result = IOUtils.toByteArray(entity.getContent());

			// return result;
		}
	}

}
