package com.springexercise.springexercise.controller;

import com.springexercise.springexercise.entity.Users;
import com.springexercise.springexercise.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/users")
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserController {

    private final UserRepo userRepo;

    @PostMapping(value = "/register", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Users registerUser(@RequestBody Users user) {
        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
        Users save = userRepo.save(user);
        return save;
    }

    @GetMapping("/user")
    public String register(Model model) {
        List<Users> all = userRepo.findAll();
        model.addAttribute("users",all);
        return "User";
    }

    @GetMapping("/send-mail")
    public boolean sendEmail(){
        return "Email";
    }


}
