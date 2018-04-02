package net.sportlife.model.coach;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

//Used for identifying coaches in the club

@Entity
@Getter
@Setter
public class Club {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String clubName;

    @Column(name = "location")
    private String location;

    @ManyToOne
    @JoinColumn(name = "city_id", nullable = false)
    private City city;

    @ManyToMany(mappedBy = "clubs")
    private Set<CoachEntity> coaches;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Club club = (Club) o;
        return Objects.equals(id, club.id) &&
                Objects.equals(clubName, club.clubName) &&
                Objects.equals(location, club.location) &&
                Objects.equals(city, club.city) &&
                Objects.equals(coaches, club.coaches);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, clubName, location, city, coaches);
    }

}
