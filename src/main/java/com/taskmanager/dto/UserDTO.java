package com.taskmanager.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.taskmanager.model.Task;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {
    private Long id;
    private String email;
    private String name;
    private String password;
    private com.taskmanager.model.Role role;
    // Eğer görevleri göndermek istemiyorsan bu alanı kaldırabilirsin:
    // private List<com.taskmanager.model.Task> tasks;
    @JsonIgnore
    private List<Task> tasks;

}
