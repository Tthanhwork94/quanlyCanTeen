package com.project.QuanLyCanTeen.entity;

import javax.persistence.*;

public class ChiTietDonDatHang {

    @Id
    @Column(name = "madondathang")
    private Long maDonDatHang;

    @Id
    @Column(name = "masanpham")
    private Long maSanPham;

    @ManyToOne
    @MapsId
    @JoinColumn(name = "madondathang")
    private DonDatHang donDatHang;

    @ManyToOne
    @MapsId
    @JoinColumn(name = "masanpham")
    private SanPham sanPham;

    @Column(name = "soluongmua")
    private Integer soluongmua;


    @Column(name = "dongia")
    private Float dongia;
}
