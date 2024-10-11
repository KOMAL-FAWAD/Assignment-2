import java.util.Scanner;
import java.time.LocalDateTime;

public class Messages {
    private String sendername = "Komal";
    private String senderContact = "02369852144";
    private String receivername;
    private String content;
    private int messageid;
    private boolean status;
    private LocalDateTime dateTime;
    private static int counter = 0;

    public Messages(String sendername, String senderContact, String receivername, String content, boolean status) {
        this.sendername = sendername;
        this.senderContact = senderContact;
        this.receivername = receivername;
        this.content = content;
        this.status = status;
        dateTime = LocalDateTime.now();
        this.messageid =  counter++;
    }

    public Messages(String receivername, String content) {
        this.receivername = receivername;
        this.content = content;
        this.status = true;
        this.dateTime = LocalDateTime.now();
    }

    public String getSendername() {
        return sendername;
    }

    public void setSendername(String sendername) {
        this.sendername = sendername;
    }

    public String getReceivername() {
        return receivername;
    }

    public void setReceivername(String receivername) {
        this.receivername = receivername;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getMessageid() {
        return messageid;
    }

    public void setMessageid(int messageid) {
        this.messageid = messageid;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        return String.format("Sender = %s\n ,Sender Contact = %s\n, Receiver = %s\n , Content = %s\n , Message ID = %s\n" +
                " , Status = %b\n , Date and Time = %s\n", sendername, senderContact, receivername, content, counter++ ,status,dateTime);

    }
}
