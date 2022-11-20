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
    private Long maPhieuNhap;

    @Column(name = "ngaynhap")
    @CreationTimestamp
    private Timestamp ngayNhap;

    @Column(name = "tongtien")
    private Float tongTien;

    @Column(name = "soluongnhap")
    private Integer soLuongNhap;

    @Transient
    private Float giaNhap;

    @ManyToOne
    @JoinColumn(name = "manhanviennhap",referencedColumnName = "manhanvien")
    private NhanVien nhanVien;

    @ManyToOne
    @JoinColumn(name = "manhacungung",referencedColumnName = "manhacungung")
    private NhaCungUng nhaCungUng;
}
