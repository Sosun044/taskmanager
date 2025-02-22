package com.taskmanager.service.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
@RequiredArgsConstructor
public class MailService {

    private final JavaMailSender mailSender;

    public void sendTaskReminder(String toEmail, String taskTitle, String dueDate) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

            helper.setTo(toEmail);
            helper.setSubject("📌 Görev Hatırlatma: " + taskTitle);
            helper.setText("Merhaba,\n\n" +
                    "Bu bir hatırlatmadır. Görevini tamamlamayı unutma!\n\n" +
                    "📌 Görev: " + taskTitle + "\n" +
                    "📅 Son Tarih: " + dueDate + "\n\n" +
                    "İyi çalışmalar dileriz!", false);

            mailSender.send(message);
            System.out.println("E-posta başarıyla gönderildi!");
        } catch (MessagingException e) {
            e.printStackTrace();
            System.err.println("E-posta gönderme hatası: " + e.getMessage());
        }
    }
}
