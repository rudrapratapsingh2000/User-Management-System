package com.UserManagementSystem.controller;

import com.UserManagementSystem.model.UserModel;
import com.UserManagementSystem.service.UserService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/userapp")
public class UserController {
    public final UserService userManagementService;

    public UserController(UserService userManagementService){
        this.userManagementService=userManagementService;
    }

    @PostMapping("/adduser")
    public String addUser(@RequestBody UserModel user){
        return userManagementService.addUser(user);
    }
    @GetMapping("/finduser/number/{number}")
    public UserModel getuser(@PathVariable int number){
        return userManagementService.getUser(number);
    }

//    @GetMapping("/finduser")
//    public UserManagementModel getuser(@RequestBody Map jsonMap){
//    int number=jsonMap.get("number").toString()==null?null:Integer.parseInt(jsonMap.get("number").toString());
//        return userManagementService.getUser(number);
//    }

    @GetMapping("/findalluser")
    public List<UserModel> getAllUser(){
        return userManagementService.getAllUser();
    }

    @DeleteMapping("/deleteuser/number/{number}")
    public String deleteUser(@PathVariable int number){
        return userManagementService.deleteUser(number);
    }

    @PutMapping("/updateuser/number/{number}")
    public String updateUser(@PathVariable int number, @RequestBody UserModel user){
        return userManagementService.updateUserInfo(number,user);
    }
}
