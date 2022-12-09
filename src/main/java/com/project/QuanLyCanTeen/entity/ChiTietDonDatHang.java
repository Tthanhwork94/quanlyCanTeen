package com.project.QuanLyCanTeen.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "chitietdondathang")
@IdClass(ChiTietDonDatHang.class)
public class ChiTietDonDatHang implements Serializable {

    @Id
    @Column(name = "madondathang")
    private Long madondathang;

    @Id
    @Column(name = "masanpham")
    private Long masanpham;

    @Transient
    private String tensanpham;

    @Column(name = "soluongmua")
    private Integer soluongmua;


    @Column(name = "dongia")
    private Float dongia;

}
