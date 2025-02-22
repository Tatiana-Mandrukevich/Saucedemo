package tests;

import entity.User;

public class Preconditions extends BaseTest {

    public static User userWithEmptyUsername = User.builder()
            .username("")
            .password(PASSWORD)
            .build();

    public static User userWithEmptyPassword = User.builder()
            .username(USERNAME)
            .password("")
            .build();

    public static User userWithEmptyFields = User.builder()
            .username("")
            .password("")
            .build();

    public static User userWithIncorrectFields = User.builder()
            .username("efwefwe")
            .password("efwefwe")
            .build();
}
