package com.project.QuanLyCanTeen.service.serviceImpl;

import com.project.QuanLyCanTeen.entity.ChiTietPhieuNhap;
import com.project.QuanLyCanTeen.repository.ChiTietPhieuNhapRepo;
import com.project.QuanLyCanTeen.service.ChiTietPhieuNhapService;
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

    @Override
    @Transactional(rollbackOn = {Exception.class, Error.class})
    public ResponseEntity<?> insertChiTietPhieuNhap(List<ChiTietPhieuNhap> danhsach) {
        Integer flag = 1;
        for(ChiTietPhieuNhap c : danhsach){
            flag = repo.insertChiTiet(c.getMaPhieuNhap(), c.getMasanpham(), c.getDongianhap(), c.getSoluongnhap());
            if (flag == -1){
                break;
            }
        }
        return ResponseEntity.status(HttpStatus.OK).body(flag);
    }
}
