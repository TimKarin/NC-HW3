package ru.karin.nc.hw3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.karin.nc.hw3.UserFileOperating;
import ru.karin.nc.hw3.model.User;
import ru.karin.nc.hw3.model.UserKey;

import java.io.IOException;

@Controller
public class FindUserController {

    @GetMapping("/findUser")
    public String getFindUserForm(Model model) {
        model.addAttribute("uk", new UserKey());
        return "findUser";
    }

    @PostMapping("/findUser")
    public String findUser(@ModelAttribute UserKey uk, Model model) {
        try {
            User user = UserFileOperating.FindUser(uk.getFirstName(), uk.getLastName());
            if (user != null) {
                model.addAttribute("user", user);
            } else {
                return "notFound";
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return "userInfo";
    }
}
