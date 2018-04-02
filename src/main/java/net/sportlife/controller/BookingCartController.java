package net.sportlife.controller;

import net.sportlife.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/authenticated/bookingCart")
public class BookingCartController {

    @Autowired
    private CartService cartService;

    @RequestMapping("")
    public String cartList(Model model) {
        model.addAttribute("cartList", cartService.getCartList());
        return "bookingCart";
    }
}
