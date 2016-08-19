package controller;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

/**
 * 這裡的重點是files要對應到web的name為files[0]…
 * @author ai
 *
 */
public class FileUploadForm {

	private List<MultipartFile> files;

	public List<MultipartFile> getFiles() {
		return files;
	}

	public void setFiles(List<MultipartFile> files) {
		this.files = files;
	}
}
