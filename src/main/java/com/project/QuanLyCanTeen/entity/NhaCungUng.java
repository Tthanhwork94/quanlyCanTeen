package com.project.QuanLyCanTeen.entity;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "nhacungung")
@Data
public class NhaCungUng {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "manhacungung")
    private Long maNhaCungUng;

    @Column(name = "tennhacungung")
    private String tenNhaCungUng;

    @Column(name = "diachi")
    private String diaChi;

    @Column(name = "email")
    private String email;
}
