package com.UserManagementSystem.service;

import com.UserManagementSystem.model.UserModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class UserService {

    private static List<UserModel> users = new ArrayList<>();
    static {
        users.add(new UserModel(1001,"Rudra","2000-11-10","rc1951@gmail.com","91-123456789"));
        users.add(new UserModel(1002,"Adil","2000-11-10","mk455@gmail.com","91-123456789"));
        users.add(new UserModel(1003,"Anup","2000-11-10","luc45@gmail.com","91-123456789"));
        users.add(new UserModel(1004,"Prashant","2000-11-10","rk78@gmail.com","91-123456789"));
        users.add(new UserModel(1005,"Ajay","2000-11-10","mk93@gmail.com","91-123456789"));
    }

    public String addUser(UserModel user){
        users.add(user);
        return "New User Added Successfully";
    }

    public UserModel getUser(int num){
        Predicate<?super UserModel> predicate= user ->user.getUserId()==num;
        UserModel user=users.stream().filter(predicate).findFirst().get();
        return user;
    }
    public List<UserModel> getAllUser(){
        return users;
    }

    public String deleteUser(int number){
        Predicate<? super UserModel> predicate=user ->user.getUserId()==number;
        users.removeIf(predicate);
        return "User Deleted Successfully";
    }

    public String updateUserInfo(int number, UserModel newuser){
        UserModel user=getUser(number);
        user.setUsername(newuser.getUsername());
        user.setEmail(newuser.getEmail());
        user.setDateOfBirth(newuser.getDateOfBirth());
        user.setPhoneNumber(newuser.getPhoneNumber());
        return "User Updated Successfully";
    }
}
