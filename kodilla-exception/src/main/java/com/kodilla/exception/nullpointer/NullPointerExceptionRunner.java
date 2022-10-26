package com.kodilla.exception.nullpointer;

public class NullPointerExceptionRunner {
    public static void main(String[] args) {
        User user = null;
        MessageSender messageSender = new MessageSender();
        try {
            messageSender.sendMessageTo(user, "Hello");
        } catch (MessageNotSentException e) {
            System.out.println("Message not sent, user is empty");
        } finally {
            System.out.println("Processing other logic");
        }
    }
}
