package com.project.QuanLyCanTeen.repository;

import com.project.QuanLyCanTeen.entity.ChiTietPhieuNhap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ChiTietPhieuNhapRepo extends JpaRepository<ChiTietPhieuNhap,Long> {

    @Query(value = "SELECT * from ChiTietPhieuNhap ",nativeQuery = true)
    List<ChiTietPhieuNhap> findAll();


    @Query(value = "EXECUTE proc_nv_themctphieunhap :maphieunhap,:masanpham,:gia,:soluong",nativeQuery = true)
    Integer insertChiTiet(Long maphieunhap,Long masanpham,Float gia,Integer soluong);
}
