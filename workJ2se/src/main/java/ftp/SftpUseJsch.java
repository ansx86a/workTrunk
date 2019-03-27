package ftp;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

public class SftpUseJsch {
	String host = "192.168.10.1";
	String port = "22";
	String username = "Fuco";
	String password = "Fuco1234";
	String directory = "/";

	public static void main(String[] args) throws IOException {
		SftpUseJsch sf = new SftpUseJsch();
		File uploadFile = new File("z:/要上傳的檔案");
		sf.upload(uploadFile);
		
	}

	public void upload(File uploadFile) {
		ChannelSftp sftp = connect();
		try (FileInputStream f = new FileInputStream(uploadFile)) {
			sftp.cd(directory);
			sftp.put(f, uploadFile.getName());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sftp.disconnect();
			System.out.println("Disconnected.");
		}
	}

	public ChannelSftp connect() {
		return connect(host, Integer.valueOf(port), username, password);
	}

	public ChannelSftp connect(String host, int port, String username, String password) {
		ChannelSftp sftp = null;
		try {
			JSch jsch = new JSch();
			//取得session
			jsch.getSession(username, host, port);
			Session sshSession = jsch.getSession(username, host, port);
			System.out.println("Session created.");
			
			//設定session屬性
			sshSession.setPassword(password);
			Properties sshConfig = new Properties();
			sshConfig.put("StrictHostKeyChecking", "no");
			sshSession.setConfig(sshConfig);
			sshSession.connect();
			System.out.println("Session connected.");
			
			//取得sftp channel
			Channel channel = sshSession.openChannel("sftp");
			channel.connect();
			sftp = (ChannelSftp) channel;
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return sftp;
	}
	
	

}
