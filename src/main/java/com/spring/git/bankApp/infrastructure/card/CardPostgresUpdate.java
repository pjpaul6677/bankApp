package com.spring.git.bankApp.infrastructure.card;

import com.spring.git.bankApp.domain.card.CardUpdate;
import com.spring.git.bankApp.domain.model.card.CardStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class CardPostgresUpdate implements CardUpdate {

    private final CardRepository cardRepository;

    @Override
    @Transactional
    public void changeCardStatus(String lastFourDigits, CardStatus cardStatus) {
        cardRepository.findByLastFourDigits(lastFourDigits).changeStatus(cardStatus);
    }
}
