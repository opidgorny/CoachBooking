package net.sportlife.controller;

import net.sportlife.model.coach.CoachEntity;
import net.sportlife.service.CartService;
import net.sportlife.service.CoachService;
import net.sportlife.service.UserService;
import net.sportlife.service.impl.CoachServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/authenticated")
public class RegisteredUserController {

    @Autowired
    private UserService userService;

    @Autowired
    private CoachService coachService;

    @Autowired
    private CartService cartService;

    @RequestMapping("/coaches")
    public String coachList(Model model) {
        model.addAttribute("coaches", coachService.getAllCoaches());
        return "authenticated";
    }

    @RequestMapping("/coaches/{id}")
    public String getCoachById(@PathVariable Long id, Model model) {
        model.addAttribute("coach", coachService.getCoachById(id));

        return "coach";
    }

//    @RequestMapping("/bookingCart")
//    public String bookingCart(Model model) {
//        model.addAttribute("listCart", cartService.getCartList());
//        return "bookingCart";
//    }




}
