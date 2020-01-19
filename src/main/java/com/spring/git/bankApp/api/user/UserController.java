package com.spring.git.bankApp.api.user;

import com.spring.git.bankApp.domain.user.UserCommand;
import com.spring.git.bankApp.domain.user.UserFacade;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("v1/users")
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserFacade userFacade;

    @PostMapping
    public void createMaleUser(@Valid @RequestBody UserDto userDto) {
        log.info("Male user creation {}", userDto);
        UserCommand userCommand = UserCommand.builder().login(userDto.getLogin())
                .gender(userDto.getGender()).build();
        userFacade.createUser(userCommand);
    }


}
