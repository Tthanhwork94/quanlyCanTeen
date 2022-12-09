package com.project.QuanLyCanTeen.service;

import com.project.QuanLyCanTeen.dto.KhachHangDto;
import com.project.QuanLyCanTeen.entity.NhanVien;

public interface NhanVienService {

    NhanVien findByMaTaiKhoan(Long mataikhoan);

    void updateInfor(KhachHangDto dto);
}
