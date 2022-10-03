package com.garage.controller;

import com.garage.model.Garage;
import com.garage.model.Visitor;
import com.garage.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@org.springframework.stereotype.Controller
public class Controller {

    @Autowired
    private Service service;

    @GetMapping("/")
    public String homepage(Model model){
        model.addAttribute("visitor",new Visitor());
        return "index";
    }

    @GetMapping("/showGarages")
    public String showDashboard(Model model){
        model.addAttribute("GarageList",service.getAllGarages());
        return "garagelist";
    }

    @GetMapping("/showNewGarageForm")
    public String showNewGarageForm(Model model){
        Garage garage = new Garage();
        model.addAttribute("garage",garage);
        return "new_garage";
    }

    @PostMapping("/saveGarage")
    public String saveGarage(@ModelAttribute("garage") Garage garage){
        service.saveGarage(garage);
        return "redirect:/showGarages";
    }
    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable("id") int id, Model model){
        Garage garage = service.getGarageById(id);
        model.addAttribute("garage",garage);
        return "update_garage";
    }

    @GetMapping("/deleteGarage/{id}")
    public String deleteGarage(@PathVariable("id") int id){
        service.deleteGarage(id);
        return "redirect:/showGarages";
    }

    //visitor code starts ########################################

    @PostMapping("/saveVisitor")
    public String saveVisitor(@ModelAttribute("visitor") Visitor visitor){
        service.saveVisitor(visitor);
        return "redirect:/";
    }

    @GetMapping("/deleteVisitor/{id}")
    public String deleteVisitor(@PathVariable("id") int id){
        service.deleteVisitor(id);
        return "redirect:/showDashboard";
    }

    @GetMapping("/showDashboard")
    public String showVisitor(Model model){
        model.addAttribute("VisitorList",service.getAllVisitors());
        return "visitorlist";
    }
}
