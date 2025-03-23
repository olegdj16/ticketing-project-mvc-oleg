package net.endeffect.dto;

import net.endeffect.enums.Status;

import java.time.LocalDate;

public class ProjectDto {

    private String projectName;
    private String projectCode;
    private UserDto assignedManager;
    private LocalDate startDate;
    private LocalDate endDate;
    private String projectDetail;
    private Status projectStatus;

}
