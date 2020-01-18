package com.spring.git.bankApp.api.user;

import com.spring.git.bankApp.api.account.AccountDto;
import com.spring.git.bankApp.domain.model.account.AccountCommand;
import com.spring.git.bankApp.domain.user.UserCommand;
import com.spring.git.bankApp.domain.user.UserFacade;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("v1/users")
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserFacade userFacade;

    @PostMapping("/create/{login}")
    public void createUser(@NotNull @PathVariable String login) {
        UserCommand userCommand = UserCommand.builder().login(login).build();
        userFacade.create(userCommand);
    }
}
