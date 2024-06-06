package com.java5.demojpa.repository;

import com.java5.demojpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    @Query(value = "SELECT e.user_id, e.user_name ,e.password ,e.full_name ,e.address ,e.age ,e.mark, e.hoc_luc, e.role_id FROM User e WHERE e.role_id=?1", nativeQuery = true)
    List<User> getUserByRoleId(int roleId);
//  hàm getUserByRoleId(int roleId) là 1 hàm tự định nghĩa
//  value = "SELECT e.user_id, e.user_name ,e.password ,e.full_name ,e.address ,e.age ,e.mark, e.hoc_luc, e.role_id FROM User e WHERE e.role_id=?1" đây là câu query của mình
//  WHERE e.role_id=?1 : lấy điều kiện role_id = tham số đầu tiên mình truyền vào (roleId)
//  nativeQuery = true: vì đoạn này câu query của mình là câu nativeQuery nên phải set nó là true
}
