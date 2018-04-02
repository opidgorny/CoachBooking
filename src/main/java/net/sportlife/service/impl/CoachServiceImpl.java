package net.sportlife.service.impl;

import net.sportlife.constraint.CoachAvailabilityChecker;
import net.sportlife.enums.CoachStatusEnum;
import net.sportlife.model.coach.Club;
import net.sportlife.model.coach.CoachDate;
import net.sportlife.model.coach.CoachEntity;
import net.sportlife.repository.ClubRepository;
import net.sportlife.repository.CoachRepository;
import net.sportlife.service.CoachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.lang.reflect.Array;
import java.sql.Blob;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service("coachService")
public class CoachServiceImpl implements CoachService{

    @Autowired
    private CoachRepository coachRepository;

    @Autowired
    private ClubRepository clubRepository;

    private CoachAvailabilityChecker coachAvailabilityChecker;

    @Override
    public List<CoachEntity> getCoachesByClub(String clubName) {
        return coachRepository.findByClubs(clubName);
    }

    @Override
    public List<Club> getClubsByCity(String cityName) {
        return clubRepository.getClubsByCity(cityName);
    }

    @Override
    public List<CoachEntity> getCoachesByCityAndClub(String cityName, String clubName) {
        if (clubRepository.getClubsByCity(cityName) != null) {
            return coachRepository.findByClubs(clubName);
        }

        return null;
    }

    @Override
    public List<CoachEntity> getAllCoaches() {
        return coachRepository.findAll();
    }

    @Override
    public CoachEntity getCoachById(Long id) {
        return coachRepository.getOne(id);
    }

    @Override
    public CoachEntity getCoachByDate(LocalDate date) {
        return coachRepository.getCoachEntityByDates(date);
    }

    @Override
    public void setCoachStatusByDate(LocalDate date) {
        List<CoachEntity> coachEntities = coachRepository.findByDates(date);
        for(CoachEntity coach : coachEntities) {
            if (coachAvailabilityChecker.dateAvailabilityChecker(coach, date).equals(false)) {
                coach.setStatus(CoachStatusEnum.BUSY);
            } else {
                coach.setStatus(CoachStatusEnum.AVAILABLE);
            }
        }
    }
//    Should we work with session?
//    @Override
//    public void setCoachStatusByDate(HttpSession session) {
//        List<CoachEntity> coachEntities = coachRepository.findByDates((LocalDate) session.getAttribute("date"));
//        for(CoachEntity coach : coachEntities) {
//            if (coachAvailabilityChecker.dateAvailabilityChecker(coach, session).equals(false)) {
//                coach.setStatus(CoachStatusEnum.BUSY);
//            } else {
//                coach.setStatus(CoachStatusEnum.AVAILABLE);
//            }
//        }
//    }


    @Override
    public byte[] getImageByCoachId(Long id) throws SQLException {
        Blob image = null;
        byte[] imgData = null;

        image = coachRepository.getOne(id).getPhoto();
        imgData = image.getBytes(1, (int)image.length());
        return imgData;
    }
}
