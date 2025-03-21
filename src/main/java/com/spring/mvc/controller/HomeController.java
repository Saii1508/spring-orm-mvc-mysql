package com.spring.mvc.controller;


import com.spring.mvc.model.Products;
import com.spring.mvc.service.ProductService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private ProductService productService;

    @RequestMapping("/")
    public String homePage(Model model) {
        System.out.println("Home page is hit");
        List<Products> allProducts = productService.getProducts();
        model.addAttribute("products",allProducts);
        return "home";
    }

    @RequestMapping("/remove-product/{id}")
    public RedirectView removeProduct(@PathVariable("id") int id, HttpServletRequest request) {
        productService.removeProduct(id);
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl(request.getContextPath()+"/");
        return redirectView;
    }

 /*   @RequestMapping("/update-product/{id}")
    public RedirectView updateProduct(@PathVariable("id") int id, HttpServletRequest request) {
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl(request.getContextPath()+"/add-product");

        return redirectView;
    }*/

    @RequestMapping("/update/{id}")
    public String updateProduct(@PathVariable("id") int id, Model model) {
        Products products = productService.getOneProduct(id);
        model.addAttribute("product",products);
        return "update-Product";
    }

    @RequestMapping("/add-product")
    public String addPage() {
        System.out.println("adding product page is hit");
        return "addProduct";
    }

    @RequestMapping("/view-products")
    public String productsPage(Model model) {
        System.out.println("Products page is hit");
        List<Products> getAll = productService.getProducts();
        model.addAttribute("products",getAll);
        return "view-Products";
    }

    @RequestMapping(value = "/process-form", method = RequestMethod.POST)
    public RedirectView handleProduct(@ModelAttribute Products products, HttpServletRequest request) {
        System.out.println("Processing page is hit");
        System.out.println(products);
        productService.saveProduct(products);
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl(request.getContextPath()+"/view-products");
        return redirectView;
    }
}
