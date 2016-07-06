package 新功能;

import java.io.IOException;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import org.apache.commons.io.FileUtils;

import tool.Utils;

public class Java8Js {
	// http://ithelp.ithome.com.tw/question/10118962
	// http://www.infoq.com/cn/articles/nashorn
	// http://www.codedata.com.tw/java/jdk8-nashorn-jjs/
	public static void main(String[] args) throws IOException {
		$1();
		$2();
	}

	public static void $1() {
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

	//載入自已寫的原生js，不含第三方元件
	public static void $2() throws IOException {
		ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
		ScriptEngine nashorn = scriptEngineManager.getEngineByName("nashorn");
		Integer result = null;
		try {
			nashorn.put("jslib", Utils.getResourceFromRoot("新功能/testjs.js"));
			nashorn.eval(FileUtils.readFileToString(Utils.getResourceFromRoot("新功能/testjs.js")));
			nashorn.eval("print(testSum())");
			result = (Integer) nashorn.eval("testSum()");
			System.out.println(result.toString());
		} catch (ScriptException e) {
			System.out.println("Error executing script: " + e.getMessage());
		}
	}

}
