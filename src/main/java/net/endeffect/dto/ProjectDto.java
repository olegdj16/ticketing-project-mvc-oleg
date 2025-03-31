package net.endeffect.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.endeffect.enums.Status;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProjectDto {
    private String projectName;
    private String projectCode;
    private UserDto assignedManager;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;

    private String projectDetail;
    private Status projectStatus;

    // 17 Ticketing Project MVC Part5 @01:10:01
    private int completeTaskCounts;
    private int unfinishedTaskCounts;

    public ProjectDto(String projectName, String projectCode, UserDto assignedManager, LocalDate startDate, LocalDate endDate, String projectDetail, Status projectStatus) {
        this.projectName = projectName;
        this.projectCode = projectCode;
        this.assignedManager = assignedManager;
        this.startDate = startDate;
        this.endDate = endDate;
        this.projectDetail = projectDetail;
        this.projectStatus = projectStatus;
    }
}
