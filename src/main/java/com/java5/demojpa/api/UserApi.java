package com.java5.demojpa.api;

import com.java5.demojpa.entity.User;
import com.java5.demojpa.service.UserSevice;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@RequestMapping("api/user-api")
@RestController
@RequiredArgsConstructor
public class UserApi {
//    Mô hình sẽ đi từ Api -> Service(interface) -> ServiceImpl -> repository
    private final UserSevice userSevice;

    @GetMapping("getAllUser")
    public ResponseEntity<?> doGetAllUser(){
        Map<String,Object> result = new HashMap<>();
        try {
            result.put("success",true);
            result.put("message","Call api succes");
            result.put("data",userSevice.getAllUser());
        }catch (Exception e){
            result.put("success",false);
            result.put("message","Call api fail");
            result.put("data",null);
        }
        return ResponseEntity.ok(result);
    }

    @GetMapping("getUserByUserId")
    public ResponseEntity<?> doGetUserByUserId(@RequestParam("userId") int userId){
        Map<String,Object> result = new HashMap<>();
        try {
            result.put("success",true);
            result.put("message","Call api succes");
            result.put("data",userSevice.getUserById(userId));
        }catch (Exception e){
            result.put("success",false);
            result.put("message","Call api fail");
            result.put("data",null);
        }
        return ResponseEntity.ok(result);
    }

    @GetMapping("getUsersByRoleId")
    public ResponseEntity<?> doGetUsersByRoleId(@Param("roleId")int roleId){
        Map<String,Object> result = new HashMap<>();
        try {
            result.put("success",true);
            result.put("message","Call api succes");
            result.put("data",userSevice.getUserByRoleId(roleId));
        }catch (Exception e){
            result.put("success",false);
            result.put("message","Call api fail");
            result.put("data",null);
            e.printStackTrace();
        }
        return ResponseEntity.ok(result);
    }

    @PostMapping("saveUser")
    public ResponseEntity<?> saveUser(@RequestBody User user){
        Map<String,Object> result = new HashMap<>();
        try {
            result.put("success",true);
            result.put("message","Call api succes");
            result.put("data",userSevice.saveUser(user));
        }catch (Exception e){
            result.put("success",false);
            result.put("message","Call api fail");
            result.put("data",null);
        }
        return ResponseEntity.ok(result);
    }
}
