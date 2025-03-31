package net.endeffect.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.endeffect.enums.Status;

import java.time.LocalDate;
import java.util.UUID;

@NoArgsConstructor
@Data
public class TaskDto {

    private Long id;
    private ProjectDto project;
    private UserDto assignedEmployee;
    private String taskSubject;
    private String taskDetail;

    private Status taskStatus;
    private LocalDate assignedDate;

    public TaskDto(ProjectDto project, UserDto assignedEmployee, String taskSubject, String taskDetail, Status taskStatus, LocalDate assignedDate) {
        this.project = project;
        this.assignedEmployee = assignedEmployee;
        this.taskSubject = taskSubject;
        this.taskDetail = taskDetail;
        this.taskStatus = taskStatus;
        this.assignedDate = assignedDate;
        this.id = UUID.randomUUID().getMostSignificantBits();
    }

}
