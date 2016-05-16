package tool;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.servlet.ServletRequest;

import net.minidev.json.JSONObject;

import org.apache.commons.beanutils.BeanUtils;

public class HttpRequestUtils {

	/**
	 * 這個JSONObject還沒決定要不要用這個
	 * @param req
	 * @return
	 */
	public JSONObject requestParamsToJSON(ServletRequest req) {
		JSONObject jsonObj = new JSONObject();
		Map<String, String[]> params = req.getParameterMap();
		for (Map.Entry<String, String[]> entry : params.entrySet()) {
			String v[] = entry.getValue();
			Object o = (v.length == 1) ? v[0] : v;
			jsonObj.put(entry.getKey(), o);
		}
		return jsonObj;
	}

	public void ddd(ServletRequest request, Object tragetObject) throws Exception {
		Map map = request.getParameterMap();
		BeanUtils.populate(tragetObject, map);
	}

}
