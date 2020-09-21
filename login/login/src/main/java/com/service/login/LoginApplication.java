package com.service.login;

import com.service.login.dto.UserDto;
import com.service.login.service.SignService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
public class LoginApplication {
    @Autowired SignService signService;
    public static void main(String[] args) {
        SpringApplication.run(LoginApplication.class, args);
    }

    @PostMapping(value = "/sign", consumes = "application/json")
    public @ResponseBody HttpStatus sign(@RequestBody UserDto userInfo){
        signService.sign(userInfo);
        return HttpStatus.OK;
    }
}
