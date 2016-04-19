package 新功能;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Java8Js {
	// http://ithelp.ithome.com.tw/question/10118962
	// http://www.infoq.com/cn/articles/nashorn
	// http://www.codedata.com.tw/java/jdk8-nashorn-jjs/
	public static void main(String[] args) {
		// java可以執行javascript，至少原生的應該沒有問題
		// 至於載入jquery之類的東西還不確定能不能定，實用性一半一半
		// 至少可以做json吧

		ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
		ScriptEngine nashorn = scriptEngineManager.getEngineByName("nashorn");
		String name = "Mahesh";
		Integer result = null;
		try {
			nashorn.eval("print('" + name + "')");
			result = (Integer) nashorn.eval("10 + 2");
			System.out.println(result.toString());
			nashorn.eval(" var vvv = function(x,y){ print(x+y);}");
			nashorn.eval(" vvv(102,14)");

		} catch (ScriptException e) {
			System.out.println("Error executing script: " + e.getMessage());
		}

	}

}
