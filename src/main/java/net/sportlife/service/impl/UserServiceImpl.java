package net.sportlife.service.impl;

import net.sportlife.dto.UserRegistrationDto;
import net.sportlife.model.guest.Role;
import net.sportlife.model.guest.User;
import net.sportlife.repository.UserRepository;
import net.sportlife.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public User save(UserRegistrationDto registrationDto) {
        User user = new User();
        user.setFirstName(registrationDto.getFirstName());
        user.setLastName(registrationDto.getLastName());
        user.setDateOfBirth(registrationDto.getDateOfBirth());
        user.setSex(registrationDto.getSex());
        user.setCity(registrationDto.getCity());
        user.setClub(registrationDto.getClub());
        user.setCardId(registrationDto.getCardId());

        user.setEmail(registrationDto.getEmail());
        user.setPassword(bCryptPasswordEncoder.encode(registrationDto.getPassword()));
        user.setRoles(Arrays.asList(new Role("ROLE_USER")));

        return userRepository.save(user);
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User findUserByCardId(Long cardId) {
        return userRepository.findByCardId(cardId);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
        if(user == null) {
            throw new UsernameNotFoundException("Invalid username or password");
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(),
                user.getPassword(),
                mapRolesToAuthorities(user.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
    }
}
