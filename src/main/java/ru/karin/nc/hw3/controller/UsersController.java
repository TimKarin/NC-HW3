package ru.karin.nc.hw3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import ru.karin.nc.hw3.UserFileOperating;
import ru.karin.nc.hw3.model.UserKey;
import java.io.*;

@Controller
public class UsersController {


    @GetMapping("/")
    public String UserForm(Model model) {
        model.addAttribute("uk", new UserKey());
        return "index";
    }

    @GetMapping("/delete")
    public String deleteUser(@ModelAttribute UserKey uk) {
        try {
            UserFileOperating.deleteUser(uk.getFirstName(), uk.getLastName());
            return "success";
        } catch(IOException ex) {
            ex.printStackTrace();
        }
        return "error";
    }


//    @GetMapping("/userInfo")
//    public String findUser(@ModelAttribute UserKey uk, Model model) {
//        try {
//            User user = UserFileOperating.FindUser(uk.getFirstName(), uk.getLastName());
//            if (user != null) {
//                model.addAttribute("user", user);
//            } else {
//                return "NotFound";
//            }
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }
//        return "userInfo";
//    }


}
