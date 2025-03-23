package net.endeffect.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.endeffect.enums.Status;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProjectDto {

    private String projectName;
    private String projectCode;
    private UserDto assignedManager;
    private LocalDate startDate;
    private LocalDate endDate;
    private String projectDetail;
    private Status projectStatus;

}
