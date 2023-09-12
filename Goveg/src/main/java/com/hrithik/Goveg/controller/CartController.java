package com.hrithik.Goveg.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.hrithik.Goveg.model.ItemBean;

@Controller
public class CartController {
    private Map<String, List<ItemBean>> userCarts = new HashMap<>();

 /*   @GetMapping("/")
    public String showCart(Model model, Principal principal) {
        String username = principal.getName();
        List<ItemBean> cartItems = userCarts.getOrDefault(username, new ArrayList<>());
        model.addAttribute("cartItems", cartItems);
        model.addAttribute("username", username);
        return "cart";
    }
*/
    @PostMapping("/addItem")
    public String addItem(@ModelAttribute("item") ItemBean item, Principal principal) {
        String username = principal.getName();
        List<ItemBean> cartItems = userCarts.getOrDefault(username, new ArrayList<>());
        cartItems.add(item);
        userCarts.put(username, cartItems);
        return "redirect:/";
    }

    @PostMapping("/buy")
    public String buyItems(Principal principal) {
        String username = principal.getName();
        userCarts.remove(username);
        return "redirect:/";
    }

    @ModelAttribute("item")
    public ItemBean getItem() {
        return new ItemBean();
    }

    @ModelAttribute("totalPrice")
    public double getTotalPrice(Principal principal) {
        String username = principal.getName();
        List<ItemBean> cartItems = userCarts.getOrDefault(username, new ArrayList<>());
        double totalPrice = 0;
        for (ItemBean item : cartItems) {
            totalPrice += item.getItemPrice() * item.getIntemQty();
        }
        return totalPrice;
    }
}
