package com.spring.git.bankApp.api.card;

import com.spring.git.bankApp.domain.card.CardFacade;
import com.spring.git.bankApp.domain.model.card.Card;
import com.spring.git.bankApp.domain.model.card.CardStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Size;

@RestController
@RequestMapping(path = "/v1/cards")
@RequiredArgsConstructor
@Validated
public class CardController {

    private final CardFacade cardFacade;

    @GetMapping(path = "/{cardNumber}")
    public ResponseEntity<CardDto> findCardByCardNumber(@PathVariable @Size(min = 4, max = 4) String cardNumber) {
        CardDto cardDto = CardMapper.mapToDto(cardFacade.findByLastFourDigits(cardNumber));
        return ResponseEntity.ok(cardDto);

    }

    @PatchMapping(path = "/{lastFourDigits}")
    public void changeStatus(@PathVariable @Size(min = 4, max = 4) String lastFourDigits, @RequestParam CardStatus cardStatus) {
        cardFacade.changeStatus(lastFourDigits, cardStatus);
    }

    @PostMapping(path = "/{accountNumber}/newCard")
    public void createCard(@PathVariable @Size(min = 16, max = 16) String accountNumber) {
        cardFacade.create(accountNumber);
    }

    private static class CardMapper {
        public static CardDto mapToDto(Card card) {
            return CardDto.builder()
                    .lastFourDigits(card.getLastFourDigits())
                    .cardStatus(card.getCardStatus()).build();
        }
    }
}
