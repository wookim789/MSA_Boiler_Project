package com.service.login;

import com.service.login.common.TokenResponse;
import com.service.login.dto.UserDto;
import com.service.login.service.AuthenticationService;

import org.apache.catalina.connector.Connector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
public class LoginApplication <T>{
    @Autowired AuthenticationService authService;
    public static void main(String[] args) {
        SpringApplication.run(LoginApplication.class, args);
    }

    // http와 https를 동시에 사용하기 위해 connector 추가
    @Bean
    public ServletWebServerFactory serverFactory() {
        TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory();
        tomcat.addAdditionalTomcatConnectors(createStandardConnector()); // 톰캣에 Connector 추가
        return tomcat;
    }
    private Connector createStandardConnector() {
        Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
        connector.setPort(8882); // 포트 설정(https랑 달라야함)
        return connector;
    }

    @PostMapping(value = "/sign", consumes = "application/json")
    public @ResponseBody ResponseEntity<T> sign(@RequestBody UserDto userInfo){
        authService.sign(userInfo);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(value = "/login")
    public @ResponseBody ResponseEntity<String> login(@RequestBody UserDto userInfo){
        String token = authService.createUserToken(userInfo);
        return ResponseEntity.status(HttpStatus.OK).body(token);
    }
}
