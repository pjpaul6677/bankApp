package com.spring.git.bankApp.domain.card;

import com.spring.git.bankApp.domain.model.card.Card;
import com.spring.git.bankApp.domain.model.card.CardStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CardFacade {

    private final CardCreator cardCreator;
    private final CardRetrieval cardRetrieval;

    public void create(String accountNumber) {
        cardCreator.create(accountNumber);
    }

    public Card findByLastFourDigits(String lastFourDigits) {
        return cardRetrieval.getByLastFourDigits(lastFourDigits);
    }

    public void changeStatus(String lastFourDigits, CardStatus cardStatus) {

    }


}
