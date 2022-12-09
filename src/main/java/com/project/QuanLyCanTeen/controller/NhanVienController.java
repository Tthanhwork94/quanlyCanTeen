package com.project.QuanLyCanTeen.controller;

import com.project.QuanLyCanTeen.dto.KhachHangDto;
import com.project.QuanLyCanTeen.dto.PhieuNhapDto;
import com.project.QuanLyCanTeen.dto.SanPhamDto;
import com.project.QuanLyCanTeen.entity.ChiTietPhieuNhap;
import com.project.QuanLyCanTeen.entity.NhanVien;
import com.project.QuanLyCanTeen.entity.PhieuNhap;
import com.project.QuanLyCanTeen.service.ChiTietPhieuNhapService;
import com.project.QuanLyCanTeen.service.NhanVienService;
import com.project.QuanLyCanTeen.service.PhieuNhapService;
import com.project.QuanLyCanTeen.service.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class NhanVienController {

    @Autowired
    private SanPhamService sanPhamService;

    @Autowired
    private PhieuNhapService phieuNhapService;

    @Autowired
    private ChiTietPhieuNhapService chiTietPhieuNhapService;


    @Autowired
    private NhanVienService nhanVienService;

    @PostMapping("/sanpham")
    public ResponseEntity<Integer> insertSanPham(@RequestBody SanPhamDto dto){
        System.out.println(dto.getTensanpham());
        System.out.println(dto.getGia());
        try{
            Integer flag= sanPhamService.insertSanPham(dto);
            if(flag==-1){
               return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(-1);
            }
            return ResponseEntity.status(HttpStatus.CREATED).body(1);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(-1); // 406
        }
    }

    @PostMapping("/phieunhap")
    public ResponseEntity<?> insertPhieuNhap(@RequestBody PhieuNhapDto dto){
        System.out.println(dto.getManhanvien());
        System.out.println(dto.getManhacungung());
        try{
            Integer flag = phieuNhapService.insertPhieuNhap(dto.getManhanvien(), dto.getManhacungung());
            System.out.println(flag);
            if(flag != null && flag == -1){
                return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(-1); //400
            }else{
                return  ResponseEntity.status(HttpStatus.CREATED).body(flag); //201
            }
        }catch (Exception e){
            e.printStackTrace();
            return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(-1); //400
        }
    }

    @PostMapping("/chitietphieunhap")
    public ResponseEntity<?> insertChiTietPhieuNhap(@RequestBody List<ChiTietPhieuNhap> danhsach){
        for(ChiTietPhieuNhap c : danhsach){
            System.out.println(c.getMaPhieuNhap());
            System.out.println(c.getMasanpham());
            System.out.println(c.getDongianhap());
            System.out.println(c.getSoluongnhap());
        }
        return chiTietPhieuNhapService.insertChiTietPhieuNhap(danhsach);
    }

    @GetMapping("nhanvien/{mataikhoan}")
    public NhanVien getNhanVien(@PathVariable("mataikhoan") Long mataikhoan){
        return nhanVienService.findByMaTaiKhoan(mataikhoan);
    }

    @PutMapping("nhanvien")
    public ResponseEntity<?> updateKhachHang(@RequestBody KhachHangDto dto){
        System.out.println(dto.getHoten());
        System.out.println(dto.getMaacc());
        System.out.println(dto.getEmail());
        System.out.println(dto.getDiachi());
        try {
            nhanVienService.updateInfor(dto);
            return ResponseEntity.ok(1);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(-1);
        }

    }
}
