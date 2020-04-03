package com.rst.boot.services.impl;

import com.rst.boot.domain.UserDTO;
import com.rst.boot.repositories.UserRepository;
import com.rst.boot.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import javax.persistence.Id;
import java.util.List;
@Service
public class UserServiceImpl implements UserServices {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserDTO> findAllUsers() {
        //database search
        //return all user
       List<UserDTO> allusers= userRepository.findAll();
       return allusers;
    }
    @Override
    public String saveUser(UserDTO userdata) {
        userRepository.save(userdata);
        return "Data saved";
    }

    @Override
    public String updateUser(UserDTO newUserData) {

        String msg=null;

        if(newUserData.getId()!=null){
            userRepository.save(newUserData);
            msg="Data Updated";
        }
        else{
            msg="Error";
        }
        return msg;

    }

//    @Override
//    public UserDTO findById(Integer id) {
//        return userRepository.findOne(id);
//    }
}
