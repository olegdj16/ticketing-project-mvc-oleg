package net.endeffect.service.impl;

import net.endeffect.dto.ProjectDto;
import net.endeffect.dto.TaskDto;
import net.endeffect.dto.UserDto;
import net.endeffect.enums.Status;
import net.endeffect.service.ProjectService;
import net.endeffect.service.TaskService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectServiceImpl extends AbstractMapService<ProjectDto, String> implements ProjectService {

    private final TaskService taskService;

    public ProjectServiceImpl(TaskService taskService) {
        this.taskService = taskService;
    }

    @Override
    public ProjectDto save(ProjectDto object) {

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

        ProjectDto newproject = findById(object.getProjectCode());

        if (object.getProjectStatus() == null)
            object.setProjectStatus(newproject.getProjectStatus());
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

    @Override
    public void complete(ProjectDto project) {
        project.setProjectStatus(Status.COMPLETED);
        super.save(project.getProjectCode(), project);
    }

    @Override
    public List<ProjectDto> findAllNonCompletedProjects() {
        return findAll().stream().filter(project -> !project.getProjectStatus().equals(Status.COMPLETED)).collect(Collectors.toList());
    }

    @Override
    public List<ProjectDto> getCountedListOfProjectDTO(UserDto manager) {
        // Get all projects assigned to the manager
        return findAll().stream()
                .filter(project -> project.getAssignedManager().equals(manager)) // Part 1: filter projects by manager
                .map(project -> {
                    // Part 2: get all tasks assigned to the manager
                    List<TaskDto> taskList = taskService.findTasksByManager(manager);

                    // Count completed tasks for this project
                    int completeTaskCounts = (int) taskList.stream()
                            .filter(t -> t.getProject().equals(project) && t.getTaskStatus() == Status.COMPLETED)
                            .count();

                    // Count unfinished tasks for this project
                    int unfinishedTaskCounts = (int) taskList.stream()
                            .filter(t -> t.getProject().equals(project) && t.getTaskStatus() != Status.COMPLETED)
                            .count();

                    // Set task counts in the project DTO
                    project.setCompleteTaskCounts(completeTaskCounts);
                    project.setUnfinishedTaskCounts(unfinishedTaskCounts);

                    return project; // Return the updated project
                })
                .collect(Collectors.toList()); // Collect and return the list
    }


}
