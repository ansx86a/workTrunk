package controller;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import tool.Utils;

@Controller
@RequestMapping("/testHttp")
public class TestHttpController {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * 測試捉server檔案,正常io的例子，檔案會自動下載，不知道怎麼調成非自動下載<br>
	 * 經驗証都是瀏灠器的問題才會自動下載，所以下例算是ok了
	 * 可參照這裡看看http://www.codejava.net/frameworks/spring/spring-mvc-sample-application-for-downloading-files
	 * @param request
	 * @param response
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping(value = "/ggg.mvc", method = RequestMethod.GET)
	public void 回傳下載檔案範例(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String fileName = "fileName";
		String result = "中文this is text中文";
		ByteArrayInputStream bi = new ByteArrayInputStream(result.getBytes("utf8"));
		// response.setContentType("application/force-download");
		// response.setContentType("text/csv");
		response.setContentType("application/octet-stream");

		response.setHeader("content-disposition", "attachment; filename=" + fileName + ".txt");
		// 上一行應該可以用這一行取代
		// respHeaders.setContentDispositionFormData("attachment", "fileNameIwant.pdf");
		IOUtils.copy(bi, response.getOutputStream());
		response.flushBuffer();
		bi.close();
	}

	/**
	 * 網路抄的例子
	 * @param fileName
	 * @return
	 */
	@RequestMapping(value = "/files/{file_name}", method = RequestMethod.GET)
	@ResponseBody
	public FileSystemResource getFile(@PathVariable("file_name") String fileName) {
		File file = new File(fileName);
		return new FileSystemResource(file);
	}

	/**
	 * <pre>
	 * post接受端
	 * 重點1：web.xml 要加入
	 * <filter>
	 *     <display-name>springMultipartFilter</display-name>
	 *     <filter-name>springMultipartFilter</filter-name>
	 *     <filter-class>org.springframework.web.multipart.support.MultipartFilter</filter-class>
	 * </filter>
	 * <filter-mapping>
	 *     <filter-name>springMultipartFilter</filter-name>
	 *     <url-pattern>/*</url-pattern>
	 * </filter-mapping>
	 * 
	 * 重點2：tomcat注意事項，重點是allowCasualMultipartParsing=true
	 * <Context allowCasualMultipartParsing="true" docBase="venus-bms" path="/venus-bms" reloadable="true" source="org.eclipse.jst.jee.server:venus-bms"/>
	 * </pre>
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value = "/ppp.mvc", method = RequestMethod.POST)
	public void MultipartEntity接收(MultipartHttpServletRequest request, HttpServletResponse response) throws Exception {
		// final String path = request.getParameter("destination");
		System.out.println("pppp=================");
		final String path = "z:/httpUploadTest";
		final Part filePart2 = request.getPart("file");
		final Part comment = request.getPart("comment");
		System.out.println("comment==================");
		IOUtils.copy(comment.getInputStream(), System.out);
		System.out.println();
		// Part filePart2 =(Part) request.getParts().toArray()[0];
		final String fileName = getFileName(filePart2);

		try (InputStream filecontent = filePart2.getInputStream()) {
			String s = IOUtils.toString(filecontent);
			System.out.println(s);
		} catch (Exception fne) {
			fne.fillInStackTrace();
		}

	}

	// 接收時取得fileName，不像自已寫的，應該是上傳的路徑都是客戶本地的路徑，這裡要把它改成客戶本地的namt
	private String getFileName(final Part part) {
		final String partHeader = part.getHeader("content-disposition");
		// LOGGER.log(Level.INFO, "Part Header = {0}", partHeader);
		for (String content : part.getHeader("content-disposition").split(";")) {
			if (content.trim().startsWith("filename")) {
				return content.substring(content.indexOf('=') + 1).trim().replace("\"", "");
			}
		}
		return null;
	}

	@RequestMapping(value = "/index.mvc", method = RequestMethod.GET)
	public void 測試首頁(HttpServletRequest request) throws Exception {
		System.out.println("start===================");
		發送MultipartEntity();
		System.out.println("end===================");
	}

	// @RequestMapping(value = "/", method = RequestMethod.GET)
	/**
	 * 測試get發送端
	 * @throws Exception
	 */
	public void 發送MultipartEntity() throws Exception {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		try {
			HttpPost httppost = new HttpPost("http://localhost:8080/workMybatis/testHttp/ppp.mvc");

			FileBody bin = new FileBody(Utils.getResourceFromRoot("controller/http.txt"));
			StringBody comment = new StringBody("A binary file of some kind", ContentType.TEXT_PLAIN);
			HttpEntity reqEntity = MultipartEntityBuilder.create().addPart("file", bin).addPart("comment", comment)
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

}
