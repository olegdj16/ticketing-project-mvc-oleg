package net.endeffect.service.impl;

import net.endeffect.dto.ProjectDto;
import net.endeffect.service.ProjectService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl extends AbstractMapService<ProjectDto, String> implements ProjectService {

    @Override
    public ProjectDto save(ProjectDto object) {
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
