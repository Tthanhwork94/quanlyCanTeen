package com.project.QuanLyCanTeen.repository;

import com.project.QuanLyCanTeen.dto.PhieuNhapDto;
import com.project.QuanLyCanTeen.entity.PhieuNhap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;


public interface PhieuNhapRepo extends JpaRepository<PhieuNhap,Long> {

//    @Modifying(clearAutomatically = true)
    @Query(value = "EXECUTE proc_nv_themphieunhap :manhanvien,:manhacungung",nativeQuery = true)
    Integer insertPhieuNhap(Long manhanvien, Long manhacungung);
}
