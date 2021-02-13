package ru.karin.nc.hw3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.karin.nc.hw3.UserFileOperating;
import ru.karin.nc.hw3.component.EmailService;
import ru.karin.nc.hw3.model.Message;
import ru.karin.nc.hw3.model.User;
import ru.karin.nc.hw3.model.UserKey;

import java.io.IOException;

@Controller
public class EmailController {

    @Autowired
    EmailService emailService;

    @GetMapping("/sendMessage")
    public String getMessageForm(@ModelAttribute UserKey uk, Model model) {
        try {
            User user = UserFileOperating.FindUser(uk);
            model.addAttribute("user", user);
            Message ms = new Message();
            ms.setEmail(user.getEmail());
            model.addAttribute("message", ms);
            return "sendMessage";
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return "error";
    }

    @PostMapping("/sendMessage")
    public String sendMessage(@ModelAttribute Message message) {
        System.out.println(message.getEmail());
        emailService.sendSimpleMessage(message.getEmail(), message.getSubject(), message.getText());
        return "success";
    }
}
