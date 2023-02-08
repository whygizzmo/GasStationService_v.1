package kg.itschoolmegacom.gasstationservice.service;

public interface MailService {
    void sendEmail(String recepient, String text, String subject);
}
