package com.project.QuanLyCanTeen.repository;

import com.project.QuanLyCanTeen.entity.Admin;
import com.project.QuanLyCanTeen.entity.NhanVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface AdminRepo extends JpaRepository<Admin,Long> {

    @Query(value = "SELECT * from Admin where maacc=:mataikhoan",nativeQuery = true)
    Admin findByMaTaiKhoan(Long mataikhoan);

    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE Admin set email=:email,diachi=:diachi,hoten=:hoten where maacc=:maacc",nativeQuery = true)
    void updateInfor(Long maacc,String email, String diachi, String hoten);
}
