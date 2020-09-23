package com.service.login.service;

import com.service.login.common.JwtTokenProvider;
import com.service.login.dto.UserDto;
import com.service.login.model.User;
import com.service.login.repogitory.UserRepogitory;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    @Autowired UserRepogitory userRepo;
    @Autowired ModelMapper modelMapper;
    @Autowired JwtTokenProvider jwtTokenProvider;
    
    public Boolean sign(UserDto userInfoMap) {
        Boolean isSuccess = true;
        try{
            userRepo.save(User.builder()
                               .userId(userInfoMap.getUserId())
                               .password(userInfoMap.getPassword())
                               .email(userInfoMap.getEmail()).build());
        }catch(Exception e){
            e.printStackTrace();
            isSuccess = false;
        }

        return isSuccess;
    }

    public String createUserToken(UserDto userInfo){
        User user = userRepo.
                        findByUserIdAndPassword(
                                        userInfo.getUserId(), 
                                        userInfo.getPassword()).orElseThrow(IllegalArgumentException::new);
        return jwtTokenProvider.createToken(user.getUserId());
    }
}
