package com.example.fishshop1.controllers;

import com.example.fishshop1.models.ClientModel;
import com.example.fishshop1.models.ItemModel;
import com.example.fishshop1.repos.ClientRepo;
import com.example.fishshop1.repos.ItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/detailitem")
public class DetailItemController {
    @Autowired
    ItemRepo itemRepo;

    @Autowired
    ClientRepo clientRepo;

    @GetMapping("/{id}")
    public String getDetailPage(@PathVariable(value = "id") long id,
                                Model model){
        Optional<ItemModel> optional = itemRepo.findById(id);
        List<ItemModel> list = new ArrayList<>();
        optional.ifPresent(list::add);
        model.addAttribute("item", list);
        return "detail";
    }
    @PostMapping("/{id}")
    public RedirectView saveData(@PathVariable(value = "id") long id,
                                 @RequestParam String name,
                                 @RequestParam String contact){
        ClientModel clientModel = new ClientModel();
        clientModel.setName(name);
        clientModel.setContact(contact);
        clientModel.setItem(String.valueOf(id));
        clientModel.setActual(true);
        clientRepo.save(clientModel);
        return new RedirectView("/");
    }
}
