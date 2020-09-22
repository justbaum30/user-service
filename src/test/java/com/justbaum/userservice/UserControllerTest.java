package com.justbaum.userservice;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UserControllerTest {

    private UserController userController;

    @Before
    public void setUp() {
        this.userController = new UserController();
    }

    @Test
    public void getUserData_ReturnsString() {
        assertThat(userController.getUserData()).isEqualTo("some user data");
    }
}
