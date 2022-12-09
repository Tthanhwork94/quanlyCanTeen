package com.project.QuanLyCanTeen.service;

import com.project.QuanLyCanTeen.entity.ChiTietDonDatHang;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ChiTietDonDatHangService {
    ResponseEntity<Integer> insertChiTietDonHang(List<ChiTietDonDatHang> danhsach);

    ResponseEntity<?> findDonDatHangChiTietByMa(Long madondathang);
}
