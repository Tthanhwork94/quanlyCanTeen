package com.project.QuanLyCanTeen.service;

import com.project.QuanLyCanTeen.dto.ChangePasswordDto;
import com.project.QuanLyCanTeen.entity.TaiKhoan;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TaiKhoanService {


    ResponseEntity<TaiKhoan> doRegister(TaiKhoan taiKhoan);

    ResponseEntity<TaiKhoan> doLogin(TaiKhoan taiKhoan);

    TaiKhoan findByTenTaiKhoan(String tentaikhoan);

    Integer updateMatKhau(ChangePasswordDto dto);

    List<TaiKhoan> findAll();

    Integer updateTinhTrang(TaiKhoan taiKhoan);
}
