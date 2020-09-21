package com.service.login.service;

import com.service.login.dto.UserDto;
import com.service.login.model.Users;
import com.service.login.repogitory.UserRepogitory;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SignService {
    @Autowired UserRepogitory userRepo;
    @Autowired ModelMapper modelMapper;
    
    public void sign(UserDto userInfoMap) {
        try{
            userRepo.save(Users.builder()
                               .userId(userInfoMap.getUserId())
                               .password(userInfoMap.getPassword())
                               .email(userInfoMap.getEmail()).build());
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
