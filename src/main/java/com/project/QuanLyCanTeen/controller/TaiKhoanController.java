package com.project.QuanLyCanTeen.controller;


import com.project.QuanLyCanTeen.dto.ChangePasswordDto;
import com.project.QuanLyCanTeen.entity.TaiKhoan;
import com.project.QuanLyCanTeen.repository.TaiKhoanRepo;
import com.project.QuanLyCanTeen.service.TaiKhoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping("")
    public ResponseEntity<?> changePassword(@RequestBody ChangePasswordDto dto){
        System.out.println(dto.getMataikhoan());
        System.out.println(dto.getMatkhaucu());
        System.out.println(dto.getMatkhaumoi());
        Integer flag=taiKhoanService.updateMatKhau(dto);
        if (flag == -1){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(-1);
        }
        return ResponseEntity.ok(1);
    }

    @GetMapping("")
    public ResponseEntity<?> getAll(){
        try{
            return ResponseEntity.ok(taiKhoanService.findAll());
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(-1);
        }
    }

    @PutMapping("tinhtrang")
    public ResponseEntity<?> updateTinhTrang(@RequestBody TaiKhoan taiKhoan){
        try{
            return ResponseEntity.ok(taiKhoanService.updateTinhTrang(taiKhoan));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(-1);
        }
    }
}
