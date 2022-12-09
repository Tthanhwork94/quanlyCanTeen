package com.project.QuanLyCanTeen.entity;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "chitietphieunhap")
@Data
@IdClass(ChiTietPhieuNhap.class)
public class ChiTietPhieuNhap implements Serializable {

    @Id
    @Column(name = "maphieunhap")
    private Long maPhieuNhap;

    @Id
    @Column(name = "masanpham")
    private Long masanpham;

    @Column(name = "dongianhap")
    private Float dongianhap;

    @Column(name = "soluongnhap")
    private Integer soluongnhap;
}
