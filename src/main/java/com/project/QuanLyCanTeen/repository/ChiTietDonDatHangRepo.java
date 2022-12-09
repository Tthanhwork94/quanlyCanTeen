package com.project.QuanLyCanTeen.repository;

import com.project.QuanLyCanTeen.entity.ChiTietDonDatHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;


@Repository
public interface ChiTietDonDatHangRepo extends JpaRepository<ChiTietDonDatHang,Long> {



    @Query(value = "Execute proc_kh_themchitietdon :madondathang,:masanpham,:dongia,:soluong",nativeQuery = true)
    Integer insertChiTiet(Long madondathang,Long masanpham,Float dongia,Integer soluong);

    @Query(value = "select * from ChiTietDonDatHang where madondathang=:madondathang",nativeQuery = true)
    List<ChiTietDonDatHang> findByMaDonHang(Long madondathang);
}