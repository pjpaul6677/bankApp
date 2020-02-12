package com.spring.git.bankApp.api.transfer;

import lombok.Data;
import lombok.Getter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Data
public class TransferDto {

    @NotBlank
    @Size(min = 16, max = 16)
    private String fromAccountNumber;

    @NotBlank
    @Size(min = 16, max = 16)
    private String toAccountNumber;

    @Min(0)
    private BigDecimal amount;
}
