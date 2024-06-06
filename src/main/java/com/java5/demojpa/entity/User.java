package com.java5.demojpa.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "User")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "password")
    private String password;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "address")
    private String address;

    @Column(name = "age")
    private int age;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id",referencedColumnName = "role_id")
    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
    private Role role;      //đối tượng role
//      @OneToOne: Đây là một mối quan hệ giữa hai thực thể.
//      Fetch type xác định cách thức lấy dữ liệu liên quan từ database.
//      FetchType.EAGER: dữ liệu của đối tượng role sẽ được tải ngay lập tức khi thực thể chứa nó (User) được tải.
//      @JoinColumn: Định nghĩa thông tin về cột trong cơ sở dữ liệu sẽ được sử dụng để tạo mối quan hệ giữa các thực thể.
//      name = "role_id": Đây là tên của cột trong bảng hiện tại (cột role_id trong bảng User).
//      referencedColumnName = "role_id": role_id này là role_id trong bảng Role.
}
