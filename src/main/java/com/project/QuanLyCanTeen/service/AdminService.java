package com.project.QuanLyCanTeen.service;

import com.project.QuanLyCanTeen.dto.KhachHangDto;
import com.project.QuanLyCanTeen.entity.Admin;
import com.project.QuanLyCanTeen.entity.NhanVien;

public interface AdminService {

    Admin findByMaTaiKhoan(Long mataikhoan);
    void updateInfor(KhachHangDto dto);
}
