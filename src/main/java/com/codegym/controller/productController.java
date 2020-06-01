package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.IProductService;
import com.codegym.service.productService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class productController {
    private IProductService productService = new productService();

    @GetMapping("/")
    public String showList(Model model) {
        List<Product> list = productService.findAll();
        model.addAttribute("list", list);
        return "index";
    }

    @GetMapping("product/create")
    public ModelAndView ShowCreateProduct() {
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("product", new Product());
        return modelAndView;
    }

    @PostMapping("/product/save")
    public ModelAndView createProduct(@ModelAttribute Product product) {
        ModelAndView modelAndView = new ModelAndView("/index");
        int size = productService.findAll().size();
        size++;
        product.setId(size);
        productService.Save(product);
        modelAndView.addObject("list", productService.findAll());
        return modelAndView;
    }

    @GetMapping("/product/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.getProductById(id));
        return "/edit";
    }

    @PostMapping("product/update")
    public String update(Product product, RedirectAttributes redirectAttributes) {
        productService.update(product.getId(), product);
        redirectAttributes.addFlashAttribute("success", "update success");
        return "redirect:/";
    }

    @GetMapping("/product/{id}/delete")
    public String delete(@PathVariable int id, RedirectAttributes redirectAttributes) {
        productService.delete(id);
        redirectAttributes.addFlashAttribute("success", "delete success");
        return "redirect:/";
    }
}
