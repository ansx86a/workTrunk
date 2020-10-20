package javaMail;

import myspringBoot.MysbApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@SpringBootTest(classes = MysbApplication.class)
@RunWith(SpringRunner.class)
/**
 * 記得開啟google帳號->安全性->低安全性應用程式存取權即可正常測試
 */

public class SmtpTest {

    @Autowired
    private JavaMailSender emailSender;

    @Test
    public void 寄送純文字mail() {
        sendSimpleMessage("bnsx86b@gmail.com", "主旨", "內文<br>不會換行");
    }

    @Test
    public void 寄送純文字html() throws MessagingException {
        sendMessageWithHtml("bnsx86b@gmail.com", "主旨", "內文<p>會換行</p>");
    }

    @Test
    public void 寄送有附件mail() throws MessagingException {
        //gmail有禁止部分的附件： https://support.google.com/mail/?p=BlockedMessage
        //.ade、.adp、.apk、.appx、.appxbundle、.bat、.cab、.chm、.cmd、.com、.cpl、.dll、.dmg、.exe、.hta、.ins、.isp、.iso、.jar、.js、.jse、.lib、.lnk、.mde、.msc、.msi、.msix、.msixbundle、.msp、.mst、.nsh、.pif、.ps1、.scr、.sct、.shb、.sys、.vb、.vbe、.vbs、.vxd、.wsc、.wsf、.wsh
        sendMessageWithAttachment("bnsx86b@gmail.com", "主旨", "內文<p>不會換行</p>", "Z:\\新文字文件.txt");

    }

    private void sendSimpleMessage(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("noreply@baeldung.com");
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        emailSender.send(message);
    }

    public void sendMessageWithAttachment(String to, String subject, String text, String pathToAttachment) throws MessagingException {
        //為了要讓附件有中文檔名，一定要加這一行
        System.getProperties().computeIfAbsent("mail.mime.splitlongparameters", key -> "false");
        MimeMessage message = emailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setFrom("noreply@baeldung.com");
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(text);
        FileSystemResource file = new FileSystemResource(new File(pathToAttachment));
        helper.addAttachment("中文檔名", file);
        emailSender.send(message);
    }

    public void sendMessageWithHtml(String to, String subject, String text) throws MessagingException {
        //為了要讓附件有中文檔名，一定要加這一行
        System.getProperties().computeIfAbsent("mail.mime.splitlongparameters", key -> "false");
        MimeMessage message = emailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setFrom("noreply@baeldung.com");
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(text, true);
        emailSender.send(message);
    }

}
