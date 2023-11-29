package com.GreenCodeSolution.CollectionOfData.service;
import com.GreenCodeSolution.CollectionOfData.dto.request.RequestUserDto;
public interface UserService {
    public void signup(RequestUserDto userDto);
    public boolean verifyUser(String type, String token);
}
