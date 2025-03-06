import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Message {
    private final String content;
    private final String sender;
    private final String recipient;

    public Message(MessageBuilder messageBuilder) {
        this.content = messageBuilder.getContent();
        this.sender = messageBuilder.getSender();
        this.recipient = messageBuilder.getRecipient();
    }

    // Getters for message properties
    public String getContent() {
        return content;
    }

    public String getSender() {
        return sender;
    }

    public String getRecipient() {
        return recipient;
    }

    public void printSummary() {
        System.out.println("Content: " + content);
        System.out.println("Sender: " + sender);
        System.out.println("Recipient: " + recipient);
    }

    public void printAdvancedInfomation() {
        System.out.println("Content Length: " + content.length());
        System.out.println("Sender Uppercase: " + sender.toUpperCase());
        System.out.println("Recipient Lowercase: " + recipient.toLowerCase());
    }

    public void printDetails() {
        printSummary();
        printAdvancedInfomation();
    }
}

class MessageBuilder {
    private final String content;
    private final String sender;
    private final String recipient;

    public MessageBuilder(String content, String sender, String recipient) {
        this.content = content;
        this.sender = sender;
        this.recipient = recipient;
    }

    public String getContent() {
        return content;
    }

    public String getRecipient() {
        return recipient;
    }

    public String getSender() {
        return sender;
    }

    public Message build() {
        return new Message(this);
    }
}

class MessageRepo {
    private Map<String, List<Message>> inbox;

    public MessageRepo() {
        this.inbox = new HashMap<>();
    }

    public void storingMessage(Message message) {
        inbox.computeIfAbsent(message.getRecipient(), k -> new ArrayList<>()).add(message);
    }

    public List<Message> getMessagesForRecipient(String recipient) {
        return inbox.getOrDefault(recipient, new ArrayList<>());
    }

    public Map<String, List<Message>> getAllMessages() {
        return inbox;
    }

}

class MessagingService {
    private MessageRepo messageRepo = new MessageRepo();

    public void sendMessage(String content, String sender, String recipient) {
        Message message = new MessageBuilder(content, sender, recipient).build();
        messageRepo.storingMessage(message);
    }

    public List<Message> getMessagesForRecipient(String recipient) {
        return messageRepo.getMessagesForRecipient(recipient);
    }

    public void printAllMessages() {

        Map<String, List<Message>> temptMap = messageRepo.getAllMessages();

        for (String recipient : temptMap.keySet()) {
            List<Message> messages = temptMap.get(recipient);
            for (Message message : messages) {
                message.printSummary();
            }
        }
    }
}

public class CommunicationAndMessaging {

    public static void main(String[] args) {

        MessagingService messagingService = new MessagingService();

        // sending messages
        messagingService.sendMessage("Hello, tenant!", "Property Manager", "Tenant A");
        messagingService.sendMessage("Important notice: Rent due next week.", "Property Owner", "Tenant A");
        messagingService.sendMessage("Maintenance request received.", "Tenant A", "Property Manager");

        // retrieving messages for a recipient
        List<Message> tenantAMessages = messagingService.getMessagesForRecipient("Tenant A");
        for (Message message : tenantAMessages) {
            System.out.println("From: " + message.getSender() + ", Content: " + message.getContent());
        }

        // Calling the new method
        Message exampleMessage = new MessageBuilder("Test", "Sender", "Recipient").build();
        exampleMessage.printDetails();

        messagingService.printAllMessages();
    }
}
