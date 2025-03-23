package net.endeffect.service;

import net.endeffect.dto.ProjectDto;

public interface ProjectService extends CrudService<ProjectDto, String> {

    void complete(ProjectDto project);
}
