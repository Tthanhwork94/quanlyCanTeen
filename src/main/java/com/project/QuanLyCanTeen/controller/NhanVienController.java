package com.project.QuanLyCanTeen.controller;

import com.project.QuanLyCanTeen.dto.SanPhamDto;
import com.project.QuanLyCanTeen.service.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/nhanvien")
public class NhanVienController {

    @Autowired
    private SanPhamService sanPhamService;

    @PostMapping("/sanpham")
    public ResponseEntity<Integer> insertSanPham(@RequestBody SanPhamDto dto){
        System.out.println(dto.getTensanpham());
        System.out.println(dto.getGia());
        try{
            Integer flag= sanPhamService.insertSanPham(dto);
            return flag == -1 ? ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(-1) : ResponseEntity.status(HttpStatus.CREATED).body(1);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(-1); // 406
        }
    }
}
