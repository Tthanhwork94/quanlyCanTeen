package com.project.QuanLyCanTeen.entity;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "admin")
@Data
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "maadmin")
    private Long maadmin;

    @Column(name = "hoten")
    private String hoten;

    @Column(name = "diachi")
    private String diaChi;

    @Column(name = "email")
    private String email;

    @OneToOne
    @JoinColumn(name = "maacc",referencedColumnName = "mataikhoan")
    private TaiKhoan taikhoan;
}
