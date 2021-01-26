package ftp;

import com.jcraft.jsch.*;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.Vector;

import static java.util.stream.Collectors.toList;

public class SftpUseJsch {
    String host = "192.168.10.1";
    String port = "22";
    String username = "Fuco";
    String password = "Fuco1234";
    String directory = "/";
    ChannelSftp sftp;
    Session session;

    public static void main(String[] args) throws IOException, JSchException {
        SftpUseJsch sf = new SftpUseJsch();
        File uploadFile = new File("z:/要上傳的檔案");
        sf.connect();
        sf.upload(uploadFile);
        sf.logout();
    }

    public void upload(File uploadFile) {
        //以前寫的應該可以用，要用的時候最好測一下
        try (FileInputStream f = new FileInputStream(uploadFile)) {
            sftp.cd(directory);
            sftp.put(f, uploadFile.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void connect() throws JSchException {
        connect(host, Integer.valueOf(port), username, password);
    }

    public void connect(String host, int port, String username, String password) throws JSchException {
        JSch jsch = new JSch();
        //取得session
        session = jsch.getSession(username, host, port);
        //設定session屬性
        session.setPassword(password);
        Properties sshConfig = new Properties();
        sshConfig.put("StrictHostKeyChecking", "no");
        session.setConfig(sshConfig);
        session.connect();
        System.out.println("Session connected.");
        //取得sftp channel
        Channel channel = session.openChannel("sftp");
        channel.connect();
        sftp = (ChannelSftp) channel;
    }

    public List<ChannelSftp.LsEntry> listFtpFile(String dir) throws SftpException {
        //這裡沒有泛型，ls的另一個overload的method是filter，有興趣可以研究一下
        Vector list = sftp.ls(dir);
        return toEntryList(list);
    }

    private static List<ChannelSftp.LsEntry> toEntryList(List list) {
        List<ChannelSftp.LsEntry> entryList = (List<ChannelSftp.LsEntry>) list.stream().filter(o -> o instanceof ChannelSftp.LsEntry).collect(toList());
        //因為會有.和..這兩個路徑，要拿掉，這裡先用長度來判斷
        return entryList.stream().filter(o -> o.getFilename().length() > 3).collect(toList());
    }

    public void logout() {
        if (sftp != null && sftp.isConnected()) {
            sftp.disconnect();
        }
        if (session != null && session.isConnected()) {
            session.disconnect();
        }
    }

    public void downloadFtpFile(String dir, String fileName, File localFile) throws IOException, SftpException {
        FileUtils.forceMkdirParent(localFile);
        sftp.cd(dir);
        //可用try catch利用auto close功能
        FileOutputStream fileOutputStream = new FileOutputStream(localFile);
        sftp.get(fileName, fileOutputStream);
        fileOutputStream.close();
    }

    public void deleteFtpFile(String dir, String fileName) throws SftpException {
        sftp.cd(dir);
        sftp.rm(fileName);
    }

}
