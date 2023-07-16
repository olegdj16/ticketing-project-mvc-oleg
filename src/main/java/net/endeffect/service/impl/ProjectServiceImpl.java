package net.endeffect.service.impl;

import net.endeffect.dto.ProjectDTO;
import net.endeffect.enums.Status;
import net.endeffect.service.ProjectService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl extends AbstractMapService<ProjectDTO, String> implements ProjectService {

    @Override
    public ProjectDTO save(ProjectDTO object) {

        if(object.getProjectStatus() == null){
            object.setProjectStatus(Status.OPEN);
        }
        return super.save(object.getProjectCode(), object);
    }

    @Override
    public List<ProjectDTO> findAll() {
        return super.findAll();
    }

    @Override
    public void update(ProjectDTO object) {

        // here i capture my object from the map
        ProjectDTO newproject = findById(object.getProjectCode());

        if(object.getProjectStatus() == null){
            object.setProjectStatus(newproject.getProjectStatus());
        }
        super.update(object.getProjectCode(), object);


    }

    @Override
    public void deleteById(String id) {
        super.deleteById(id);

    }

    @Override
    public ProjectDTO findById(String id) {
        return super.findById(id);
    }

    @Override
    public void complete(ProjectDTO project) {
        project.setProjectStatus(Status.COMPLETE);
        super.save(project.getProjectCode(), project);
    }
}
