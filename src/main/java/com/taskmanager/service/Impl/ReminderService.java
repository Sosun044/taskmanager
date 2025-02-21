package com.taskmanager.service.Impl;

import com.taskmanager.model.Task;
import com.taskmanager.repository.ITaskRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ReminderService {

    private final ITaskRepository taskRepository;
    private final MailService emailService;

    @Scheduled(fixedRate = 60000) // Her 1 dakikada bir çalışır
    public void checkReminders() {
        log.info("Hatırlatma kontrolü çalışıyor...");

        LocalDateTime now = LocalDateTime.now();
        List<Task> tasksToRemind = taskRepository.findByDueDateBeforeAndIsCompletedFalse(now);

        for (Task task : tasksToRemind) {
            String to = task.getEmail(); // Dinamik e-posta adresi çekiliyor
            String subject = "Görev Hatırlatma: " + task.getTitle();
            String text = "Merhaba,\n\n" +
                    "Görev: " + task.getTitle() + "\n" +
                    "Açıklama: " + task.getDescription() + "\n" +
                    "Son Tarih: " + task.getDueDate() + "\n\n" +
                    "Lütfen görevi tamamlayın!";

            emailService.sendTaskReminder(to, task.getTitle(), task.getDueDate().toString());
            log.info("Hatırlatma e-postası gönderildi: {}", task.getTitle());
        }
    }
}
