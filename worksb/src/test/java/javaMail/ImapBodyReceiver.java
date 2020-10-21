package javaMail;

import org.apache.commons.mail.util.MimeMessageParser;
import org.junit.Test;

import javax.activation.DataSource;
import javax.mail.Address;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.internet.MimeMessage;
import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.Properties;
import java.util.stream.Collectors;

public class ImapBodyReceiver {

    /**
     * Returns a Properties object which is configured for a POP3/IMAP server
     *
     * @param protocol either "imap" or "pop3"
     * @param host
     * @param port
     * @return a Properties object
     */
    private Properties getServerProperties(String protocol, String host, String port) {
        Properties properties = new Properties();
        // server setting
        properties.put("mail." + protocol + ".host", host);
        properties.put("mail." + protocol + ".port", port);
        // SSL setting好像只有第一行重要，其它2行好像沒差
        properties.setProperty("mail." + protocol + ".socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        properties.setProperty("mail." + protocol + ".socketFactory.fallback", "false");
        properties.setProperty("mail." + protocol + ".socketFactory.port", "" + port);
        return properties;
    }

    /**
     * Downloads new messages and fetches details for each message.
     *
     * @param protocol
     * @param host
     * @param port
     * @param userName
     * @param password
     */
    public void 讀取內文(String protocol, String host, String port, String userName, String password) throws Exception {
        Properties properties = getServerProperties(protocol, host, port);
        Session session = Session.getDefaultInstance(properties);

        try {
            // connects to the message store
            Store store = session.getStore(protocol);
            store.connect(userName, password);

            // opens the inbox folder
            Folder folderInbox = store.getFolder("INBOX");
            folderInbox.open(Folder.READ_ONLY);

            // fetches new messages from server
            Message[] messages = folderInbox.getMessages();

            for (int i = 0; i < messages.length; i++) {
                Message msg = messages[i];
                Address[] fromAddress = msg.getFrom();
                String from = fromAddress[0].toString();
                String subject = msg.getSubject();
                String toList = Arrays.stream(msg.getRecipients(Message.RecipientType.TO)).map(o -> o.toString()).collect(Collectors.joining(", "));
                //ccList有時會有null的問題，先註解掉
                //String ccList = Arrays.stream(msg.getRecipients(Message.RecipientType.CC)).map(o -> o.toString()).collect(Collectors.joining(", "));
                String sentDate = msg.getSentDate().toString();
                String contentType = msg.getContentType();
                String messageContent = "";
                MimeMessageParser mimeMessageParser = new MimeMessageParser((MimeMessage) msg).parse();
                //使用apache的common email來讀取內文
                if (contentType.contains("text/html")) {
                    messageContent = mimeMessageParser.getHtmlContent();
                } else {
                    //好像plain讀不到html，但是反過來用html可以讀出純文字的樣子
                    messageContent = mimeMessageParser.getPlainContent();
                }
                for (DataSource dataSource : mimeMessageParser.getAttachmentList()) {
                    //這裡的附件是信中的圖片也算，而不是只捉附件這個欄位是整封信中非文元的部分都算吧，有要用再來測
                    System.out.println(dataSource.getContentType());
                    System.out.println(dataSource.getName());
                    //IOUtils.copy(dataSource.getInputStream(),new FileOutputStream("z:/" + dataSource.getName()));
                }


                // print out details of each message
                System.out.println("Message #" + (i + 1) + ":");
                System.out.println("\t From: " + from);
                System.out.println("\t To: " + toList);
                //System.out.println("\t CC: " + ccList);
                System.out.println("\t Subject: " + subject);
                System.out.println("\t Sent Date: " + sentDate);
                System.out.println("\t Message: " + messageContent);
            }

            // disconnect
            folderInbox.close(false);
            store.close();
        } catch (NoSuchProviderException ex) {
            System.out.println("No provider for protocol: " + protocol);
            ex.printStackTrace();
        } catch (MessagingException ex) {
            System.out.println("Could not connect to the message store");
            ex.printStackTrace();
        }
    }

    /**
     * Test downloading e-mail messages
     */
    @Test
    public void test() throws Exception {
        // for POP3
        //String protocol = "pop3";
        //String host = "pop.gmail.com";
        //String port = "995";

        // for IMAP
        String protocol = "imap";
        String host = "imap.gmail.com";
        String port = "993";

        String userName = "bnsx86b@gmail.com";
        String password = "graffiti";

        ImapBodyReceiver receiver = new ImapBodyReceiver();
        receiver.讀取內文(protocol, host, port, userName, password);
    }
}