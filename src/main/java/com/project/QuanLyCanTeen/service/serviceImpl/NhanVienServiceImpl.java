package com.project.QuanLyCanTeen.service.serviceImpl;

import com.project.QuanLyCanTeen.dto.KhachHangDto;
import com.project.QuanLyCanTeen.entity.NhanVien;
import com.project.QuanLyCanTeen.repository.NhanVienRepo;
import com.project.QuanLyCanTeen.service.NhanVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class NhanVienServiceImpl implements NhanVienService {

    @Autowired
    private NhanVienRepo repo;


    @Override
    public NhanVien findByMaTaiKhoan(Long mataikhoan) {
        return repo.findByMaTaiKhoan(mataikhoan);
    }

    @Override
    @Transactional(rollbackOn = {Exception.class, Error.class})
    public void updateInfor(KhachHangDto dto) {
        repo.updateInfor(dto.getMaacc(), dto.getEmail(), dto.getDiachi(), dto.getHoten());
    }
}
