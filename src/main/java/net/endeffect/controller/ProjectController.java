package net.endeffect.controller;

import net.endeffect.dto.ProjectDto;
import net.endeffect.service.ProjectService;
import net.endeffect.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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

        projectService.save(project);

        return "redirect:/project/create";
    }

    @GetMapping("/delete/{projectCode}")
    public String deleteProject(@PathVariable("projectCode") String projectCode) {
        projectService.deleteById(projectCode);
        return "redirect:/project/create";

    }



}
