package com.service.login.common;

public class TokenResponse {
    private String accessToken;
    private String tokenType;

    public TokenResponse(){

    }
    public TokenResponse(String token, String type){
        this.accessToken = token;
        this.tokenType = type;
    }
}
