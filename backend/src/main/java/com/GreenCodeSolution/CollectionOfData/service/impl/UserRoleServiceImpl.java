package com.GreenCodeSolution.CollectionOfData.service.impl;
import com.GreenCodeSolution.CollectionOfData.entity.UserRole;
import com.GreenCodeSolution.CollectionOfData.repo.UserRoleRepo;
import com.GreenCodeSolution.CollectionOfData.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRoleServiceImpl implements UserRoleService {

    @Autowired
    private UserRoleRepo userRoleRepo;

    @Override
    public void initializeRoles() {
        if (userRoleRepo.count()==0){
            UserRole admin = new UserRole(1,"ADMIN","admin",null);
            UserRole client = new UserRole(2,"CLIENT","client",null);
            userRoleRepo.saveAll(List.of(admin,client));
        }

    }
}
