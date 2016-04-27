package tool;

import javax.servlet.http.HttpServletRequest;

public class Utils {
	public static ThreadLocal requestLocal = new ThreadLocal();

	public static void setRequest(HttpServletRequest o) {
		requestLocal.set(o);
	}

	public static HttpServletRequest getRequest() {
		return (HttpServletRequest) requestLocal.get();
	}

	public static void setRequestLocal(ThreadLocal requestLocal) {
		Utils.requestLocal = requestLocal;
	}

}