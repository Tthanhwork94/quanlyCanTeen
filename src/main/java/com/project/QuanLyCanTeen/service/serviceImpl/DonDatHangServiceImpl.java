package com.project.QuanLyCanTeen.service.serviceImpl;

import com.project.QuanLyCanTeen.dto.DonDatDto;
import com.project.QuanLyCanTeen.repository.DonDatHangRepo;
import com.project.QuanLyCanTeen.service.DonDatHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class DonDatHangServiceImpl implements DonDatHangService {

    @Autowired
    private DonDatHangRepo repo;

    @Override
    @Transactional(rollbackOn = {Error.class, Exception.class})
    public Integer insertDonDatHang(DonDatDto dto) {
        return repo.insertDonDatHang(dto.getThoigiannhan(),dto.getMakhachhang());
    }
}
