package com.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.entity.User;
import com.springmvc.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public ModelAndView listUsers(Model model) {
        model.addAttribute("users", userService.list());
        ModelAndView m = new ModelAndView();
        m.setViewName("user-list");
        return m;
    }

    @GetMapping("/form")
    public String userForm(Model model) {
    	User user = new User();
        model.addAttribute("user", user);
        return "user-form";
    }

    @PostMapping("/save")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/user/list";
    }

    @GetMapping("/edit/{id}")
    public String editUser(@PathVariable int id, Model model) {
        model.addAttribute("user", userService.get(id));
        return "user-form";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable int id) {
        userService.delete(id);
        return "redirect:/user/list";
    }
}

