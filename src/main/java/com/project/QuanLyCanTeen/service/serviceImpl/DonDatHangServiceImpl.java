package com.project.QuanLyCanTeen.service.serviceImpl;

import com.project.QuanLyCanTeen.dto.DonDatDto;
import com.project.QuanLyCanTeen.entity.DonDatHang;
import com.project.QuanLyCanTeen.entity.SanPham;
import com.project.QuanLyCanTeen.repository.DonDatHangRepo;
import com.project.QuanLyCanTeen.service.DonDatHangService;
import com.project.QuanLyCanTeen.service.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class DonDatHangServiceImpl implements DonDatHangService {

    @Autowired
    private DonDatHangRepo repo;

    @Autowired
    private KhachHangService khachHangService;

    @Override
    @Transactional(rollbackOn = {Error.class, Exception.class})
    public Integer insertDonDatHang(DonDatDto dto) {
        return repo.insertDonDatHang(dto.getThoigiannhan(),dto.getMakhachhang());
    }

    @Override
    public List<DonDatHang> findDonDatHangByMaTaiKhoan(Long mataikhoan) {
        return repo.findDonDatHangByMaKhachhang(khachHangService.findMaKhachHangByMaTaiKhoan(mataikhoan));
    }

    @Override
    public List<DonDatHang> findAll() {
        return repo.findAll();
    }

    @Override
    public void xacnhandon(Long madonhang) {
        repo.xacnhandon(madonhang);
    }

    @Override
    public void thanhtoan(Long madonhang) {
        repo.thanhtoan(madonhang);
    }


}
