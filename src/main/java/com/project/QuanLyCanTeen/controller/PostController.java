package com.project.QuanLyCanTeen.controller;


import com.project.QuanLyCanTeen.dto.SanPhamDto;
import com.project.QuanLyCanTeen.entity.TaiKhoan;
import com.project.QuanLyCanTeen.service.SanPhamService;
import com.project.QuanLyCanTeen.service.TaiKhoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("api")
public class PostController {

    @Autowired
    private TaiKhoanService taiKhoanService;


    @PostMapping("/register")
    public ResponseEntity<TaiKhoan> doRegister(@RequestBody TaiKhoan taiKhoan){

        System.out.println(taiKhoan.getTentaikhoan());
        System.out.println(taiKhoan.getMatkhau());
        System.out.println(taiKhoan.getLoaitaikhoan());
        return taiKhoanService.doRegister(taiKhoan);

    }

    @PostMapping("/login")
    public ResponseEntity<TaiKhoan> doLogin(@RequestBody TaiKhoan taiKhoan){
        return taiKhoanService.doLogin(taiKhoan);
    }

}
