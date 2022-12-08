package com.project.QuanLyCanTeen.service.serviceImpl;

import com.project.QuanLyCanTeen.entity.NhaCungUng;
import com.project.QuanLyCanTeen.repository.NhaCungUngRepo;
import com.project.QuanLyCanTeen.service.NhaCungUngService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NhaCungUngServiceImpl implements NhaCungUngService {

    @Autowired
    private NhaCungUngRepo repo;

    @Override
    public List<NhaCungUng> findAll() {
        return repo.findAll();
    }
}
