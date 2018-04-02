package net.sportlife.service;

import net.sportlife.model.coach.Club;
import net.sportlife.model.coach.CoachEntity;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public interface CoachService {

    List<CoachEntity> getCoachesByClub(String clubName);
    List<Club> getClubsByCity(String cityName);
    List<CoachEntity> getCoachesByCityAndClub(String cityName, String clubName);
    List<CoachEntity> getAllCoaches();
    CoachEntity getCoachById(Long id);
    CoachEntity getCoachByDate(LocalDate date);
    void setCoachStatusByDate(LocalDate date);
    byte[] getImageByCoachId(Long id) throws SQLException;
}
