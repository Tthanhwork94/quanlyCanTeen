package com.project.QuanLyCanTeen.service.serviceImpl;

import com.project.QuanLyCanTeen.repository.KhachHangRepo;
import com.project.QuanLyCanTeen.service.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KhachHangServiceImpl implements KhachHangService {

    @Autowired
    private KhachHangRepo repo;


    @Override
    public Long findMaKhachHangByMaTaiKhoan(Long mataikhoan) {
        return repo.findMaKhachHangByMaTaiKhoan(mataikhoan);
    }
}
