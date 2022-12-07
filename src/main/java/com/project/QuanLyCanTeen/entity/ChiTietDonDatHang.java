package com.project.QuanLyCanTeen.entity;

import javax.persistence.*;

public class ChiTietDonDatHang {

    @Id
    @Column(name = "madondathang")
    private Long madondathang;

    @Id
    @Column(name = "masanpham")
    private Long masanpham;

    @ManyToOne
    @JoinColumn(name = "madondathang")
    private DonDatHang dondathang;

    @ManyToOne
    @JoinColumn(name = "masanpham")
    private SanPham sanpham;

    @Column(name = "soluongmua")
    private Integer soluongmua;


    @Column(name = "dongia")
    private Float dongia;
}
