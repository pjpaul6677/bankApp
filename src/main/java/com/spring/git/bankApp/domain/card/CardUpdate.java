package com.spring.git.bankApp.domain.card;

import com.spring.git.bankApp.domain.model.card.CardStatus;

public interface CardUpdate {

    void changeCardStatus(String lastFourDigits, CardStatus cardStatus);
}
