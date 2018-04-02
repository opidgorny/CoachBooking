package net.sportlife.dto;

import lombok.Getter;
import lombok.Setter;

import net.sportlife.constraint.FieldMatch;
import net.sportlife.model.guest.Card;
import net.sportlife.model.guest.Role;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Transient;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@FieldMatch.List({
        @FieldMatch(first = "password", second = "confirmPassword", message = "The password field must match"),
        @FieldMatch(first = "email", second = "confirmEmail", message = "The email fields must match")
})
@Getter
@Setter
public class UserRegistrationDto {

    @NotEmpty
    private String firstName;

    @NotEmpty
    private String lastName;

    @NotEmpty
    @Length(min = 5, message = "Your password must have at least 5 characters")
    @Transient
    private String password;

    @NotEmpty
    private String confirmPassword;

    @Email(message = "Please provide a valid Email")
    @NotEmpty
    private String email;

    @Email(message = "Please provide a valid Email")
    @NotEmpty
    private String confirmEmail;


    private String city;


    private String club;

    private Date dateOfBirth;


    private String sex;

//    private Card cardId;

    private Long cardId;

    @AssertTrue
    private Boolean terms;



}
