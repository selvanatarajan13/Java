public class GmailService implements EmailService {
    @Override
    public void sendEmail(String to) {
        System.out.println("📧 Sending email via Gmail to " + to);
    }
}
