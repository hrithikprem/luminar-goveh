package com.hrithik.Goveg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hrithik.Goveg.model.InvoiceBean;
import com.hrithik.Goveg.model.ItemBean;
import com.hrithik.Goveg.repository.InvoiceBeanRepository;
import com.hrithik.Goveg.repository.ItemRepository;

@Controller
public class ItemController {

    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private InvoiceBeanRepository invoiceBeanRepository;
    @GetMapping("/customer")
    public String showCustomerForm(Model model) {
        List<ItemBean> items = itemRepository.findAll();
        model.addAttribute("items", items);
        model.addAttribute("itemBean", new ItemBean());
        return "customer";
    }

    @PostMapping("/customer")
    public String saveItem(@RequestParam ("id") int Id,
    		@RequestParam ("itemname") String ItemName,
    		@RequestParam ("itemQty") float ItemQty,
    		@RequestParam ("itemPrice") float itmPrice) {
    	
    	InvoiceBean invoice=new InvoiceBean(ItemName, ItemQty,Id,itmPrice);
    	
    	invoice.setRegId(Id);
  
    	invoice.setItemName(ItemName);
    	invoice.setQty(ItemQty);
    	invoice.setItemprice(itmPrice);
    		invoiceBeanRepository.save(invoice);
    		return"redirect:/customer";
    }
    @GetMapping("/invoice")
	public String home() {
		return "invoice";
	}
    @PostMapping("/bill")
    public String generateBill(@RequestParam("id") int id, Model model) {
        List<InvoiceBean> items = invoiceBeanRepository.findByRegId(id);
        model.addAttribute("items", items);
        return "bill";
    }
  

}
