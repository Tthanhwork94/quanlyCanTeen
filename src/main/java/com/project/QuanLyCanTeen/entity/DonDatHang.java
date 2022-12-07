package com.project.QuanLyCanTeen.entity;


import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "dondathang")
@Data
public class DonDatHang {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "madondathang")
    private Long madondathang;

    @Column(name = "tgdat")
    @CreationTimestamp
    private Timestamp tgdat;

    @Column(name = "tgnhandukien")
    private Timestamp tgnhandukien;

    @Column(name = "tongtien")
    private Float tongtien;

    @Column(name = "tinhtrangdon")
    private String tinhtrangdon;

    @ManyToOne
    @JoinColumn(name = "makhachhang",referencedColumnName = "makhachhang")
    private KhachHang khachhang;
}
