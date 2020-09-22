package com.justbaum.userservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/api/user-data")
    public String getUserData() {
        return "some user data";
    }
}
