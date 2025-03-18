package net.endeffect.controller;

import net.endeffect.dto.RoleDto;
import net.endeffect.dto.UserDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @GetMapping("/create")
    public String userCreate(Model model) {

        model.addAttribute("user", new UserDto());

//        model.addAttribute("role", LIST_OF_ROLES);


        return "/user/create";
    }
}
