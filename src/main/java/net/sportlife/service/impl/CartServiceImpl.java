package net.sportlife.service.impl;

import net.sportlife.model.bookingCart.Cart;
import net.sportlife.service.CartService;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.List;

@Service(value = "cartService")
public class CartServiceImpl implements CartService {

    public List<Cart> getCartList() {
//        List<>
        Cart cart = new Cart((long) 1, "Alex", "Pidgorny", 5000l);
        return Arrays.asList(cart);
    }

}
