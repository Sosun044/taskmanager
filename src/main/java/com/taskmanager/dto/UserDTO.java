package com.taskmanager.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.taskmanager.model.Role;
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
    private Role role;
    @JsonIgnore
    private List<Task> tasks;

}
