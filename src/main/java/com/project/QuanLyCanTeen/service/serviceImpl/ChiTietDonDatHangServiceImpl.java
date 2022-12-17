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
        try{
            for(ChiTietDonDatHang c:danhsach){
                System.out.println(c.getMadondathang());
                System.out.println(c.getTensanpham());
                System.out.println(c.getSoluongmua());
                repo.insertChiTiet(c.getMadondathang(), c.getMasanpham(), c.getDongia(),c.getSoluongmua());
                sanPhamService.updateSoLuongTon(c.getMasanpham(),-c.getSoluongmua());
            }
            return ResponseEntity.status(HttpStatus.OK).body(1);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(-1);
        }

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
