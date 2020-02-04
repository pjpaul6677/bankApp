package com.spring.git.bankApp.domain.model.user;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTest {

    private static final List<User> users = new LinkedList<>();
    static {
        users.add(User.createUser("Aleksander", Gender.MALE, "SafePassword"));
        users.add(User.createUser("Aleksandra", Gender.FEMALE, "SafePassword"));
        users.add(User.createUser("John", Gender.MALE, "Short"));
        users.add(User.createUser("Jagoda", Gender.MALE, "Short"));
        users.add(User.createUser("Wojciech", Gender.MALE, "Banking"));
        users.add(User.createUser("Kathrina", Gender.MALE, "Banking"));
    }


    @ParameterizedTest
    @MethodSource("usersData")
    void correctLoginUpdate(User user, String newLogin, String password) {
        user.updateLogin(newLogin, password);
        assertEquals(user.getLogin(),"NewLogin");
    }

    @ParameterizedTest
    @MethodSource("usersData")
    void correctPasswordUpdate(User user, String newPassword, String password) {
        user.updatePassword(password, newPassword);
        user.updateLogin("NewLogin", newPassword);
        assertEquals(user.getLogin(),"NewLogin");
    }


    private static Stream usersData() {
        return Stream.of(
            Arguments.of(users.get(0), "NewLogin", "SafePassword"),
            Arguments.of(users.get(1), "NewLogin", "SafePassword"),
            Arguments.of(users.get(2), "NewLogin", "Short"),
            Arguments.of(users.get(3), "NewLogin", "Short"),
            Arguments.of(users.get(4), "NewLogin", "Banking"),
            Arguments.of(users.get(5), "NewLogin", "Banking"));
    }
}
