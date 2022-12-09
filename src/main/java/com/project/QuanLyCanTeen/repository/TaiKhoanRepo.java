package com.project.QuanLyCanTeen.repository;

import com.project.QuanLyCanTeen.entity.TaiKhoan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaiKhoanRepo extends JpaRepository<TaiKhoan,Long> {

    List<TaiKhoan> findAll();

    TaiKhoan save(TaiKhoan taiKhoan);

    TaiKhoan findByTentaikhoan(String tentaikhoan);

    TaiKhoan findByMataikhoan(Long mataikhoan);

    @Modifying(clearAutomatically = true)
    @Query(value = "EXECUTE  proc_TK_doiMatKhau :mataikhoan,:matkhaucu,:matkhaumoi",nativeQuery = true)
    Integer updateMatKhau(Long mataikhoan,String matkhaucu,String matkhaumoi);
}
