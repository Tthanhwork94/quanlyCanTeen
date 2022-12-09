package com.project.QuanLyCanTeen.service;

import com.project.QuanLyCanTeen.entity.ChiTietPhieuNhap;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ChiTietPhieuNhapService {
    ResponseEntity<?> insertChiTietPhieuNhap(List<ChiTietPhieuNhap> danhsach);
}
