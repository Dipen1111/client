package com.client.service;

import com.client.dtos.UserResponseDto;
import com.client.dtos.response.ServerResponse;
import com.client.entity.User;
import com.client.repo.UserRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserLoginService {
    @Autowired
    private UserRepo userRepo;


public ServerResponse signup(UserResponseDto userResponseDto){
    ServerResponse serverResponse = new ServerResponse();

    User userentity= new User();
    userentity.setFirstname(userResponseDto.getFirstname());
    userentity.setLastname(userResponseDto.getLastname());
    userentity.setEmail(userResponseDto.getEmail());
    userentity.setPassword(userentity.getPassword());
    userentity = userRepo.save(userentity);
    return serverResponse;
}
    public ServerResponse login(UserResponseDto userResponseDto){
        ServerResponse serverResponse=new ServerResponse();
        User user= userRepo.findOneByEmailIgnoreCaseAndPassword(userResponseDto.getEmail(),userResponseDto.getPassword());

        if(user==null){
            serverResponse.setData("user login failed");
        }
        else {
            serverResponse.setData("user login");
        }
        return serverResponse;
    }
}

