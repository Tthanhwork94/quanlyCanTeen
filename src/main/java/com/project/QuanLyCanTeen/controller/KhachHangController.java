package com.project.QuanLyCanTeen.controller;

import com.project.QuanLyCanTeen.dto.DonDatDto;
import com.project.QuanLyCanTeen.entity.ChiTietDonDatHang;
import com.project.QuanLyCanTeen.service.ChiTietDonDatHangService;
import com.project.QuanLyCanTeen.service.DonDatHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.project.QuanLyCanTeen.Constant.Constant.ELEMENT_PER_PAGE;

@RestController
@RequestMapping("api")
public class KhachHangController {

    @Autowired
    private DonDatHangService donDatHangService;

    @Autowired
    private ChiTietDonDatHangService chiTietDonDatHangService;

    @PostMapping("dondathang")
    public ResponseEntity<?> insertDonDatHang(@RequestBody DonDatDto dto){
        return ResponseEntity.ok(donDatHangService.insertDonDatHang(dto));
    }

    @PostMapping("donhangchitiet")
    public ResponseEntity<?> insertDonHangChiTiet(@RequestBody List<ChiTietDonDatHang> danhsach){
        return chiTietDonDatHangService.insertChiTietDonHang(danhsach);
    }

    @GetMapping("khachhang/{mataikhoan}/dondathang")
    public ResponseEntity<?> findDonDatHang(@PathVariable("mataikhoan") Long mataikhoan ){
        return ResponseEntity.ok(donDatHangService.findDonDatHangByMaTaiKhoan(mataikhoan));
    }

    @GetMapping("dondathang/{madondathang}")
    public ResponseEntity<?> chitietDonHang(@PathVariable("madondathang") Long madondathang){
        return chiTietDonDatHangService.findDonDatHangChiTietByMa(madondathang);
    }
}
