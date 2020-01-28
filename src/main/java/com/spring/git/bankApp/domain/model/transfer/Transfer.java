package com.spring.git.bankApp.domain.model.transfer;

import com.spring.git.bankApp.domain.model.Auditable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class Transfer extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "transfer_sequence")
    private long id;

    @Getter
    private String fromAccountNumber;
    @Getter
    private String toAccountNumber;
    @Getter
    private BigDecimal amount;

}
