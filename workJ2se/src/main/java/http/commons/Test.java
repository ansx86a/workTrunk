package http.commons;

import java.util.Calendar;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;

public class Test {

	public static void main(String args[]) {
		new Test().sendRequest("");
	}

	private void sendRequest(String url) {
		try {
			url = "http://127.0.01/1.php?a=100";

			// 1.create HttpClient and set parameter
			HttpClient client = new HttpClient();
			PostMethod method = new PostMethod(url);

			// 2.Send Request
			long s = Calendar.getInstance().getTimeInMillis();
			int httpStatusCode = client.executeMethod(method);
			long e = Calendar.getInstance().getTimeInMillis();
			String str = "sendRequest() httpStatusCode->" + httpStatusCode + ", spend time->" + (e - s) + "ms";
			System.out.println(str);

			System.out.println(method.getResponseBodyAsString());

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
