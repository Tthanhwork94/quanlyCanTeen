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
    private Long masanpham;

    @Column(name = "tensanpham")
    private String tensanpham;

    @Column(name = "soluongton")
    private Integer soluongton;

    @Column(name = "gia")
    private Float gia;

    @OneToOne
    @JoinColumn(name = "manhacungung",referencedColumnName = "manhacungung")
    private NhaCungUng nhacungung;
}
