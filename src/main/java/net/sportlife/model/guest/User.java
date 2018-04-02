package net.sportlife.model.guest;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.*;

@Entity
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Long id;

    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "date_of_birth")
    private Date dateOfBirth;
    @Column(name = "sex")
    private String sex;
    @Column(name = "city") //Should city be the type of City? Or just String (just a constraint)
    private String city;
    @Column(name = "club")
    private String club;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(
                    name = "user_id", referencedColumnName = "user_id"),
            inverseJoinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "role_id"))
    private Collection<Role> roles;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "card_id")
//    private Card cardId;

    private Long cardId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) &&
                Objects.equals(email, user.email) &&
                Objects.equals(password, user.password) &&
                Objects.equals(firstName, user.firstName) &&
                Objects.equals(lastName, user.lastName) &&
                Objects.equals(dateOfBirth, user.dateOfBirth) &&
                Objects.equals(sex, user.sex) &&
                Objects.equals(city, user.city) &&
                Objects.equals(club, user.club) &&
                roles == user.roles &&
                Objects.equals(cardId, user.cardId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, email, password, firstName, lastName, dateOfBirth, sex, city, club, roles, cardId);
    }
}
