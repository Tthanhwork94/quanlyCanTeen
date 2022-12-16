package com.project.QuanLyCanTeen.controller;

import com.project.QuanLyCanTeen.dto.DonDatDto;
import com.project.QuanLyCanTeen.dto.KhachHangDto;
import com.project.QuanLyCanTeen.entity.ChiTietDonDatHang;
import com.project.QuanLyCanTeen.entity.KhachHang;
import com.project.QuanLyCanTeen.service.ChiTietDonDatHangService;
import com.project.QuanLyCanTeen.service.DonDatHangService;
import com.project.QuanLyCanTeen.service.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @Autowired
    private KhachHangService khachHangService;

    @PostMapping("dondathang")
    public ResponseEntity<?> insertDonDatHang(@RequestBody DonDatDto dto){
        System.out.println(dto.getThoigiannhan());
        System.out.println(dto.getMakhachhang());
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

    @GetMapping("khachhang/{mataikhoan}")
    public KhachHang getKhachHang(@PathVariable("mataikhoan") Long mataikhoan){
        return khachHangService.findKhachHangByMaTaiKhoan(mataikhoan);
    }

    @PutMapping("khachhang")
    public ResponseEntity<?> updateKhachHang(@RequestBody KhachHangDto khachHang){
        System.out.println(khachHang.getHoten());
        System.out.println(khachHang.getMaacc());
        System.out.println(khachHang.getEmail());
        System.out.println(khachHang.getDiachi());
        try {
            khachHangService.updateInfor(khachHang);
            return ResponseEntity.ok(1);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(-1);
        }
    }
}
