package net.sportlife.repository;

import net.sportlife.model.coach.CoachEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Blob;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface CoachRepository extends JpaRepository<CoachEntity, Long> {

    List<CoachEntity> findByClubs(String clubName);
    CoachEntity getCoachEntityByDates(LocalDate date);
    List<CoachEntity> findByDates(LocalDate date);
}
