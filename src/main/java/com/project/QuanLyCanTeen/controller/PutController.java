package com.project.QuanLyCanTeen.controller;


import com.project.QuanLyCanTeen.dto.DonDatDto;
import com.project.QuanLyCanTeen.dto.SanPhamDto;
import com.project.QuanLyCanTeen.service.DonDatHangService;
import com.project.QuanLyCanTeen.service.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class PutController {

    @Autowired
    private SanPhamService sanPhamService;

    @Autowired
    private DonDatHangService donDatHangService;

    @PutMapping("sanpham")
    public ResponseEntity<?> updateSanPham(@RequestBody SanPhamDto dto){
        System.out.println(dto.getMasanpham());
        System.out.println(dto.getTensanpham());
        System.out.println(dto.getGia());
        Integer flag=sanPhamService.updateSanPham(dto);
        if (flag==1){
            return ResponseEntity.status(HttpStatus.OK).body(1);
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(-1); //400
        }

    }

    @PutMapping("dondathang")
    public Integer xacnhandon(@RequestBody DonDatDto dto){
        System.out.println(dto.getMadondathang());
        try{
            donDatHangService.xacnhandon(dto.getMadondathang());
            return 1;
        }catch (Exception e){
            return -1;
        }

    }
}
