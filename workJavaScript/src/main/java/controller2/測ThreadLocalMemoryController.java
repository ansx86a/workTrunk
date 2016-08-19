package controller2;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class 測ThreadLocalMemoryController {
	// 這邊會ThreadLocal會leak ，最後會outofmemory
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	private static MyThreadLocal myThreadLocal = new MyThreadLocal();

	@RequestMapping(value = "/thread001.mvc", method = RequestMethod.GET)
	public String test1(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("gogo2");
		MyCounter counter = myThreadLocal.get();
		if (counter == null) {
			counter = new MyCounter();
			myThreadLocal.set(counter);
		}
		counter.increment();
		counter.read(new File("z:/1.bin"));
		System.gc();
		return "/jsp/test.jsp";
	}

}