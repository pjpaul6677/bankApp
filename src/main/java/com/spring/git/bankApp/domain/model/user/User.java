package com.spring.git.bankApp.domain.model.user;


import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@Table(name = "users")
@RequiredArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String login;

}
