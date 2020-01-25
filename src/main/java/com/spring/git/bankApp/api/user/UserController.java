package com.spring.git.bankApp.api.user;

import com.spring.git.bankApp.domain.model.user.User;
import com.spring.git.bankApp.domain.user.UserFacade;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("v1/users")
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserFacade userFacade;

    @GetMapping(path = "/{login}")
    public ResponseEntity<UserDto> findByLogin(@PathVariable String login) {
        return ResponseEntity.ok(UserMapper.mapToDto(userFacade.findByLogin(login)));
    }

    @PatchMapping(path = "/updatePassword")
    public void updatePassword(@RequestParam String login, @RequestParam String oldPassword, @RequestParam String newPassword) {
        log.info("Updating password {}", login);
        userFacade.updatePassword(login, oldPassword, newPassword);
    }

    @PostMapping
    public void createUser(@Valid @RequestBody UserDto userDto) {
        log.info("User creation {}", userDto.getLogin());
        userFacade.createUser(userDto.getLogin(), userDto.getGender(), userDto.getPassword());
    }

    private static class UserMapper {
        private static UserDto mapToDto(User user) {
            return UserDto.builder().login(user.getLogin())
                    .gender(user.getGender()).build();
        }
    }


}
