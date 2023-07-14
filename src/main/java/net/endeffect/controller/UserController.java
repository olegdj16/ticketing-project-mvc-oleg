package net.endeffect.controller;

import net.endeffect.dto.UserDTO;
import net.endeffect.service.RoleService;
import net.endeffect.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    RoleService roleService;
    UserService userService;

    public UserController(RoleService roleService, UserService userService) {
        this.roleService = roleService;
        this.userService = userService;
    }

    @GetMapping("/create")
    public String createUser(Model model){

        model.addAttribute("user", new UserDTO()); // will communicate with UI
        model.addAttribute("roles", roleService.findAll()); // bring me all roles from the Database

        model.addAttribute("users", userService.findAll());

//        model.addAttribute("roles", R)

        return "/user/create";
    }



}
