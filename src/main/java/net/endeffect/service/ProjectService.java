package net.endeffect.service;

import net.endeffect.dto.ProjectDto;
import net.endeffect.dto.UserDto;

import java.util.List;

public interface ProjectService extends CrudService<ProjectDto, String> {


    void complete(ProjectDto project);

    List<ProjectDto> findAllNonCompletedProjects();

    List<ProjectDto> getCountedListOfProjectDTO(UserDto manager);

}
