package net.sportlife.model.coach;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Photo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "photo_id")
    private Long id;

    @Column(name = "photo")
    private byte[] photo;

//    @OneToOne(mappedBy = "photo")
//    private CoachEntity coachEntity;
}
