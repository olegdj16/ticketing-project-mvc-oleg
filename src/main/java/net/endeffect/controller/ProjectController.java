package net.endeffect.controller;

import net.endeffect.dto.ProjectDTO;
import net.endeffect.service.ProjectService;
import net.endeffect.service.RoleService;
import net.endeffect.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/project")
public class ProjectController {

    ProjectService projectService;
    RoleService roleService;
    UserService userService;

    public ProjectController(ProjectService projectService, RoleService roleService, UserService userService) {
        this.projectService = projectService;
        this.roleService = roleService;
        this.userService = userService;
    }

    @GetMapping("/create")
    public String createProject(Model model){

        model.addAttribute("project", new ProjectDTO());
        model.addAttribute("projects", projectService.findAll()); // bring me all roles from the Database
        model.addAttribute("managers", userService.findAll());


/*
Project Name
Project Code
Assigned Manager
Project Start Date
Project End Date
Project Detail
 */
        return "/project/create";

    }
}
