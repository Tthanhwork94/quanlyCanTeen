package com.project.QuanLyCanTeen.service.serviceImpl;

import com.project.QuanLyCanTeen.dto.KhachHangDto;
import com.project.QuanLyCanTeen.entity.KhachHang;
import com.project.QuanLyCanTeen.repository.KhachHangRepo;
import com.project.QuanLyCanTeen.service.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class KhachHangServiceImpl implements KhachHangService {

    @Autowired
    private KhachHangRepo repo;


    @Override
    public Long findMaKhachHangByMaTaiKhoan(Long mataikhoan) {
        return repo.findMaKhachHangByMaTaiKhoan(mataikhoan);
    }

    @Override
    public KhachHang findKhachHangByMaTaiKhoan(Long mataikhoan) {
        return repo.findByMaTaiKhoan(mataikhoan);
    }

    @Override
    @Transactional(rollbackOn = {Exception.class, Error.class})
    public void updateInfor(KhachHangDto dto) {
        repo.updateInfor(dto.getMaacc(), dto.getEmail(), dto.getDiachi(), dto.getHoten());
    }
}
