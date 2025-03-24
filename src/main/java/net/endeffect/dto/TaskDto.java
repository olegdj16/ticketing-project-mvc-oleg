package net.endeffect.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.endeffect.enums.Status;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TaskDto {

    private Long id;
    private ProjectDto project;
    private UserDto assignedEmployee;
    private String taskSubject;
    private String taskDetail;

    private Status taskStatus;
    private LocalDate assignDate;

}
