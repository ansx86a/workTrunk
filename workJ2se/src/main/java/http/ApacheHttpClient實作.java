package http;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.Socket;
import java.net.URI;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.net.ssl.SSLContext;

import net.sf.json.JSONObject;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.AuthCache;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CookieStore;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.cookie.ClientCookie;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.impl.auth.DigestScheme;
import org.apache.http.impl.client.BasicAuthCache;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.client.ProxyClient;
import org.apache.http.impl.client.WinHttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HTTP;
import org.apache.http.protocol.HttpContext;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.util.EntityUtils;

import tool.Utils;

public class ApacheHttpClient實作 {

	/**
	 * 參照 http://httpbin.org 可以做測試，如post、ip之類的
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {

		ApacheHttpClient實作 p = new ApacheHttpClient實作();
		// 感覺下面的apache範例有點太難，由21開始自已做一下範例來用
		// p.$21最簡單的get加參數();
		// p.$22最簡單的post未測試();
		// p.$23檔案上傳未測試();
		// p.$24最簡單的post();
		// p.$25捉圖();
		p.$26Cookies測試成功了嗎();
		p.$27();
		p.$28();
		p.$29();
		p.$30();

		// 感覺都沒什麼屁用，就1、2、7比較有用

		// p.$1最簡單的get使用HandleResponse();
		// p.$2最簡單的get使用Stream讀取內容();
		// p.$3中斷http();
		// p.$4基本的份驗証();
		// p.$5proxy轉發();//有proxy再測試
		// p.$6proxy認証加轉發();//有proxy再測
		// p.$7把一個內文post到server上();
		// p.$8取得cookie的用法();// 又不是browser，coookie好像沒有屁用
		// p.$9Base認証();//不知道和$4差在那裡，因為不能跑，留下來參考即可
		// p.$10多執行緒的httpClient();// 好像是用特別的方法來init HttpClient，好像也沒有特別好用的樣子
		// p.$11SSL連線();
		// p.$12又是BASIC認證();
		// p.$13Digest認證();//失敗

		// p.$14又是不能測的proxy();
		// p.$15檔案上傳的範例();//要寫serverlet，還是不能測
		// p.$16使用WinHttpClient創建Client();//意義不明，這樣會比較好用嗎
		p.$17();
		p.$18();
		p.$19();
		p.$20();

	}

	public void $1最簡單的get使用HandleResponse() throws Exception {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		try {
			HttpGet httpget = new HttpGet("http://www.pchome.com.tw/");

			System.out.println("Executing request " + httpget.getRequestLine());
			// Create a custom response handler
			ResponseHandler<String> responseHandler = new ResponseHandler<String>() {
				@Override
				public String handleResponse(final HttpResponse response) throws ClientProtocolException, IOException {
					int status = response.getStatusLine().getStatusCode();
					if (status >= 200 && status < 300) {
						HttpEntity entity = response.getEntity();
						return entity != null ? EntityUtils.toString(entity, "utf8") : null;
					} else {
						throw new ClientProtocolException("Unexpected response status: " + status);
					}
				}
			};
			String responseBody = httpclient.execute(httpget, responseHandler);
			System.out.println("----------------------------------------");
			System.out.println(responseBody);
		} finally {
			httpclient.close();
		}
	}

	public void $2最簡單的get使用Stream讀取內容() throws Exception {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		try {
			HttpGet httpget = new HttpGet("http://httpbin.org/get");

			System.out.println("Executing request " + httpget.getRequestLine());
			CloseableHttpResponse response = httpclient.execute(httpget);
			try {
				System.out.println("----------------------------------------");
				System.out.println(response.getStatusLine());

				// Get hold of the response entity
				HttpEntity entity = response.getEntity();

				// If the response does not enclose an entity, there is no need
				// to bother about connection release
				if (entity != null) {
					InputStream instream = entity.getContent();
					ByteArrayOutputStream bo = new ByteArrayOutputStream();
					IOUtils.copy(instream, bo);
					System.out.println("read result");
					System.out.println(new String(bo.toByteArray()));
					// 應該用下列的才是正確的
					// EntityUtils.toString(response.getEntity()

					try {
						instream.read();
						// do something useful with the response
					} catch (IOException ex) {
						// In case of an IOException the connection will be released
						// back to the connection manager automatically
						throw ex;
					} finally {
						// Closing the input stream will trigger connection release
						instream.close();
					}
				}
			} finally {
				response.close();
			}
		} finally {
			httpclient.close();
		}
	}

	// 不太清楚這裡的abort在幹嘛，可能出錯時直接中斷可以減少一些頻寬嗎？
	public void $3中斷http() throws IOException {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		try {
			HttpGet httpget = new HttpGet("http://httpbin.org/get");
			System.out.println("Executing request " + httpget.getURI());
			CloseableHttpResponse response = httpclient.execute(httpget);
			try {
				System.out.println("----------------------------------------");
				System.out.println(response.getStatusLine());
				// Do not feel like reading the response body
				// Call abort on the request object
				httpget.abort();
				System.out.println("xxx");
			} finally {
				response.close();
			}
		} finally {
			httpclient.close();
		}
	}

	public void $4基本的份驗証() throws Exception {
		CredentialsProvider credsProvider = new BasicCredentialsProvider();
		credsProvider.setCredentials(new AuthScope("httpbin.org", 80),
				new UsernamePasswordCredentials("user", "passwd"));
		CloseableHttpClient httpclient = HttpClients.custom().setDefaultCredentialsProvider(credsProvider).build();
		try {
			HttpGet httpget = new HttpGet("http://httpbin.org/basic-auth/user/passwd");
			System.out.println("Executing request " + httpget.getRequestLine());
			CloseableHttpResponse response = httpclient.execute(httpget);
			try {
				System.out.println("----------------------------------------");
				System.out.println(response.getStatusLine());
				System.out.println(EntityUtils.toString(response.getEntity()));
			} finally {
				response.close();
			}
		} finally {
			httpclient.close();
		}
	}

	// 因為我不會架proxy，所以不知道怎麼測，都會回400
	public void $5proxy轉發() throws Exception {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		try {
			HttpHost target = new HttpHost("httpbin.org", 443, "https");
			HttpHost proxy = new HttpHost("127.0.0.1", 8080, "http");

			RequestConfig config = RequestConfig.custom().setProxy(proxy).build();
			HttpGet request = new HttpGet("/");
			request.setConfig(config);

			System.out.println("Executing request " + request.getRequestLine() + " to " + target + " via " + proxy);

			CloseableHttpResponse response = httpclient.execute(target, request);
			try {
				System.out.println("----------------------------------------");
				System.out.println(response.getStatusLine());
				System.out.println(EntityUtils.toString(response.getEntity()));
				System.out.println("----------------------------------------");
			} finally {
				response.close();
			}
		} finally {
			httpclient.close();
		}
	}

	public void $6proxy認証加轉發() throws Exception {
		CredentialsProvider credsProvider = new BasicCredentialsProvider();
		credsProvider.setCredentials(new AuthScope("localhost", 8888),
				new UsernamePasswordCredentials("squid", "squid"));
		credsProvider.setCredentials(new AuthScope("httpbin.org", 80),
				new UsernamePasswordCredentials("user", "passwd"));
		CloseableHttpClient httpclient = HttpClients.custom().setDefaultCredentialsProvider(credsProvider).build();
		try {
			HttpHost target = new HttpHost("httpbin.org", 80, "http");
			HttpHost proxy = new HttpHost("localhost", 8888);

			RequestConfig config = RequestConfig.custom().setProxy(proxy).build();
			HttpGet httpget = new HttpGet("/basic-auth/user/passwd");
			httpget.setConfig(config);

			System.out.println("Executing request " + httpget.getRequestLine() + " to " + target + " via " + proxy);

			CloseableHttpResponse response = httpclient.execute(target, httpget);
			try {
				System.out.println("----------------------------------------");
				System.out.println(response.getStatusLine());
				System.out.println(EntityUtils.toString(response.getEntity()));
			} finally {
				response.close();
			}
		} finally {
			httpclient.close();
		}
	}

	// 這裡的應用是post一個檔案還是本身的內文呢？，搞不清楚
	public void $7把一個內文post到server上() throws Exception {
		CloseableHttpClient httpclient = HttpClients.createDefault();

		try {
			HttpPost httppost = new HttpPost("http://httpbin.org/post");

			File file = Utils.getResourceFromRoot("http/file.txt");

			InputStreamEntity reqEntity = new InputStreamEntity(new FileInputStream(file), -1,
					ContentType.APPLICATION_OCTET_STREAM);
			reqEntity.setChunked(true);
			// It may be more appropriate to use FileEntity class in this particular
			// instance but we are using a more generic InputStreamEntity to demonstrate
			// the capability to stream out data from any arbitrary source
			//
			// FileEntity entity = new FileEntity(file, "binary/octet-stream");

			httppost.setEntity(reqEntity);

			System.out.println("Executing request: " + httppost.getRequestLine());
			CloseableHttpResponse response = httpclient.execute(httppost);
			try {
				System.out.println("----------------------------------------");
				System.out.println(response.getStatusLine());
				System.out.println(EntityUtils.toString(response.getEntity()));
			} finally {
				response.close();
			}
		} finally {
			httpclient.close();
		}
	}

	public void $8取得cookie的用法() throws IOException {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		try {
			// Create a local instance of cookie store
			CookieStore cookieStore = new BasicCookieStore();

			// Create local HTTP context
			HttpClientContext localContext = HttpClientContext.create();
			// Bind custom cookie store to the local context
			localContext.setCookieStore(cookieStore);

			HttpGet httpget = new HttpGet("http://httpbin.org/cookies");
			System.out.println("Executing request " + httpget.getRequestLine());

			// Pass local context as a parameter
			CloseableHttpResponse response = httpclient.execute(httpget, localContext);
			try {
				System.out.println("----------------------------------------");
				System.out.println(response.getStatusLine());
				List<Cookie> cookies = cookieStore.getCookies();
				for (int i = 0; i < cookies.size(); i++) {
					System.out.println("Local cookie: " + cookies.get(i));
				}
				System.out.println(EntityUtils.toString(response.getEntity()));
				EntityUtils.consume(response.getEntity());
			} finally {
				response.close();
			}
		} finally {
			httpclient.close();
		}
	}

	// 參考用
	public void $9Base認証() throws Exception {
		BasicCookieStore cookieStore = new BasicCookieStore();
		CloseableHttpClient httpclient = HttpClients.custom().setDefaultCookieStore(cookieStore).build();
		try {
			HttpGet httpget = new HttpGet("https://someportal/");
			CloseableHttpResponse response1 = httpclient.execute(httpget);
			try {
				HttpEntity entity = response1.getEntity();

				System.out.println("Login form get: " + response1.getStatusLine());
				EntityUtils.consume(entity);

				System.out.println("Initial set of cookies:");
				List<Cookie> cookies = cookieStore.getCookies();
				if (cookies.isEmpty()) {
					System.out.println("None");
				} else {
					for (int i = 0; i < cookies.size(); i++) {
						System.out.println("- " + cookies.get(i).toString());
					}
				}
			} finally {
				response1.close();
			}

			HttpUriRequest login = RequestBuilder.post().setUri(new URI("https://someportal/"))
					.addParameter("IDToken1", "username").addParameter("IDToken2", "password").build();
			CloseableHttpResponse response2 = httpclient.execute(login);
			try {
				HttpEntity entity = response2.getEntity();

				System.out.println("Login form get: " + response2.getStatusLine());
				EntityUtils.consume(entity);

				System.out.println("Post logon cookies:");
				List<Cookie> cookies = cookieStore.getCookies();
				if (cookies.isEmpty()) {
					System.out.println("None");
				} else {
					for (int i = 0; i < cookies.size(); i++) {
						System.out.println("- " + cookies.get(i).toString());
					}
				}
			} finally {
				response2.close();
			}
		} finally {
			httpclient.close();
		}
	}

	public void $10多執行緒的httpClient() throws Exception {
		PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();
		cm.setMaxTotal(100);

		CloseableHttpClient httpclient = HttpClients.custom().setConnectionManager(cm).build();
		try {
			// create an array of URIs to perform GETs on
			String[] urisToGet = { "http://hc.apache.org/", "http://hc.apache.org/httpcomponents-core-ga/",
					"http://hc.apache.org/httpcomponents-client-ga/", };

			// create a thread for each URI
			GetThread[] threads = new GetThread[urisToGet.length];
			for (int i = 0; i < threads.length; i++) {
				HttpGet httpget = new HttpGet(urisToGet[i]);
				threads[i] = new GetThread(httpclient, httpget, i + 1);
			}

			// start the threads
			for (int j = 0; j < threads.length; j++) {
				threads[j].start();
			}

			// join the threads
			for (int j = 0; j < threads.length; j++) {
				threads[j].join();
			}

		} finally {
			httpclient.close();
		}
	}

	static class GetThread extends Thread {

		private final CloseableHttpClient httpClient;
		private final HttpContext context;
		private final HttpGet httpget;
		private final int id;

		public GetThread(CloseableHttpClient httpClient, HttpGet httpget, int id) {
			this.httpClient = httpClient;
			this.context = new BasicHttpContext();
			this.httpget = httpget;
			this.id = id;
		}

		/**
		 * Executes the GetMethod and prints some status information.
		 */
		@Override
		public void run() {
			try {
				System.out.println(id + " - about to get something from " + httpget.getURI());
				CloseableHttpResponse response = httpClient.execute(httpget, context);
				try {
					System.out.println(id + " - get executed");
					// get the response body as an array of bytes
					HttpEntity entity = response.getEntity();
					if (entity != null) {
						byte[] bytes = EntityUtils.toByteArray(entity);
						System.out.println(id + " - " + bytes.length + " bytes read");
					}
				} finally {
					response.close();
				}
			} catch (Exception e) {
				System.out.println(id + " - error: " + e);
			}
		}

	}

	public void $11SSL連線() throws Exception {
		// Trust own CA and all self-signed certs
		// 讀憑証吧
		SSLContext sslcontext = SSLContexts.custom()
				.loadTrustMaterial(new File("my.keystore"), "nopassword".toCharArray(), new TrustSelfSignedStrategy())
				.build();
		// Allow TLSv1 protocol only
		SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslcontext, new String[] { "TLSv1" }, null,
				SSLConnectionSocketFactory.getDefaultHostnameVerifier());
		CloseableHttpClient httpclient = HttpClients.custom().setSSLSocketFactory(sslsf).build();
		try {
			HttpGet httpget = new HttpGet("https://httpbin.org/");
			System.out.println("Executing request " + httpget.getRequestLine());
			CloseableHttpResponse response = httpclient.execute(httpget);
			try {
				HttpEntity entity = response.getEntity();

				System.out.println("----------------------------------------");
				System.out.println(response.getStatusLine());
				EntityUtils.consume(entity);
			} finally {
				response.close();
			}
		} finally {
			httpclient.close();
		}
	}

	public void $12又是BASIC認證() throws ClientProtocolException, IOException {
		HttpHost target = new HttpHost("httpbin.org", 80, "http");
		CredentialsProvider credsProvider = new BasicCredentialsProvider();
		credsProvider.setCredentials(new AuthScope(target.getHostName(), target.getPort()),
				new UsernamePasswordCredentials("user", "passwd"));
		CloseableHttpClient httpclient = HttpClients.custom().setDefaultCredentialsProvider(credsProvider).build();
		try {

			// Create AuthCache instance
			AuthCache authCache = new BasicAuthCache();
			// Generate BASIC scheme object and add it to the local
			// auth cache
			BasicScheme basicAuth = new BasicScheme();
			authCache.put(target, basicAuth);

			// Add AuthCache to the execution context
			HttpClientContext localContext = HttpClientContext.create();
			localContext.setAuthCache(authCache);

			HttpGet httpget = new HttpGet("http://httpbin.org/hidden-basic-auth/user/passwd");

			System.out.println("Executing request " + httpget.getRequestLine() + " to target " + target);
			for (int i = 0; i < 3; i++) {
				CloseableHttpResponse response = httpclient.execute(target, httpget, localContext);
				try {
					System.out.println("----------------------------------------");
					System.out.println(response.getStatusLine());
					System.out.println(EntityUtils.toString(response.getEntity()));
				} finally {
					response.close();
				}
			}
		} finally {
			httpclient.close();
		}

	}

	public void $13Digest認證() throws IOException {
		HttpHost target = new HttpHost("httpbin.org", 80, "http");
		CredentialsProvider credsProvider = new BasicCredentialsProvider();
		credsProvider.setCredentials(new AuthScope(target.getHostName(), target.getPort()),
				new UsernamePasswordCredentials("user", "passwd"));
		CloseableHttpClient httpclient = HttpClients.custom().setDefaultCredentialsProvider(credsProvider).build();
		try {

			// Create AuthCache instance
			AuthCache authCache = new BasicAuthCache();
			// Generate DIGEST scheme object, initialize it and add it to the local
			// auth cache
			DigestScheme digestAuth = new DigestScheme();
			// Suppose we already know the realm name
			digestAuth.overrideParamter("realm", "some realm");
			// Suppose we already know the expected nonce value
			digestAuth.overrideParamter("nonce", "whatever");
			authCache.put(target, digestAuth);

			// Add AuthCache to the execution context
			HttpClientContext localContext = HttpClientContext.create();
			localContext.setAuthCache(authCache);

			HttpGet httpget = new HttpGet("http://httpbin.org/digest-auth/auth/user/passwd");

			System.out.println("Executing request " + httpget.getRequestLine() + " to target " + target);
			for (int i = 0; i < 3; i++) {
				CloseableHttpResponse response = httpclient.execute(target, httpget, localContext);
				try {
					System.out.println("----------------------------------------");
					System.out.println(response.getStatusLine());
					System.out.println(EntityUtils.toString(response.getEntity()));
				} finally {
					response.close();
				}
			}
		} finally {
			httpclient.close();
		}
	}

	public void $14又是不能測的proxy() throws Exception {
		ProxyClient proxyClient = new ProxyClient();
		HttpHost target = new HttpHost("www.yahoo.com", 80);
		HttpHost proxy = new HttpHost("localhost", 8888);
		UsernamePasswordCredentials credentials = new UsernamePasswordCredentials("user", "pwd");
		Socket socket = proxyClient.tunnel(proxy, target, credentials);
		try {
			Writer out = new OutputStreamWriter(socket.getOutputStream(), HTTP.DEF_CONTENT_CHARSET);
			out.write("GET / HTTP/1.1\r\n");
			out.write("Host: " + target.toHostString() + "\r\n");
			out.write("Agent: whatever\r\n");
			out.write("Connection: close\r\n");
			out.write("\r\n");
			out.flush();
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream(),
					HTTP.DEF_CONTENT_CHARSET));
			String line = null;
			while ((line = in.readLine()) != null) {
				System.out.println(line);
			}
		} finally {
			socket.close();
		}
	}

	public void $15檔案上傳的範例() throws Exception {
		File f = Utils.getResourceFromRoot("http/file.txt");

		CloseableHttpClient httpclient = HttpClients.createDefault();
		try {
			HttpPost httppost = new HttpPost("http://localhost:8080" + "/servlets-examples/servlet/RequestInfoExample");

			FileBody bin = new FileBody(f);
			StringBody comment = new StringBody("A binary file of some kind", ContentType.TEXT_PLAIN);

			HttpEntity reqEntity = MultipartEntityBuilder.create().addPart("bin", bin).addPart("comment", comment)
					.build();

			httppost.setEntity(reqEntity);

			System.out.println("executing request " + httppost.getRequestLine());
			CloseableHttpResponse response = httpclient.execute(httppost);
			try {
				System.out.println("----------------------------------------");
				System.out.println(response.getStatusLine());
				HttpEntity resEntity = response.getEntity();
				if (resEntity != null) {
					System.out.println("Response content length: " + resEntity.getContentLength());
				}
				EntityUtils.consume(resEntity);
			} finally {
				response.close();
			}
		} finally {
			httpclient.close();
		}
	}

	public void $16使用WinHttpClient創建Client() throws Exception {
		if (!WinHttpClients.isWinAuthAvailable()) {
			System.out.println("Integrated Win auth is not supported!!!");
		}

		CloseableHttpClient httpclient = WinHttpClients.createDefault();
		// There is no need to provide user credentials
		// HttpClient will attempt to access current user security context through
		// Windows platform specific methods via JNI.
		try {
			HttpGet httpget = new HttpGet("http://www.kimo.com/");

			System.out.println("Executing request " + httpget.getRequestLine());
			CloseableHttpResponse response = httpclient.execute(httpget);
			try {
				System.out.println("----------------------------------------");
				System.out.println(response.getStatusLine());
				System.out.println(EntityUtils.toString(response.getEntity()));
				EntityUtils.consume(response.getEntity());
			} finally {
				response.close();
			}
		} finally {
			httpclient.close();
		}
	}

	public void $17() {
	}

	public void $18() {
	}

	public void $19() {
	}

	public void $20() {
	}

	public void $21最簡單的get加參數() throws Exception {
		URI uri = new URIBuilder().setScheme("https").setHost("zh.wikipedia.org").setPath("/wiki/鋼彈")
				.setParameter("p", "just").setParameter("fr2", "dict").build();
		HttpGet httpget = new HttpGet(uri);

		System.out.println(httpget.getURI());
		CloseableHttpClient httpclient = HttpClients.createDefault();
		// 設定config，例如timeout的時間，1000是1秒的意思吧
		RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(1000).setConnectTimeout(1000).build();
		httpget.setConfig(requestConfig);

		CloseableHttpResponse response = httpclient.execute(httpget);
		try {
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				System.out.println(EntityUtils.toString(entity, "utf8"));
				// InputStream instream = entity.getContent();
				// try {
				// // do something useful
				// } finally {
				// instream.close();
				// }
			}
			EntityUtils.consume(entity);
		} finally {
			response.close();
			httpclient.close();
		}
	}

	public void $22最簡單的post未測試() throws Exception {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost("http://targethost/login");
		List<NameValuePair> nvps = new ArrayList<NameValuePair>();
		nvps.add(new BasicNameValuePair("username", "vip"));
		nvps.add(new BasicNameValuePair("password", "secret"));
		httpPost.setEntity(new UrlEncodedFormEntity(nvps));
		CloseableHttpResponse response2 = httpclient.execute(httpPost);

		try {
			System.out.println(response2.getStatusLine());
			HttpEntity entity2 = response2.getEntity();
			// do something useful with the response body
			// and ensure it is fully consumed
			EntityUtils.consume(entity2);
		} finally {
			response2.close();
		}
	}

	public void $23檔案上傳未測試() throws Exception {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		try {
			File file = Utils.getResourceFromRoot("http/file.txt");
			HttpPost post = new HttpPost("http://httpbin.org/post");
			FileBody fileBody = new FileBody(file, ContentType.DEFAULT_BINARY);
			StringBody stringBody1 = new StringBody("Message 1", ContentType.MULTIPART_FORM_DATA);
			StringBody stringBody2 = new StringBody("Message 2", ContentType.MULTIPART_FORM_DATA);
			//
			MultipartEntityBuilder builder = MultipartEntityBuilder.create();
			builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
			builder.addPart("upfile1", fileBody);
			builder.addPart("upfile2", fileBody);
			builder.addPart("text1", stringBody1);
			builder.addPart("text2", stringBody2);
			HttpEntity entity = builder.build();
			//
			post.setEntity(entity);
			CloseableHttpResponse response = httpclient.execute(post);
			System.out.println("POST Response Status:: " + response.getStatusLine());
			if (response.getEntity() != null) {
				String s = EntityUtils.toString(response.getEntity());
				System.out.println(s);
			}
			EntityUtils.consume(response.getEntity());

		} finally {
			httpclient.close();
		}
	}

	public void $24最簡單的post() throws Exception {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		// 以下要改成 org.apache.http.client.config.RequestConfi
		// httpclient.getParams().setParameter("http.protocol.content-charset", "UTF-8");

		HttpPost post = new HttpPost("http://httpbin.org/post");
		String USER_AGENT = "Mozilla/5.0";
		post.addHeader("User-Agent", USER_AGENT);
		List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
		urlParameters.add(new BasicNameValuePair("userName", "Pankaj Kumar"));
		HttpEntity postParams = new UrlEncodedFormEntity(urlParameters);
		post.setEntity(postParams);

		CloseableHttpResponse response = httpclient.execute(post);
		System.out.println("POST Response Status:: " + response.getStatusLine());
		if (response.getEntity() != null) {
			String s = EntityUtils.toString(response.getEntity());
			System.out.println(s);
		}
		EntityUtils.consume(response.getEntity());

		System.out.println("response=" + response.toString());
		httpclient.close();

	}

	public void $25捉圖() throws Exception {
		HttpGet httpget = new HttpGet("http://i2.bahamut.com.tw/baha_logo5.png");
		System.out.println(httpget.getURI());
		CloseableHttpClient httpclient = HttpClients.createDefault();
		// 設定config，例如timeout的時間，1000是1秒的意思吧
		RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(1000).setConnectTimeout(1000).build();
		httpget.setConfig(requestConfig);

		CloseableHttpResponse response = httpclient.execute(httpget);
		try {
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				System.out.println(entity.getContentType().getValue());
				FileUtils.writeByteArrayToFile(new File("z:/ppp.png"), EntityUtils.toByteArray(entity));
			}
			EntityUtils.consume(entity);
		} finally {
			response.close();
			httpclient.close();
		}

	}

	// 先把一些看起來比較沒關系的註解掉，不行再打開回來，配合chrome的editthisCookie把cookie匯出成json再匯進去
	public void $26Cookies測試成功了嗎() throws ClientProtocolException, IOException {

		// Use custom cookie store if necessary.
		CookieStore cookieStore = new BasicCookieStore();
		setCookies(cookieStore);

		HttpGet httpget = new HttpGet("https://mg.mail.yahoo.com/neo/launch?.rand=am9jg399ocvpj");
		// 設定config，例如timeout的時間，1000是1秒的意思吧
		RequestConfig requestConfig = RequestConfig.custom().setCookieSpec(CookieSpecs.DEFAULT).setSocketTimeout(1000)
				.setConnectTimeout(1000).build();
		httpget.setConfig(requestConfig);
		// HttpClientContext context = HttpClientContext.create();
		// context.setCookieStore(cookieStore);

		// RequestConfig localConfig = RequestConfig.copy(requestConfig).setCookieSpec(CookieSpecs.STANDARD_STRICT)
		// .build();
		// httpget.setConfig(localConfig);

		CloseableHttpClient httpclient = HttpClients.custom().setDefaultRequestConfig(requestConfig)
				.setDefaultCookieStore(cookieStore).build();
		CloseableHttpResponse response = httpclient.execute(httpget);
		// CloseableHttpResponse response = httpclient.execute(httpget, context);
		try {
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				System.out.println(EntityUtils.toString(entity, "utf8"));
			}
			EntityUtils.consume(entity);
		} finally {
			response.close();
			httpclient.close();
		}
	}

	public void setCookies(CookieStore cookieStore) throws IOException {
		String str = FileUtils.readFileToString(Utils.getResourceFromRoot("http/cookies.txt"));
		for (String s : str.split("},")) {
			if (!s.endsWith("}")) {
				s += "}";
			}
			JSONObject json = JSONObject.fromObject(s);

			BasicClientCookie bc = new BasicClientCookie(json.getString("name"), json.getString("value"));
			bc.setDomain(json.getString("domain"));
			bc.setPath(json.getString("path"));
			bc.setExpiryDate(DateUtils.addDays(new Date(), 1));
			bc.setSecure(json.getBoolean("secure"));
			bc.setAttribute(ClientCookie.PATH_ATTR, bc.getPath());
			bc.setAttribute(ClientCookie.DOMAIN_ATTR, bc.getDomain());
			cookieStore.addCookie(bc);
		}
	}

	public void $27() {
	}

	public void $28() {
	}

	public void $29() {
	}

	public void $30() {
	}

}
