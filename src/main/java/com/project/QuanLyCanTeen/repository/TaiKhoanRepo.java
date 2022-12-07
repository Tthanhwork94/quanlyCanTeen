package com.project.QuanLyCanTeen.repository;

import com.project.QuanLyCanTeen.entity.TaiKhoan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaiKhoanRepo extends JpaRepository<TaiKhoan,Long> {

    List<TaiKhoan> findAll();

    @Query(value = "EXECUTE proc_dangky :tentaikhoan,:matkhau,:loaitaikhoan",nativeQuery = true)
    Integer dangKy(String tentaikhoan,String matkhau,String loaitaikhoan);
}
