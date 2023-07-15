package net.endeffect.controller;

import net.endeffect.dto.UserDTO;
import net.endeffect.service.RoleService;
import net.endeffect.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/create")
    public String insertUser(@ModelAttribute("user") UserDTO user, Model model){

//        model.addAttribute("user", new UserDTO()); // this will give empty object after save: user
//        model.addAttribute("roles", roleService.findAll()); // bring me all roles from the Database

        userService.save(user);
//        model.addAttribute("users", userService.findAll());


        return "redirect:/user/create";
    }

    @GetMapping("/update/{username}")
    public String editUser(@PathVariable("username") String username, Model model){

        model.addAttribute("user", new UserDTO()); // will communicate with UI
        model.addAttribute("roles", roleService.findAll()); // bring me all roles from the Database
        model.addAttribute("users", userService.findAll());




        return "/user/update";


    }



}
