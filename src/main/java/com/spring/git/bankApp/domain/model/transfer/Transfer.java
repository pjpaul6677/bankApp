package com.spring.git.bankApp.domain.model.transfer;

import com.spring.git.bankApp.domain.model.Auditable;
import lombok.AllArgsConstructor;
import lombok.Builder;
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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String fromAccountNumber;
    private String toAccountNumber;
    private BigDecimal amount;

}
