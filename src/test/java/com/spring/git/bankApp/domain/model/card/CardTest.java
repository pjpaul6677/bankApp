package com.spring.git.bankApp.domain.model.card;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.web.client.HttpClientErrorException;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CardTest {

    @ParameterizedTest
    @MethodSource("cardStatuses")
    void changeStatusThrow(CardStatus cardStatus) {
       Card card = Card.createCard("1234");
       card.changeStatus(CardStatus.RESTRICTED);
       assertThrows(HttpClientErrorException.class, () -> card.changeStatus(cardStatus));
    }

    @ParameterizedTest
    @MethodSource("cardStatuses")
    void changeStatusCorrectly(CardStatus cardStatus) {
        Card card = Card.createCard("1234");
        card.changeStatus(cardStatus);
        assertEquals(cardStatus,card.getCardStatus());
    }

    private static Stream cardStatuses() {
        return Stream.of(
                Arguments.of(CardStatus.ACTIVE),
                Arguments.of(CardStatus.INACTIVE),
                Arguments.of(CardStatus.RESTRICTED));
    }
}
