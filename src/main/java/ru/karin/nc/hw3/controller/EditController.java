//package ru.karin.nc.hw3.controller;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import ru.karin.nc.hw3.UserFileOperating;
//import ru.karin.nc.hw3.model.User;
//import ru.karin.nc.hw3.model.UserKey;
//
//import java.io.IOException;
//
//@Controller
//public class EditController {
//
//    @GetMapping("/edit")
//    public String getEditForm(@ModelAttribute UserKey key, Model model) {
//        try {
//            User finded = UserFileOperating.FindUser(key.getFirstName(), key.getLastName());
//            if (finded != null) {
//                model.addAttribute("user", finded);
//            } else {
//                return "NotFound";
//            }
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }
//        return "edit";
//    }
//
//    @PostMapping("/edit")
//    public String editUser(@ModelAttribute User user) {
//        try{
//            UserFileOperating.AddUser(user);
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }
//        return "userInfo";
//    }
//
//}
