package com.project.QuanLyCanTeen.controller;


import com.project.QuanLyCanTeen.entity.TaiKhoan;
import com.project.QuanLyCanTeen.repository.TaiKhoanRepo;
import com.project.QuanLyCanTeen.service.TaiKhoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/taikhoan")
public class TaiKhoanController {

    @Autowired
    private TaiKhoanService taiKhoanService;

    @GetMapping("/{tentaikhoan}")
    public ResponseEntity<TaiKhoan> getByTenTaiKhoan(@PathVariable("tentaikhoan") String tentaikhoan){
        return ResponseEntity.status(HttpStatus.OK).body(taiKhoanService.findByTenTaiKhoan(tentaikhoan));
    }
}
