package com.project.QuanLyCanTeen.controller;


import com.project.QuanLyCanTeen.dto.KhachHangDto;
import com.project.QuanLyCanTeen.entity.Admin;
import com.project.QuanLyCanTeen.entity.NhanVien;
import com.project.QuanLyCanTeen.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("admin/{mataikhoan}")
    public Admin getAdmin(@PathVariable("mataikhoan") Long mataikhoan){
        return adminService.findByMaTaiKhoan(mataikhoan);
    }

    @PutMapping("admin")
    public ResponseEntity<?> updateKhachHang(@RequestBody KhachHangDto dto){
        System.out.println(dto.getHoten());
        System.out.println(dto.getMaacc());
        System.out.println(dto.getEmail());
        System.out.println(dto.getDiachi());
        try {
            adminService.updateInfor(dto);
            return ResponseEntity.ok(1);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(-1);
        }

    }
}
