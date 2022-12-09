package com.project.QuanLyCanTeen.repository;


import com.project.QuanLyCanTeen.entity.DonDatHang;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DonDatHangRepo extends JpaRepository<DonDatHang,Long> {


    @Query(value = "Execute proc_kh_themdondat :thoigiannhan,:makhachhang",nativeQuery = true)
    Integer insertDonDatHang(String thoigiannhan,Long makhachhang);

    @Query(value = "select * from DonDatHang where makhachhang = :makhachhang",nativeQuery = true)
    List<DonDatHang> findDonDatHangByMaKhachhang(Long makhachhang);
}
