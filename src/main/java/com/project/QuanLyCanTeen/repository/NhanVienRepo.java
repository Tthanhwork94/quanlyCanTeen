package com.project.QuanLyCanTeen.repository;

import com.project.QuanLyCanTeen.entity.KhachHang;
import com.project.QuanLyCanTeen.entity.NhanVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface NhanVienRepo extends JpaRepository<NhanVien,Long> {

    @Query(value = "SELECT * from NhanVien where maacc=:mataikhoan",nativeQuery = true)
    NhanVien findByMaTaiKhoan(Long mataikhoan);

    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE NhanVien set email=:email,diachi=:diachi,hoten=:hoten where maacc=:maacc",nativeQuery = true)
    void updateInfor(Long maacc,String email, String diachi, String hoten);
}
