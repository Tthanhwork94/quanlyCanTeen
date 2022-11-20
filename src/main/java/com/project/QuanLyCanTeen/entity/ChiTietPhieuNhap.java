package com.project.QuanLyCanTeen.entity;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "chitietphieunhap")
@Data
public class ChiTietPhieuNhap implements Serializable {

    @Id
    @Column(name = "maphieunhap")
    private Long maPhieuNhap;

    @Id
    @Column(name = "masanpham")
    private Long maSanPham;

    @ManyToOne
    @MapsId
    @JoinColumn(name = "maphieunhap")
    private PhieuNhap phieuNhap;

    @ManyToOne
    @MapsId
    @JoinColumn(name = "masanpham")
    private SanPham sanPham;

    @Column(name = "dongianhap")
    private Float donGiaNhap;

    @Column(name = "soluongnhap")
    private Integer soLuongNhap;
}
