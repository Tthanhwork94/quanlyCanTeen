package com.project.QuanLyCanTeen.controller;

import com.project.QuanLyCanTeen.service.NhaCungUngService;
import com.project.QuanLyCanTeen.service.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.project.QuanLyCanTeen.Constant.Constant.ELEMENT_PER_PAGE;

@RestController
@RequestMapping("api")
public class GetController {

    @Autowired
    private NhaCungUngService nhaCungUngService;

    @Autowired
    private SanPhamService sanPhamService;

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

    @GetMapping("sanpham/{masanpham}")
    public ResponseEntity<?> getChiTietSanPham(@PathVariable Long masanpham){
        return ResponseEntity.status(HttpStatus.OK).body(sanPhamService.findByMaSanPham(masanpham));
    }
}
