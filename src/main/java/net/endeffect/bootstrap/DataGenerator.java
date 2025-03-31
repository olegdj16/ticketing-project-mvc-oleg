package net.endeffect.bootstrap;

import net.endeffect.dto.ProjectDto;
import net.endeffect.dto.RoleDto;
import net.endeffect.dto.TaskDto;
import net.endeffect.dto.UserDto;
import net.endeffect.enums.Gender;
import net.endeffect.enums.Status;
import net.endeffect.service.ProjectService;
import net.endeffect.service.RoleService;
import net.endeffect.service.TaskService;
import net.endeffect.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataGenerator implements CommandLineRunner {

    RoleService roleService;
    UserService userService;
    ProjectService projectService;
    TaskService taskService;

    public DataGenerator(RoleService roleService, UserService userService, ProjectService projectService, TaskService taskService) {
        this.roleService = roleService;
        this.userService = userService;
        this.projectService = projectService;
        this.taskService = taskService;
    }

    @Override
    public void run(String... args) throws Exception {

        RoleDto adminRole = new RoleDto(1L, "Admin");
        RoleDto managerRole = new RoleDto(2L, "Manager");
        RoleDto employeeRole = new RoleDto(3L, "Employee");

        roleService.save(adminRole);
        roleService.save(managerRole);
        roleService.save(employeeRole);

        UserDto user1 = new UserDto("John", "Kesy", "john@endeffects.com", "Abc2", true, "7459684532", managerRole, Gender.MALE);
        UserDto user5 = new UserDto("Mike", "Smith", "mike@endeffects.com", "Abc2", true, "7459684532", adminRole, Gender.MALE);
        UserDto user2 = new UserDto("Delisa", "Moore", "delisa@endeffects.com", "123", true, "8567412358", managerRole, Gender.FEMALE);
        UserDto user3 = new UserDto("Craig", "Jack", "craig@endeffects.com", "Abc4", true, "7777775566", employeeRole, Gender.MALE);
        UserDto user4 = new UserDto("Shaun", "Hayes", "shaun@endeffects.com", "Abc4", true, "3256987412", managerRole, Gender.MALE);
        UserDto user6 = new UserDto("Elizabeth", "Loren", "elizabeth@endeffects.com", "Abc4", true, "5306987412", employeeRole, Gender.FEMALE);
        UserDto user7 = new UserDto("Maria", "Ad", "maria@endeffects.com", "Abc4", true, "9996987412", employeeRole, Gender.FEMALE);
        UserDto user8 = new UserDto("Bill", "Matt", "bill@endeffects.com", "Abc4", true, "8881239846", employeeRole, Gender.MALE);

        // here we are saving the user in the map
        userService.save(user1);
        userService.save(user2);
        userService.save(user3);
        userService.save(user4);
        userService.save(user5);
        userService.save(user6);
        userService.save(user7);
        userService.save(user8);

        ProjectDto project1 = new ProjectDto("Spring MVC", "PR001", user1, LocalDate.now(), LocalDate.now().plusDays(25), "Creating Controllers", Status.OPEN);
        ProjectDto project2 = new ProjectDto("Spring ORM", "PR002", user2, LocalDate.now(), LocalDate.now().plusDays(10), "Creating Database", Status.IN_PROGRESS);
        ProjectDto project3 = new ProjectDto("Spring Container", "PR003", user1, LocalDate.now(), LocalDate.now().plusDays(32), "Creating Container", Status.IN_PROGRESS);

        projectService.save(project1);
        projectService.save(project2);
        projectService.save(project3);

        TaskDto task1 = new TaskDto(project1, user8, "Controller", "Request Mapping", Status.IN_PROGRESS, LocalDate.now());
        TaskDto task2 = new TaskDto(project3, user3, "Configuration", "Database Connection", Status.COMPLETED, LocalDate.now());
        TaskDto task3 = new TaskDto(project3, user6, "Mapping", "One-To-Many", Status.COMPLETED, LocalDate.now());
        TaskDto task4 = new TaskDto(project2, user7, "Dependency Injection", "Autowired", Status.IN_PROGRESS, LocalDate.now());

        taskService.save(task1);
        taskService.save(task2);
        taskService.save(task3);
        taskService.save(task4);


    }
}
