package com.spring.git.bankApp.domain.model.account;

import com.spring.git.bankApp.domain.model.Auditable;
import com.spring.git.bankApp.domain.model.transfer.Transfer;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Builder
@Table(name = "accounts")
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NamedQueries(
        @NamedQuery(name = "Account.findByAccountNumber", query = "SELECT a FROM Account a WHERE a.accountNumber = :accountNumber")
)
public class Account extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "user_sequence")
    private Long id;

    private String accountNumber;
    private BigDecimal balance;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id")
    private Set<Transfer> transfers = new HashSet<>();
}
