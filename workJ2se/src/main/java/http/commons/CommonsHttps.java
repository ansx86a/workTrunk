package http.commons;

import java.util.Calendar;

import http.https相關.NewSSLProtocolSocketFactory;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.protocol.Protocol;

//org.apache.commons.httpclient
//這應該是舊的，包在commons那包，使用新的org.apache.httpcomponents
public class CommonsHttps {

	public static void main(String[] args) {
		CommonsHttps h = new CommonsHttps();
		//ctcb後端發非同步通知使用
		h.test("https://tw.yahoo.com/");
		System.out.println("end");
	}

	public void test(String url) {
		try {
			Protocol myhttps = new Protocol("https", new NewSSLProtocolSocketFactory(), 443);
			Protocol.registerProtocol("https", myhttps);

			// 1.create HttpClient and set parameter
			HttpClient client = new HttpClient();
			PostMethod method = new PostMethod(url);

			// 2.Send Request
			long s = Calendar.getInstance().getTimeInMillis();
			int httpStatusCode = client.executeMethod(method);
			long e = Calendar.getInstance().getTimeInMillis();
			System.out.println("sendRequest() httpStatusCode->" + httpStatusCode + ", spend time->" + (e - s) + "ms");

			// 3.check Http Status Code
			if (HttpStatus.SC_OK != httpStatusCode) {
				System.out.println(method.getResponseBodyAsString());
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}
}
