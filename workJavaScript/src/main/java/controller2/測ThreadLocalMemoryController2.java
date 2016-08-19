package controller2;

import java.io.File;
import java.io.IOException;
import java.util.Base64;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class 測ThreadLocalMemoryController2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@RequestMapping(value = "/thread002.mvc", method = RequestMethod.GET)
	public String test1(HttpServletRequest request, HttpServletResponse response) {
		// 結論？在
		System.out.println("gogo2");
		可以gc: {
			// MyThreadLocal2.save(request);
		}
		無法gc: {
			try {
				// byte b[] = FileUtils.readFileToByteArray(new File("z:/1.bin"));
				// String s = Base64.getEncoder().encodeToString(b);
				for (int i = 0; i < Integer.MAX_VALUE; i++) {
					String s = "kkk" + i;
					Thread t = new Thread(() -> {
						MyThreadLocal2.saveStr(s);
					});
					t.start();
					if (i % 100 == 0) {
						System.out.println(i / 100 + "/" + Integer.MAX_VALUE / 100);
					}
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return "/jsp/test.jsp";
	}

}