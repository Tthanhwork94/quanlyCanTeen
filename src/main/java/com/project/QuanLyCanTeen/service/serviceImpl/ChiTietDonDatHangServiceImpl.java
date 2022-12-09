package com.project.QuanLyCanTeen.service.serviceImpl;

import com.project.QuanLyCanTeen.entity.ChiTietDonDatHang;
import com.project.QuanLyCanTeen.repository.ChiTietDonDatHangRepo;
import com.project.QuanLyCanTeen.service.ChiTietDonDatHangService;
import com.project.QuanLyCanTeen.service.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ChiTietDonDatHangServiceImpl implements ChiTietDonDatHangService {

    @Autowired
    private ChiTietDonDatHangRepo repo;

    @Autowired
    private SanPhamService sanPhamService;

    @Override
    @Transactional(rollbackOn = {Exception.class, Error.class})
    public ResponseEntity<Integer> insertChiTietDonHang(List<ChiTietDonDatHang> danhsach) {
        Integer flag=1;
        for(ChiTietDonDatHang c:danhsach){
            flag = repo.insertChiTiet(c.getMadondathang(), c.getMasanpham(), c.getDongia(),c.getSoluongmua());
            if(flag == -1){
                break;
            }
        }
        return ResponseEntity.status(HttpStatus.OK).body(flag);
    }

    @Override
    public ResponseEntity<?> findDonDatHangChiTietByMa(Long madondathang) {
        List<ChiTietDonDatHang> danhsach=repo.findByMaDonHang(madondathang);
        for(ChiTietDonDatHang c : danhsach){
            c.setTensanpham(sanPhamService.findByMaSanPham(c.getMasanpham()).getTensanpham());
        }
        return ResponseEntity.ok(danhsach);
    }
}
