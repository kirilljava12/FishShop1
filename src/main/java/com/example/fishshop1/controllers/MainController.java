package com.example.fishshop1.controllers;

import com.example.fishshop1.models.ItemModel;
import com.example.fishshop1.repos.ItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class MainController {
    @Autowired
    ItemRepo itemRepo;

    @GetMapping
    public String getMainPage(Model model){
        List<ItemModel> list = itemRepo.findAll();
        model.addAttribute("items", list);
        return "index";
    }
}
