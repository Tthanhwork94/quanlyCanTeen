package com.project.QuanLyCanTeen.service;

import com.project.QuanLyCanTeen.dto.KhachHangDto;
import com.project.QuanLyCanTeen.entity.KhachHang;

public interface KhachHangService {

    Long findMaKhachHangByMaTaiKhoan(Long mataikhoan);

    KhachHang findKhachHangByMaTaiKhoan(Long mataikhoan);

    void updateInfor(KhachHangDto dto);
}
