package net.sportlife.repository;

import net.sportlife.model.coach.Club;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface ClubRepository extends JpaRepository<Club, Long> {

    ArrayList<Club> getClubsByCity(String cityName);


}
