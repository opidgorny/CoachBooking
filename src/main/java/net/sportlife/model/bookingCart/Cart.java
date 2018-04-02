package net.sportlife.model.bookingCart;

import lombok.Getter;
import lombok.Setter;
import net.sportlife.model.coach.CoachEntity;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Getter
@Setter
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cart_id")
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;
//    private Date dateOfBooking;
    @Column(name = "hour_price")
    private Long hourPrice;

    public Cart() {
    }

    public Cart(Long id, String firstName, String lastName, Long hourPrice) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
//        this.dateOfBooking = dateOfBooking;
        this.hourPrice = hourPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cart cart = (Cart) o;
        return Objects.equals(id, cart.id) &&
                Objects.equals(firstName, cart.firstName) &&
                Objects.equals(lastName, cart.lastName) &&
//                Objects.equals(dateOfBooking, cart.dateOfBooking) &&
                Objects.equals(hourPrice, cart.hourPrice);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, firstName, lastName, hourPrice);
    }

    public void ToCart(CoachEntity coachEntity) {
        this.id = coachEntity.getId();
        this.firstName = coachEntity.getCoachName();
        this.lastName = coachEntity.getLastName();
        this.hourPrice = coachEntity.getHourPrice();
//        this.dateOfBooking = (Date) coachEntity.getDates();
    }
}
