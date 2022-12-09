package com.project.QuanLyCanTeen.service;

import com.project.QuanLyCanTeen.dto.DonDatDto;
import com.project.QuanLyCanTeen.entity.DonDatHang;
import org.jboss.jandex.Index;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface DonDatHangService {
    Integer insertDonDatHang(DonDatDto dto);

    List<DonDatHang> findDonDatHangByMaTaiKhoan(Long mataikhoan);
}
