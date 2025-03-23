package net.endeffect.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/project")
public class ProjectController {

    // step 1
    // step 2: then, go update the left-sidebar.html to include a link to /project/create
    @GetMapping("/create")
    public String projectCreate() {
        return "/project/create";
    }
}
