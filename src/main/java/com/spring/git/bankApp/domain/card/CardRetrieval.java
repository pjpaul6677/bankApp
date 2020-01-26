package com.spring.git.bankApp.domain.card;

import com.spring.git.bankApp.domain.model.card.Card;

public interface CardRetrieval {

    Card getByLastFourDigits(String lastFourDigits);
}
