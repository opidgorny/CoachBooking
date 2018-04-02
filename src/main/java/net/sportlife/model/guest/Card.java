package net.sportlife.model.guest;

import lombok.Getter;
import lombok.Setter;
import net.sportlife.enums.CardStatusEnum;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "card_id")
    private Long id;

    @Column(name = "sportlife_card_id")
    private Long cardId;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private CardStatusEnum status;

//    @OneToOne(mappedBy = "cardId")
//    private User user;


    public Card() {
    }
}
