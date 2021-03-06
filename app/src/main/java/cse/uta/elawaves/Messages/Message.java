package cse.uta.elawaves.Messages;


import java.time.LocalDateTime;

public class Message {
    // Unique ID for every message
    //private int messageID;
    // TimeStamp of the message
    private LocalDateTime messageTimeStamp;
    // The message itself
    private String message = "";
    // Was this message received or sent
    private boolean received = true;
    // The address of the other party
    private String address;
    // Is this message a part of another message
    //private int reference;
    // How should this message be ordered if reference is set
    //private int messagePosition = 0;

    Message(String message,boolean received,String address){
        this.message = message;
        this.received = received;
        this.address = address;
    }

    Message(String message,boolean received,String address,LocalDateTime messageTimeStamp){
        this(message,received,address);
        this.messageTimeStamp = messageTimeStamp;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getMessageTimeStamp() {
        return messageTimeStamp;
    }

    public String getAddress() {
        return address;
    }

    public boolean isReceived() {
        return received;
    }
}
