package com.spring.git.bankApp.api.user;

import com.spring.git.bankApp.domain.user.UserCommand;
import com.spring.git.bankApp.domain.user.UserFacade;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("v1/users")
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserFacade userFacade;

    @PostMapping("/{login}")
    public void createUser(@NotNull @PathVariable String login) {
        UserCommand userCommand = UserCommand.builder().login(login).build();
        userFacade.create(userCommand);
        log.info("User creation {}", login);
    }
}
