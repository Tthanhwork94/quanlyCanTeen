package com.project.QuanLyCanTeen.controller;

import com.project.QuanLyCanTeen.entity.ChiTietPhieuNhap;
import com.project.QuanLyCanTeen.entity.DonDatHang;
import com.project.QuanLyCanTeen.repository.ChiTietPhieuNhapRepo;
import com.project.QuanLyCanTeen.service.DonDatHangService;
import com.project.QuanLyCanTeen.service.NhaCungUngService;
import com.project.QuanLyCanTeen.service.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.project.QuanLyCanTeen.Constant.Constant.ELEMENT_PER_PAGE;

@RestController
@RequestMapping("api")
public class GetController {

    @Autowired
    private NhaCungUngService nhaCungUngService;

    @Autowired
    private SanPhamService sanPhamService;

    @Autowired
    private DonDatHangService donDatHangService;

    @GetMapping("/nhacungung")
    public ResponseEntity<?> getAllNhaCungUng(){
        return ResponseEntity.status(HttpStatus.OK).body(nhaCungUngService.findAll());
    }


    @GetMapping("sanpham")
    public ResponseEntity<?> getSanPham(@RequestParam(defaultValue = "1") Integer page){
        return ResponseEntity.status(HttpStatus.OK).body(sanPhamService.findAll(page,ELEMENT_PER_PAGE).getContent());
    }

    @GetMapping("sanpham/totalpage")
    public ResponseEntity<?> getTotalPage(){
        return ResponseEntity.status(HttpStatus.OK).body(sanPhamService.findAll(1,ELEMENT_PER_PAGE).getTotalPages());
    }

    @GetMapping("dondathang")
    public List<DonDatHang> getAllDonDatHang(){
        return donDatHangService.findAll();
    }

    @GetMapping("sanpham/{masanpham}")
    public ResponseEntity<?> getChiTietSanPham(@PathVariable Long masanpham){
        return ResponseEntity.status(HttpStatus.OK).body(sanPhamService.findByMaSanPham(masanpham));
    }


}
