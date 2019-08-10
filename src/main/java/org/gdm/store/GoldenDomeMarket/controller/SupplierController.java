package org.gdm.store.GoldenDomeMarket.controller;

import org.gdm.store.GoldenDomeMarket.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SupplierController {
	
	@Autowired
	private SupplierService supplierService;

	
	@GetMapping(value = {"/supplier/list"})
    public ModelAndView showListSupplier(@RequestParam(defaultValue = "0") int pageNo) {
		
        ModelAndView mv = new ModelAndView();
        mv.addObject("suppliers", supplierService.getAllSuppliers(pageNo));
        mv.addObject("currentPageNo", pageNo);
        mv.setViewName("supplier/list");
        
        return mv;
    }
}
