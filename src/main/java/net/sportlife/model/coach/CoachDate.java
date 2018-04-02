package net.sportlife.model.coach;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
public class CoachDate {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "date_id")
    private Long id;

    @Column(name = "date")
    private LocalDate date;

    @ManyToMany(mappedBy = "dates")
    private Set<CoachEntity> coachEntities;

    public CoachDate() {
    }

    public CoachDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CoachDate coachDate = (CoachDate) o;
        return Objects.equals(id, coachDate.id) &&
                Objects.equals(date, coachDate.date);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, date);
    }

    @Override
    public String toString() {
        return "CoachDate{" +
                "date=" + date +
                '}';
    }
}
