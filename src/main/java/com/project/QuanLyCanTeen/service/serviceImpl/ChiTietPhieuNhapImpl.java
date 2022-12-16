package com.project.QuanLyCanTeen.service.serviceImpl;

import com.project.QuanLyCanTeen.entity.ChiTietPhieuNhap;
import com.project.QuanLyCanTeen.repository.ChiTietPhieuNhapRepo;
import com.project.QuanLyCanTeen.service.ChiTietPhieuNhapService;
import com.project.QuanLyCanTeen.service.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ChiTietPhieuNhapImpl implements ChiTietPhieuNhapService {


    @Autowired
    private ChiTietPhieuNhapRepo repo;

    @Autowired
    private SanPhamService sanPhamService;

    @Override
    @Transactional(rollbackOn = {Exception.class, Error.class})
    public ResponseEntity<?> insertChiTietPhieuNhap(List<ChiTietPhieuNhap> danhsach) {
        try{
            Integer flag = 1;
            for(ChiTietPhieuNhap c : danhsach){
                repo.insertChiTiet(c.getMaPhieuNhap(), c.getMasanpham(), c.getDongianhap(), c.getSoluongnhap());
                sanPhamService.updateSoLuongTon(c.getMasanpham(),c.getSoluongnhap());
            }
            return ResponseEntity.status(HttpStatus.OK).body(flag);
        }catch (Exception e){
            e.printStackTrace();
            return  ResponseEntity.status(HttpStatus.CONFLICT).body(-1);
        }

    }
}
