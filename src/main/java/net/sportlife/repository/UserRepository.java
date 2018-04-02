package net.sportlife.repository;

import net.sportlife.model.guest.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);
    User findByCardId(Long cardId);
}
