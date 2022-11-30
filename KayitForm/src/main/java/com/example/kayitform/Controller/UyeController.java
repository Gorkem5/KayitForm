package com.example.kayitform.Controller;

import com.example.kayitform.Model.Uye;
import com.example.kayitform.Service.UyeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
@Controller
public class UyeController {
    @Autowired
    private UyeService service;

    @GetMapping("/")
    public String viewHomePage(Model model) {
        List<Uye> uyeList = service.listAll();
        model.addAttribute("listuye", uyeList);

        return "index";
    }

    @GetMapping("/new")
    public String add(Model model) {
        model.addAttribute("uye", new Uye());
        return "new";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveUye(@ModelAttribute Uye uye) {
        service.save(uye);
        return "redirect:/";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditUyePage(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("new");
        Uye uye = service.get(id);
        modelAndView.addObject("uye", uye);
        return modelAndView;

    }
    @RequestMapping("/delete/{id}")
    public String deleteUye(@PathVariable Long id) {
        service.delete(id);
        return "redirect:/";
    }
}
