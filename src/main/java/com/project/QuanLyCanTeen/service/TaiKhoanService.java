package com.project.QuanLyCanTeen.service;

import com.project.QuanLyCanTeen.entity.TaiKhoan;
import org.springframework.http.ResponseEntity;

public interface TaiKhoanService {


    ResponseEntity<TaiKhoan> doRegister(TaiKhoan taiKhoan);

    ResponseEntity<TaiKhoan> doLogin(TaiKhoan taiKhoan);

    TaiKhoan findByTenTaiKhoan(String tentaikhoan);
}
