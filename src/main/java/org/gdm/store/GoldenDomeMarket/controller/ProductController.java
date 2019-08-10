package org.gdm.store.GoldenDomeMarket.controller;


import java.util.List;

import javax.validation.Valid;

import org.gdm.store.GoldenDomeMarket.model.Product;
import org.gdm.store.GoldenDomeMarket.model.Supplier;
import org.gdm.store.GoldenDomeMarket.service.ProductService;
import org.gdm.store.GoldenDomeMarket.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private SupplierService supplierService;
	
	@GetMapping(value = {"product/list"})
	public ModelAndView showListProduct(@RequestParam(defaultValue = "0") int pageNo) {
		
        ModelAndView mv = new ModelAndView();
        mv.addObject("products", productService.getAllProducts(pageNo));
        mv.addObject("currentPageNo", pageNo);
        mv.setViewName("product/list");
        
        return mv;
    }
	
	@GetMapping(value = {"/product/add"})
    public String newAccountForm(Model model) {
		
		Product product = new Product();
        List<Product> products = productService.getAllProducts();
        List<Supplier> suppliers = supplierService.getAllSuppliers();
        model.addAttribute("product", product);
       // model.addAttribute("products", products);
        model.addAttribute("suppliers", suppliers);
       
        return "product/add";
    }
	
	@PostMapping(value = {"/product/add"})
    public String addProduct(@Valid @ModelAttribute("product") Product product,
                                BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            System.out.println(bindingResult.getErrorCount());
            List<Supplier> suppliers = supplierService.getAllSuppliers();            
            model.addAttribute("suppliers", suppliers);
            return "product/add";
        }
        
        product = productService.addNewProduct(product);
        return "redirect:/product/list";
    }

}
