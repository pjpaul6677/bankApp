package com.spring.git.bankApp.api.card;

import com.spring.git.bankApp.domain.model.card.CardStatus;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Builder
public class CardDto {

    @NotNull
    @Size(min = 4, max = 4)
    private String lastFourDigits;

    @NotNull
    private CardStatus cardStatus;
}
