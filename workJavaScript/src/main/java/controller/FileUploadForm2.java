package controller;

import org.springframework.web.multipart.MultipartFile;

public class FileUploadForm2 {

	private MultipartFile myf;
	private String myname;

	public MultipartFile getMyf() {
		return myf;
	}

	public void setMyf(MultipartFile myf) {
		this.myf = myf;
	}

	public String getMyname() {
		return myname;
	}

	public void setMyname(String myname) {
		this.myname = myname;
	}


}
