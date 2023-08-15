package com.client.controller;

import com.client.dtos.UserResponseDto;
import com.client.dtos.response.ServerResponse;
import com.client.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api")
public class SignupController {
    @Autowired
    private UserLoginService userLoginService;
    @Autowired
    private UserResponseDto userResponseDto;
    @PostMapping("/signup")
    ResponseEntity<ServerResponse> signup(@RequestBody UserResponseDto userResponseDto){
        ServerResponse serverResponse= userLoginService.signup(userResponseDto);
        ServerResponse serverResponse1 = userLoginService.signup(userResponseDto);
        return ResponseEntity.status(serverResponse1.getHttpStatus())
                .body(serverResponse1);
    }
}
