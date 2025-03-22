package net.endeffect.controller;

import net.endeffect.dto.RoleDto;
import net.endeffect.dto.UserDto;
import net.endeffect.service.RoleService;
import net.endeffect.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {

    // we need to inject
    RoleService roleService;
    UserService userService;

    public UserController(RoleService roleService, UserService userService) {
        this.roleService = roleService;
        this.userService = userService;
    }

    @GetMapping("/create")
    public String userCreate(Model model) {

        model.addAttribute("user", new UserDto());
        model.addAttribute("roles", roleService.findAll());
        model.addAttribute("users", userService.findAll());

        return "/user/create";
    }



    // Version 1 of insertUser
//    /**
//     * @PostMapping("/create"): Maps the method to handle POST requests to /user/create.
//     * @ModelAttribute("user") UserDto user: Binds the form data to a UserDto object.
//     * userService.save(user): Saves the user.
//     * model.addAttribute("user", new UserDto()): Adds an empty UserDto object to the model for the form.
//     * model.addAttribute("roles", roleService.findAll()): Adds the list of roles to the model.
//     * model.addAttribute("users", userService.findAll()): Adds the list of users to the model.
//     * return "/user/create": Returns the view name for the user creation form.
//     * @param user
//     * @param model
//     * @return
//     */
//    @PostMapping("/create")
//    public String insertUserDeprecate(UserDto user, Model model){
//
//        // need this: after save, you need an empty form back. this will provide an empty object
//        model.addAttribute("user", new UserDto());
//
//        // The line model.addAttribute("roles", roleService.findAll()); is necessary to populate the roles attribute in the
//        // model with a list of all roles retrieved from the RoleService. This list is then used in the Thymeleaf template to
//        // display the available roles in a dropdown menu for the user to select from when creating a new user.
//        model.addAttribute("roles", roleService.findAll());
//
//        userService.save(user);
//        model.addAttribute("users", userService.findAll());
//
//        return "/user/create";
//    }

    // Version 2 of insertUser using redirect
    @PostMapping("/create")
    public String insertUser(UserDto user, Model model){

        userService.save(user);

        return "redirect:/user/create";
    }

    @GetMapping("/update/{username}")
    public String editUser(@PathVariable("username") String username, Model model) {

        model.addAttribute("user", new UserDto());
        model.addAttribute("roles", roleService.findAll());
        model.addAttribute("users", userService.findAll());

        return "/user/update";
    }

}
