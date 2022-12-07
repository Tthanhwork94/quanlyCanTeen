package com.project.QuanLyCanTeen.entity;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "taikhoan")
@Data
public class TaiKhoan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mataikhoan")
    private Long mataikhoan;

    @Column(name = "tentaikhoan")
    private String tentaikhoan;

    @Column(name = "matkhau")
    private String matkhau;

    @Column(name = "loaitaikhoan")
    private String loaitaikhoan;

    @Column(name = "tinhtrang")
    private String tinhtrang;
}
