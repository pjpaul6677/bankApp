package com.spring.git.bankApp.domain.transfer;

import lombok.Data;
import lombok.Getter;

import java.math.BigDecimal;

@Data
@Getter
public class TransferCommand {
    private long customerAccountId;
    private long sellerAccountId;
    private BigDecimal amount;
}
