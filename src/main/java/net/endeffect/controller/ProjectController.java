package net.endeffect.controller;

import net.endeffect.dto.ProjectDto;
import net.endeffect.dto.UserDto;
import net.endeffect.service.ProjectService;
import net.endeffect.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/project")
public class ProjectController {

    ProjectService projectService;
    UserService userService;

    public ProjectController(ProjectService projectService, UserService userService) {
        this.projectService = projectService;
        this.userService = userService;
    }

    // step 1
    // step 2: then, go update the left-sidebar.html to include a link to /project/create
    @GetMapping("/create")
    public String projectCreate(Model model) {

        model.addAttribute("project", new ProjectDto());
        model.addAttribute("projects", projectService.findAll());
        model.addAttribute("managers", userService.findManagers());

        return "/project/create";
    }

    // This method handles the form submission for creating a project
    @PostMapping("/create")
    public String projectCreate(ProjectDto project) {

        // Save the project using the projectService
        projectService.save(project);

        // Redirect to the project creation page to display the updated list of projects
        return "redirect:/project/create";
    }

    @GetMapping("/delete/{projectCode}")
    public String deleteProject(@PathVariable("projectCode") String projectCode) {
        projectService.deleteById(projectCode);
        return "redirect:/project/create";

    }

    @GetMapping("/complete/{projectCode}")
    public String completeProject(@PathVariable("projectCode") String projectCode) {
        projectService.complete(projectService.findById(projectCode));
        return "redirect:/project/create";
    }

    @GetMapping("/update/{projectCode}")
    public String editProject(@PathVariable("projectCode") String projectCode, Model model) {

        model.addAttribute("project", projectService.findById(projectCode));
        model.addAttribute("projects", projectService.findAll());
        model.addAttribute("managers", userService.findManagers());

        return "/project/update";
    }

    @PostMapping("/update/")
    public String updateProject(ProjectDto project) {
        projectService.update(project);
        return "redirect:/project/create";
    }

    // sart @01:00:10 part 5 mvc
    @GetMapping("/manager/project-status")
    public String getProjectByManager(Model model) {

        // 17 Ticketing Project MVC Part5 @01:01:38
        UserDto manager = userService.findById("john@endeffects.com");

        List<ProjectDto> projects = projectService.getCountedListOfProjectDTO(manager);

        model.addAttribute("projects", projects);

        return "/manager/project-status";
    }

}
