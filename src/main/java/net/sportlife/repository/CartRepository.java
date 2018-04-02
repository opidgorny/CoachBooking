package net.sportlife.repository;

import net.sportlife.model.bookingCart.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
}
