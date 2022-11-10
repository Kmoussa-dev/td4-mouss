package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import services.Facade;

@Controller
@RequestMapping("/")
public class Exercice3Controller {
    @Autowired
    Facade facade;
    @RequestMapping("")
    public String hello(Model model) {
        model.addAttribute("plusgrosseVente",facade.plusGrosseVenteMontant());
        return("hello");
    }

}
