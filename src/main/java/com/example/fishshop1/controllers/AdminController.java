package com.example.fishshop1.controllers;

import com.example.fishshop1.models.ClientModel;
import com.example.fishshop1.models.ItemModel;
import com.example.fishshop1.repos.ClientRepo;
import com.example.fishshop1.repos.ItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    ItemRepo itemRepo;

    @Autowired
    ClientRepo clientRepo;

    @GetMapping
    public String getAdminPage() {
        return "admin";
    }

    @GetMapping("/addItem")
    public String getAddPAge(){
        return "add";
    }
    @PostMapping("/addItem")
    public RedirectView saveItem(@RequestParam String title,
                                @RequestParam String disc,
                                 @RequestParam String photoUrl){
        ItemModel itemModel = new ItemModel();
        itemModel.setUrl(photoUrl);
        itemModel.setTitle(title);
        itemModel.setDisc(disc);
        itemRepo.save(itemModel);
        return new RedirectView("/admin");
    }
    @GetMapping("/checkClients")
    public String getClients(Model model){
        List<ClientModel> clientList = clientRepo.findClientModelsByActual(true);
        model.addAttribute("clientList", clientList);
        return "clients";
    }
    @GetMapping("/checkClients/notactual/{id}")
    public RedirectView notActual(@PathVariable(value = "id") long id){
        Optional<ClientModel> optional= clientRepo.findById(id);
        List<ClientModel> clientModels = new ArrayList<>();
        optional.ifPresent(clientModels::add);
        ClientModel clientModel = new ClientModel();
        clientModel = clientModels.get(0);
        clientModel.setActual(false);
        clientRepo.save(clientModel);
        return new RedirectView("/admin/checkClients");
    }
    @GetMapping("/checkNotActual")
    public String getNotActual(Model model){
        List<ClientModel> clientList = clientRepo.findClientModelsByActual(false);
        model.addAttribute("clientList", clientList);
        return "notactual";
    }
    @GetMapping("/checkNotActual/{id}")
    public RedirectView deleteFrom(@PathVariable(value = "id") long id){
        clientRepo.deleteById(id);
        return new RedirectView("/admin/checkNotActual");
    }
    @GetMapping("/checkItems")
    public String getAllItems(Model model){
        List<ItemModel> list = itemRepo.findAll();
        model.addAttribute("allItems", list);
        return "allItems";
    }
    @GetMapping("/checkItems/deleteItem/{id}")
    public RedirectView deleteItem(@PathVariable(value = "id") long id){
        itemRepo.deleteById(id);
        return new RedirectView("/admin/checkItems");
    }
    @GetMapping("/checkItems/editItem/{id}")
    public String editItemItem(@PathVariable(value = "id") long id,
                               Model model){
        Optional<ItemModel> itemModel = itemRepo.findById(id);
        List<ItemModel> list = new ArrayList<>();
        itemModel.ifPresent(list::add);
        model.addAttribute("model", list);
        return "edit";
    }
    @PostMapping("/checkItems/editItem/{id}")
    public RedirectView editPostItem(@PathVariable(value = "id") long id,
                                     @RequestParam String title,
                                     @RequestParam String disc,
                                     @RequestParam String url){
        Optional<ItemModel> itemModel = itemRepo.findById(id);
        List<ItemModel> list = new ArrayList<>();
        itemModel.ifPresent(list::add);
        ItemModel itemModel1 = list.get(0);
        itemModel1.setDisc(disc);
        itemModel1.setTitle(title);
        if (!url.equals("")&&url!=null)
            itemModel1.setUrl(url);
        itemRepo.save(itemModel1);
        return new RedirectView("/admin/checkItems");
    }
}
