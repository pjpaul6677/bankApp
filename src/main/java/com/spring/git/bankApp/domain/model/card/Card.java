package com.spring.git.bankApp.domain.model.card;

import com.spring.git.bankApp.domain.model.account.Account;
import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "cards")
@Builder(access = AccessLevel.PRIVATE)
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "card_sequence")
    private long id;

    @Getter
    @Size(min = 4, max = 4)
    private String lastFourDigits;

    @Getter
    @Enumerated(EnumType.STRING)
    private CardStatus cardStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id")
    @Setter
    private Account account;

    public static Card createCard(String lastFourDigits) {
        return Card.builder()
                .lastFourDigits(lastFourDigits)
                .cardStatus(CardStatus.INACTIVE).build();
    }

    public void changeStatus(CardStatus cardStatus) {
        if (this.cardStatus != CardStatus.RESTRICTED) {
            this.cardStatus = cardStatus;
        } else {
            throw new HttpClientErrorException(HttpStatus.FORBIDDEN);
        }
    }

}
