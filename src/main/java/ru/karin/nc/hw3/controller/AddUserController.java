package ru.karin.nc.hw3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.karin.nc.hw3.UserFileOperating;
import ru.karin.nc.hw3.model.User;

import javax.validation.Valid;
import java.io.IOException;

@Controller
public class AddUserController {
    @GetMapping("/addUser")
    public String getAddForm (Model model){
        model.addAttribute("user", new User());
        return "addUser";
    }

    @PostMapping("/addUser")
    public String AddUser(@ModelAttribute @Valid User user, BindingResult br) {
        if (br.hasErrors())
            return "/addUser";
        try{
            UserFileOperating.AddUser(user);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return "userInfo";
    }

}
