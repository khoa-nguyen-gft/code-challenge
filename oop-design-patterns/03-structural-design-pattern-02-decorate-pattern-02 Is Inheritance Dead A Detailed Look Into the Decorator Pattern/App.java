import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AppBefore {
    public static void main(String[] arg) {
        new EmailServiceRetryDecorator(new EmailService());
    }
}

interface IEmailService {
    void send(Email email);
    Collection<EmailInfo> listEmail(int begin, int end);
    Email download(EmailInfo emailInfo);
}



class EmailServiceRetryDecorator implements IEmailService {
    private final IEmailService emailService;

    public EmailServiceRetryDecorator(IEmailService iEmailService) {
        this.emailService = iEmailService;
    }

    @Override
    public void send(Email email) {
        executeWithRetrives(() -> emailService.send(email));
    }

    @Override
    public Collection<EmailInfo> listEmail(int begin, int end) {
        final List<EmailInfo> emailInfos = new ArrayList<EmailInfo>();
        executeWithRetrives(() -> emailInfos.addAll(
                emailService.listEmail(begin, end))
        );

        return emailInfos;
    }

    @Override
    public Email download(EmailInfo emailInfo) {
        final Email[] email = new Email[1];
        executeWithRetrives(() ->
        email[0] = emailService.download(emailInfo));
        return email[0];
    }

    private void executeWithRetrives (Runnable runnable) {
        for (int i = 0; i < 3; i++) {
            try {
                runnable.run();
            } catch (Exception e) {
                continue;
            }
            break;
        }

    }

}

class EmailService implements IEmailService {

    @Override
    public void send(Email email) {
        // TODO Auto-generated method stub

    }

    @Override
    public Collection<EmailInfo> listEmail(int begin, int end) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Email download(EmailInfo emailInfo) {
        // TODO Auto-generated method stub
        return null;
    }

}
class Email {}

class EmailInfo{}