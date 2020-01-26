package com.spring.git.bankApp.domain.model.card;

import com.spring.git.bankApp.exceptionHandler.ExceptionHandler;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "cards")
@Builder(access = AccessLevel.PRIVATE)
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Getter
    @Size(min = 4, max = 4)
    private String lastFourDigits;

    @Getter
    @Enumerated(EnumType.STRING)
    private CardStatus cardStatus;

    public static Card createCard(String lastFourDigits) {
        return Card.builder()
                .lastFourDigits(lastFourDigits)
                .cardStatus(CardStatus.INACTIVE).build();
    }

    public void changeStatus(CardStatus cardStatus) {
        if (this.cardStatus != CardStatus.RESTRICTED) {
            this.cardStatus = cardStatus;
        } else {
            throw new ExceptionHandler();
        }
    }

}
