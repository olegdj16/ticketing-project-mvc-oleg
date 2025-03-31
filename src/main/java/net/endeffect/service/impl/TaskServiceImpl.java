package net.endeffect.service.impl;

import net.endeffect.dto.TaskDto;
import net.endeffect.dto.UserDto;
import net.endeffect.enums.Status;
import net.endeffect.service.TaskService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl extends AbstractMapService<TaskDto, Long> implements TaskService {

    @Override
    public TaskDto save(TaskDto object) {

        if (object.getTaskStatus() == null) {
            object.setTaskStatus(Status.OPEN);
        }

        if (object.getAssignedDate() == null) {
            object.setAssignedDate(LocalDate.now());
        }

        if (object.getId() == null) {
            object.setId(UUID.randomUUID().getMostSignificantBits());
        }

        return super.save(object.getId(), object);

    }

    @Override
    public List<TaskDto> findAll() {
        return super.findAll();
    }

    @Override
    public void update(TaskDto object) {

        TaskDto foundTask = findById(object.getId());

        object.setTaskStatus(foundTask.getTaskStatus());
        object.setAssignedDate(foundTask.getAssignedDate());

        super.update(object.getId(), object);

    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public TaskDto findById(Long id) {
        return super.findById(id);
    }

    @Override
    public List<TaskDto> findTasksByManager(UserDto manager) {
        return findAll().stream().filter(task -> task.getProject().getAssignedManager().equals(manager)).collect(Collectors.toList());
    }

    @Override
    public List<TaskDto> findAllTasksByStatus(Status status) {
        return findAll().stream().filter(task -> task.getTaskStatus().equals(Status.COMPLETED)).collect(Collectors.toList());
    }

    @Override
    public List<TaskDto> findAllTasksByStatusIsNot(Status status) {
        return findAll().stream().filter(task -> !task.getTaskStatus().equals(Status.COMPLETED)).collect(Collectors.toList());
    }

    @Override
    public void updateStatus(TaskDto task) {
        findById(task.getId()).setTaskStatus(task.getTaskStatus());
        update(task);
    }
}
