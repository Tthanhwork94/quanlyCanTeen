package com.project.QuanLyCanTeen.service.serviceImpl;

import com.project.QuanLyCanTeen.dto.PhieuNhapDto;
import com.project.QuanLyCanTeen.repository.PhieuNhapRepo;
import com.project.QuanLyCanTeen.service.PhieuNhapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class PhieuNhapServiceImpl implements PhieuNhapService {

    @Autowired
    private PhieuNhapRepo repo;

    @Override
    @Transactional(rollbackOn = {Error.class, Exception.class})
    public Integer insertPhieuNhap(Long manhanvien, Long manhacungung) {
        return repo.insertPhieuNhap(manhanvien,manhacungung);
    }
}
