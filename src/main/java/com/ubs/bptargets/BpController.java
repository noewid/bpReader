package com.ubs.bptargets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BpController {

    @Autowired
    private BpService service;
    @Autowired
    private BpRepository repository;

    @RequestMapping("/setData")
    String setData(Model model) {
        service.saveCsv();
        model.addAttribute("bp", repository.findAll());
        return "page";
    }

    @GetMapping("/home")
    String home(Model model) {
        model.addAttribute("bp", repository.findAll());
        return "page";
    }
}
