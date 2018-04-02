package net.sportlife.service;

import net.sportlife.model.bookingCart.Cart;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CartService {
    public List<Cart> getCartList();
}
