package com.spring.git.bankApp.domain.model.account;

import com.spring.git.bankApp.domain.model.Auditable;
import com.spring.git.bankApp.domain.model.transfer.Transfer;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Builder
@Table(name = "accounts")
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
public class Account extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "user_sequence")
    private Long id;

    @Getter
    private String accountNumber;
    private BigDecimal balance;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id")
    private Set<Transfer> transfers = new HashSet<>();
}
