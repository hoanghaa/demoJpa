package com.java5.demojpa.api;

import com.java5.demojpa.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/role_api")
public class RoleApi {
    @Autowired
    private RoleRepository roleRepository;

    @GetMapping("/getAllRole")
    public ResponseEntity<?> doGetAllRole() {
        Map<String, Object> result = new HashMap();
        result.put("success",true);
        result.put("message","Call api success");
        result.put("data",roleRepository.findAll());
        return ResponseEntity.ok(result);
    }
}
