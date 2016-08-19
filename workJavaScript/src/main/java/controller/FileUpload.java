package controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

//這裡有spring很多例子可以參考，寫得都蠻詳細的
//http://websystique.com/springmvc/spring-mvc-4-file-upload-example-using-commons-fileupload/

// http://docs.oracle.com/javaee/6/tutorial/doc/glraq.html
@Controller
public class FileUpload {

	// 這裡的@ModelAttribute的名字好像不重要，好像可以亂改，重點應該是FileUploadForm這個物件
	@RequestMapping(value = "/fileupload001.mvc")
	public String processRequest(@ModelAttribute("uploadForm") FileUploadForm uploadForm) throws ServletException,
			IOException {
		System.out.println("gogogo");
		List<MultipartFile> files = uploadForm.getFiles();
		for (MultipartFile mf : files) {
			File f = new File("z:/111");
			f.mkdirs();
			try (FileOutputStream fo = new FileOutputStream(new File(f, mf.getOriginalFilename()));
					InputStream fi = mf.getInputStream();) {
				IOUtils.copy(fi, fo);
			}
		}
		return "/jquery/ajax.jsp";
	}

	// 由mvc1改了過來，發現MultipartPart其實spring會用struts的actionForm的方式來接值
	@RequestMapping(value = "/fileupload002.mvc")
	public String processRequest2(FileUploadForm2 uploadForm2) throws ServletException, IOException {
		System.out.println("gogogo2");
		System.out.println(uploadForm2.getMyname());
		MultipartFile mf = uploadForm2.getMyf();
		File f = new File("z:/111");
		f.mkdirs();
		try (FileOutputStream fo = new FileOutputStream(new File(f, mf.getOriginalFilename()));
				InputStream fi = mf.getInputStream();) {
			IOUtils.copy(fi, fo);
		}
		return "/jquery/ajax.jsp";
	}

	
	
	/**
	 * 這個當做純servlet的upload的參考
	 */
	public String servletGetFile(HttpServletRequest request, HttpServletResponse response) throws IOException,
			ServletException {
		// Create path components to save the file
		String path = "z:/123";
		Part filePart = request.getPart("file");
		String fileName = getFileName(filePart);
		File outFile = new File(path + File.separator + fileName);
		outFile.getParentFile().mkdirs();

		try (OutputStream out = new FileOutputStream(outFile); InputStream filecontent = filePart.getInputStream();) {
			int read = 0;
			final byte[] bytes = new byte[1024];
			while ((read = filecontent.read(bytes)) != -1) {
				out.write(bytes, 0, read);
			}
		}
		return "ok:" + "New file " + fileName + " created at " + path;
	}

	private String getFileName(final Part part) {
		final String partHeader = part.getHeader("content-disposition");
		System.out.println("partHeader=" + partHeader);
		for (String content : part.getHeader("content-disposition").split(";")) {
			if (content.trim().startsWith("filename")) {
				return content.substring(content.indexOf('=') + 1).trim().replace("\"", "");
			}
		}
		return null;
	}

}
