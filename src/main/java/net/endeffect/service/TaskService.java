package net.endeffect.service;

import net.endeffect.dto.TaskDto;
import net.endeffect.dto.UserDto;
import net.endeffect.enums.Status;

import java.util.List;

public interface TaskService extends CrudService<TaskDto, Long> {

    List<TaskDto> findTasksByManager(UserDto manager);

    List<TaskDto> findAllTasksByStatus(Status status);

    List<TaskDto> findAllTasksByStatusIsNot(Status status);

    void updateStatus(TaskDto task);

}
