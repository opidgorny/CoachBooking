package net.sportlife.model.coach;

import lombok.Getter;
import lombok.Setter;
import net.sportlife.enums.CoachStatusEnum;

import javax.persistence.*;
import java.sql.Blob;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
public class CoachEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String coachName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    //Sets the rank of coach (Newbie, Semi-Professional, etc.)
    @Column(name = "coach_rank")
    private String coachRank;

    @Column(name = "hour_price")
    private Long hourPrice;

    @ManyToMany
    @JoinTable(name = "coach_clubs", joinColumns = @JoinColumn(name = "coach_id"), inverseJoinColumns = @JoinColumn(name = "club_id"))
    private Set<Club> clubs;

    //Available coach or not
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private CoachStatusEnum status;

    @ManyToMany
    @JoinTable(name = "coach_dates", joinColumns = @JoinColumn(name = "coach_id"), inverseJoinColumns = @JoinColumn(name = "date_id"))
    private Set<CoachDate> dates;

    @Column(name = "external_information")
    private String externalInformation;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "photo_id")
//    private Photo photo;

    @Column(name = "coach_photo")
    private Blob photo;

//    @Column(name = "photo")
//    private BufferedImage photo;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CoachEntity that = (CoachEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(coachName, that.coachName) &&
                Objects.equals(lastName, that.lastName) &&
                Objects.equals(dateOfBirth, that.dateOfBirth) &&
                Objects.equals(coachRank, that.coachRank) &&
                Objects.equals(hourPrice, that.hourPrice) &&
                Objects.equals(clubs, that.clubs) &&
                status == that.status;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, coachName, lastName, dateOfBirth, coachRank, hourPrice, clubs, status);
    }

    @Override
    public String toString() {
        return "CoachEntity{" +
                "id=" + id +
                ", coachName='" + coachName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", coachRank='" + coachRank + '\'' +
                ", hourPrice=" + hourPrice +
                ", status=" + status +
                '}';
    }
}
