package com.example.webpos.web;

import com.example.webpos.biz.PosService;
import com.example.webpos.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class PosController {

    private PosService posService;

    @Autowired
    public void setPosService(PosService posService) {
        this.posService = posService;
    }

    @GetMapping("/")
    public String pos(Model model) {
        model.addAttribute("products", posService.products());
        model.addAttribute("cart", posService.getCart());
        return "index";
    }

    @GetMapping("/itemAdd={id}")
    public String cartAdd(@PathVariable("id") String id, Model model) {
        posService.edit(id, 1);
        return "redirect:/";
    }

    @GetMapping("/itemSub={id}")
    public String cartSub(@PathVariable("id") String id, Model model) {
        posService.edit(id, -1);
        return "redirect:/";
    }

    @GetMapping("/add={id}")
    public String add(@PathVariable("id") String id, Model model) {
        posService.add(id, 1);
        return "redirect:/";
    }

    @GetMapping("/del={id}")
    public String del(@PathVariable("id") String id, Model model) {
        posService.del(id);
        return "redirect:/";
    }

    @GetMapping("/cancel")
    public String empty(Model model) {
        posService.newCart();
        return "redirect:/";
    }

    @GetMapping("/checkout")
    public String checkout(Model model) {
        posService.checkout(posService.getCart());
        return "redirect:/";
    }
}
