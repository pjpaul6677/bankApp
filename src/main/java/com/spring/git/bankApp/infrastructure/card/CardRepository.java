package com.spring.git.bankApp.infrastructure.card;

import com.spring.git.bankApp.domain.model.card.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card, Long> {

    Card findByLastFourDigits(String lastFourDigits);
}
