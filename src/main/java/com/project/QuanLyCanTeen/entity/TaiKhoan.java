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
    private Long maTaiKhoan;

    @Column(name = "tentaikhoan")
    private String tenTaiKhoan;

    @Column(name = "matkhau")
    private String matKhau;

    @Column(name = "loaitaikhoan")
    private String loaiTaiKhoan;

    @Column(name = "tinhtrang")
    private String tinhTrang;
}
