package com.project.QuanLyCanTeen.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "nhanvien")
@Data
public class NhanVien {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "manhanvien")
    private Long manhanvien;

    @Column(name = "hoten")
    private String hoten;

    @Column(name = "diachi")
    private String diachi;

    @Column(name = "email")
    private String email;

    @OneToOne
    @JoinColumn(name = "maacc",referencedColumnName = "mataikhoan")
    private TaiKhoan taikhoan;
}
