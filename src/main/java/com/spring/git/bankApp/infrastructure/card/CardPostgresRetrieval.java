package com.spring.git.bankApp.infrastructure.card;

import com.spring.git.bankApp.domain.card.CardRetrieval;
import com.spring.git.bankApp.domain.model.card.Card;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class CardPostgresRetrieval implements CardRetrieval {

    private final CardRepository cardRepository;

    @Override
    public Card getByLastFourDigits(String lastFourDigits) {
        return cardRepository.findByLastFourDigits(lastFourDigits);
    }
}
