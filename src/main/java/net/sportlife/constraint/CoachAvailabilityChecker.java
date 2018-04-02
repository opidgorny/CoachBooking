package net.sportlife.constraint;

import net.sportlife.model.coach.CoachDate;
import net.sportlife.model.coach.CoachEntity;
import net.sportlife.service.CoachService;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.List;

public class CoachAvailabilityChecker {

    //Can we do smth like this? CoachDate receives LocalDate under the hood ( question )
    public Boolean dateAvailabilityChecker(CoachEntity coachEntity, LocalDate date) {

        return !coachEntity.getDates().equals(date);
        //returns false if data is booked otherwise true
    }


}
