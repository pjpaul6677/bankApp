package com.spring.git.bankApp.domain.model.account;

import com.spring.git.bankApp.domain.model.Auditable;
import com.spring.git.bankApp.domain.model.card.Card;
import com.spring.git.bankApp.domain.model.user.User;
import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Builder
@Table(name = "accounts")
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Account extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "account_sequence")
    private Long id;

    @Getter
    private String accountNumber;
    @Getter
    private BigDecimal balance;

    @Enumerated(EnumType.STRING)
    @Getter
    private AccountType accountType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @Setter
    private User user;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Card> cards = new HashSet<>();

    public void addCard(Card card) {
        cards.add(card);
        card.setAccount(this);
    }

    public void sendMoney(BigDecimal amount) {
        if (balance.compareTo(amount) < 0) {
            throw new HttpClientErrorException(HttpStatus.INSUFFICIENT_STORAGE);
        }
        this.balance = balance.subtract(amount);
    }

    public void receiveMoney(BigDecimal amount) {
        this.balance = balance.add(amount);
    }

}
