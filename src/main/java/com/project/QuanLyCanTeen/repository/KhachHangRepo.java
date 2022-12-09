package com.project.QuanLyCanTeen.repository;

import com.project.QuanLyCanTeen.entity.KhachHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface KhachHangRepo extends JpaRepository<KhachHang,Long> {

    @Query(value = "SELECT makhachhang from KhachHang where maacc=:mataikhoan",nativeQuery = true)
    Long findMaKhachHangByMaTaiKhoan(Long mataikhoan);
}
