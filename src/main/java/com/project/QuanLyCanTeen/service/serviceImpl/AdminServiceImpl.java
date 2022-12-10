package com.project.QuanLyCanTeen.service.serviceImpl;

import com.project.QuanLyCanTeen.dto.KhachHangDto;
import com.project.QuanLyCanTeen.entity.Admin;
import com.project.QuanLyCanTeen.entity.NhanVien;
import com.project.QuanLyCanTeen.repository.AdminRepo;
import com.project.QuanLyCanTeen.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepo repo;


    @Override
    public Admin findByMaTaiKhoan(Long mataikhoan) {
        return repo.findByMaTaiKhoan(mataikhoan);
    }

    @Override
    @Transactional(rollbackOn = {Exception.class, Error.class})
    public void updateInfor(KhachHangDto dto) {
        repo.updateInfor(dto.getMaacc(), dto.getEmail(), dto.getDiachi(), dto.getHoten());
    }
}
