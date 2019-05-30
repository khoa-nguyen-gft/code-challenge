//package demo;

import java.util.HashSet;
import java.util.Set;

public class App{
    public static void main(String[] args) {
        Email email = new Email.EmailBuilder()
        .addNewRecipient("john@Doe.com")
        .addNewRecipient("npdangkhoa@gmail.com")
        .setGreeting("Hi John!")
        .setClosing("Regards")
        .setMainText("this is the demo of builder pattern java")
        .setTitle("Builder pattern resources")
        .build();

        System.out.println(email.toString());
    }
}

class Email {

    private final String title;
    private final String recipients;
    private final String message;
   
    public String toString(){
        return title + "\n" + recipients + "\n" + message;
    }

    public Email(String title, String recipients, String message){
        this.title = title;
        this.recipients = recipients;
        this.message = message;
    }

    public String getTitle() {
        return title;
    }
    public String getRecipients() {
        return recipients;
    }
    public String getMessage() {
        return message;
    }
    public void send() {
    }

    public static class EmailBuilder{
        private Set recipients = new HashSet<String>();
        private String title;
        private String greeting;
        private String mainText;
        private String closing;
    
        public Email build(){
            String message  = greeting + "\n"
                    + mainText + "\n"
                    + closing;
            
            String recipientSection = String.join("; ", recipients);
    
            return new Email(title, recipientSection, message);
        }
       
        public EmailBuilder addNewRecipient(String recipient){
            this.recipients.add(recipient);
            return this;
        }
    
        public EmailBuilder removeRecipient(String recipient){
            this.recipients.remove(recipient);
            return this;
        }
    
        public EmailBuilder setClosing(String closing) {
            this.closing = closing;
            return this;
        }
    
        public EmailBuilder setTitle(String title) {
            this.title = title;
            return this;
        }
    
        public EmailBuilder setGreeting(String greeting) {
            this.greeting = greeting;
            return this;
        }
    
        public EmailBuilder setMainText(String mainText){
            this.mainText = mainText;
            return this;
        }
    
    }
    

    
}

