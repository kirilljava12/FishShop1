package com.example.fishshop1.controllers;

import com.example.fishshop1.enums.TypeEnum;
import com.example.fishshop1.models.ItemModel;
import com.example.fishshop1.repos.ItemRepo;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.jws.WebParam;
import javax.persistence.Column;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/item")
public class ItemController {

    @Autowired
    ItemRepo itemRepo;

    @GetMapping("/fishing")
    public String getFishing(Model model){
        List<ItemModel> list;
        list = itemRepo.findAllByTypeEnumAndIfActual(TypeEnum.FISHING, true);
        model.addAttribute("items", list);
        return "forFishing";
    }
    @GetMapping("/hunting")
    public String getHunt(Model model){
        List<ItemModel> list;
        list = itemRepo.findAllByTypeEnumAndIfActual(TypeEnum.HUNTING, true);
        model.addAttribute("items", list);
        return "forHunting";
    }
    @GetMapping("/tourism")
    public String getT(Model model){
        List<ItemModel> list;
        list = itemRepo.findAllByTypeEnumAndIfActual(TypeEnum.TOURISM, true);
        model.addAttribute("items", list);
        return "fotTourism";
    }
    @GetMapping("/boats")
    public String getB(Model model){
        List<ItemModel> list;
        list = itemRepo.findAllByTypeEnumAndIfActual(TypeEnum.BOATS, true);
        model.addAttribute("items", list);
        return "boats";
    }
    @GetMapping("/forboats")
    public String getFB(Model model){
        List<ItemModel> list;
        list = itemRepo.findAllByTypeEnumAndIfActual(TypeEnum.FOR_BOATS, true);
        model.addAttribute("items", list);
        return "forBoats";
    }
    @GetMapping("/food")
    public String getF(Model model){
        List<ItemModel> list;
        list = itemRepo.findAllByTypeEnumAndIfActual(TypeEnum.FOOD, true);
        model.addAttribute("items", list);
        return "food";
    }
}
