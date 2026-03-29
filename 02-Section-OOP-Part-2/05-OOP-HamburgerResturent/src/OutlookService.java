public class OutlookService implements EmailService {
    @Override
    public void sendEmail(String to) {
        System.out.println("📨 Sending email via Outlook to " + to);
    }
}
