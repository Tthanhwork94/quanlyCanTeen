package com.project.QuanLyCanTeen.entity;


import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "phieunhap")
@Data
public class PhieuNhap {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "maphieunhap")
    private Long maphieunhap;

    @Column(name = "ngaynhap")
    @CreationTimestamp
    private Timestamp ngayNhap;

    @Column(name = "tongtiennhap")
    private Float tongtiennhap;

    @Column(name = "tinhtrang")
    private String tinhtrang;

    @ManyToOne
    @JoinColumn(name = "manhanviennhap",referencedColumnName = "manhanvien")
    private NhanVien nhanvien;

    @ManyToOne
    @JoinColumn(name = "manhacungung",referencedColumnName = "manhacungung")
    private NhaCungUng nhacungung;
}
