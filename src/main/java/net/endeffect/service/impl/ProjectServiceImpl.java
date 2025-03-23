package net.endeffect.service.impl;

import net.endeffect.dto.ProjectDto;
import net.endeffect.enums.Status;
import net.endeffect.service.ProjectService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl extends AbstractMapService<ProjectDto, String> implements ProjectService {

    @Override
    public ProjectDto save(ProjectDto object) {
        // When the form is submitted from /project/create, the status field is not included in the form.
        // This means that the ProjectDto created from form binding will have a null value for projectStatus.
        // However, the Thymeleaf template tries to render projectStatus.value in the project list table.
        // If projectStatus is null, calling .value on it will throw a Spring EL (SpEL) evaluation exception.
        // To prevent this, we assign a default status (OPEN) if the status was not set by the user.
        if (object.getProjectStatus() == null) {
            object.setProjectStatus(Status.OPEN);
        }

        return super.save(object.getProjectCode(), object);
    }

    @Override
    public List<ProjectDto> findAll() {
        return super.findAll();
    }

    @Override
    public void update(ProjectDto object) {
        super.update(object.getProjectCode(), object);
    }

    @Override
    public void deleteById(String id) {
        super.deleteById(id);
    }

    @Override
    public ProjectDto findById(String id) {
        return super.findById(id);
    }
}
