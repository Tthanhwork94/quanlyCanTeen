package com.project.QuanLyCanTeen.entity;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "sanpham")
@Data
public class SanPham {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "masanpham")
    private Long maSanPham;

    @Column(name = "tensanpham")
    private String tenSanPham;

    @Column(name = "soluongton")
    private Integer soLuongTon;

    @Column(name = "gia")
    private Float gia;

    @OneToOne
    @JoinColumn(name = "manhacungung",referencedColumnName = "manhacungung")
    private NhaCungUng nhaCungUng;
}
