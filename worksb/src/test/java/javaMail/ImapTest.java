package javaMail;

import org.junit.Test;

import javax.mail.Address;
import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import static java.lang.String.format;
import static java.util.stream.Collectors.toList;

public class ImapTest {

    @Test
    public void test() {
        System.out.println("ok");
    }

    /**
     * https://myaccount.google.com/lesssecureapps?pli=1
     * 要先去我的帳戶，把低安全性應用程式存取權給打開，以下的程式才會生效
     *
     * 熊下有全部可用的Properties
     *
     * https://javaee.github.io/javamail/docs/api/com/sun/mail/imap/package-summary.html
     *
     * proxy相關，可以用SOCKS5的不用帳密
     * mail.imap.proxy.host	string	Specifies the host name of an HTTP web proxy server that will be used for connections to the mail server.
     * mail.imap.proxy.port	string	Specifies the port number for the HTTP web proxy server. Defaults to port 80.
     * mail.imap.proxy.user	string	Specifies the user name to use to authenticate with the HTTP web proxy server. By default, no authentication is done.
     * mail.imap.proxy.password	string	Specifies the password to use to authenticate with the HTTP web proxy server. By default, no authentication is done.
     * mail.imap.socks.host	string	Specifies the host name of a SOCKS5 proxy server that will be used for connections to the mail server.
     * mail.imap.socks.port	string	Specifies the port number for the SOCKS5 proxy server. This should only need to be used if the proxy server is not using the standard port number of 1080.
     *
     */
    @Test
    public void 測試取得根目錄的全folder並列出全部的inbox資料imaps協定() {
        try {
            Properties props = new Properties();
            props.put("mail.store.protocol", "imaps");
            Session session = Session.getDefaultInstance(props, null);
            Store store = session.getStore("imaps");
            store.connect("imap.gmail.com", "bnsx86b@gmail.com", "graffiti");
            Folder inbox = store.getFolder("INBOX");//注意要大寫

            //列出全部的目錄
            inbox.open(Folder.READ_ONLY);
            int messageCount = inbox.getMessageCount();
            System.out.println(store.getDefaultFolder().list("*"));
            javax.mail.Folder[] folders = store.getDefaultFolder().list("*");//感覺直接用list()即可
            for (javax.mail.Folder folder : folders) {
                if ((folder.getType() & javax.mail.Folder.HOLDS_MESSAGES) != 0) {
                    System.out.println(folder.getName());
                }
            }

            System.out.println("Total Messages:-: " + messageCount);
            javax.mail.Message[] messages = inbox.getMessages();

            System.out.println("------------------------------");
            System.out.println("messages: " + messages.toString());
            for (int i = 0; i < messages.length; i++) {
                System.out.println("getResult1: " + messages[i].getSubject());
            }
            inbox.close(true);//好像true才會使delete生效
            store.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 以下程式在登入時會被server斷線，先保留做為記錄
     */
    @Test
    public void 測試取得根目錄的全folder並列出全部的inbox資料imap協定() {

        try {
            String protocol = "imap";
            Properties props = new Properties();
            props.put("mail.imap.host", "imap.gmail.com");
            props.put("mail.imap.port", "993");
            props.put("mail.store.protocol", protocol);
            props.put("mail.debug", "false");

            //加上下行設定就不會被server中斷，另2行例子有寫但註解掉也能跑
            props.setProperty("mail." + protocol + ".socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            //props.setProperty("mail.imap.socketFactory.fallback", "false");
            //props.setProperty("mail.imap.socketFactory.port", "993");

            Session session = Session.getInstance(props);
            Store store = session.getStore(protocol);
            store.connect("bnsx86b@gmail.com", "graffiti");

            Folder inbox = store.getFolder("INBOX");

            inbox.open(Folder.READ_ONLY);
            int messageCount = inbox.getMessageCount();
            System.out.println(store.getDefaultFolder().list("*"));
            javax.mail.Folder[] folders = store.getDefaultFolder().list("*");

            for (javax.mail.Folder folder : folders) {
                if ((folder.getType() & javax.mail.Folder.HOLDS_MESSAGES) != 0) {
                    System.out.println(folder.getName());
                }
            }

            System.out.println("Total Messages:-: " + messageCount);
            javax.mail.Message[] messages = inbox.getMessages();

            System.out.println("------------------------------");
            System.out.println("messages: " + messages.toString());
            for (int i = 0; i < messages.length; i++) {
                System.out.println("getResult1: " + messages[i].getSubject());
            }
            inbox.close(true);
            store.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
