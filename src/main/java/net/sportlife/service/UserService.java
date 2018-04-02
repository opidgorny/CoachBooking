package net.sportlife.service;

import net.sportlife.dto.UserRegistrationDto;
import net.sportlife.model.guest.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public interface UserService extends UserDetailsService {

    User save(UserRegistrationDto registrationDto);
    User findUserByEmail(String email);
    User findUserByCardId(Long cardId);
}
