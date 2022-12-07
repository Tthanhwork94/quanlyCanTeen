package com.project.QuanLyCanTeen.service.serviceImpl;

import com.project.QuanLyCanTeen.dto.SanPhamDto;
import com.project.QuanLyCanTeen.entity.SanPham;
import com.project.QuanLyCanTeen.repository.SanPhamRepo;
import com.project.QuanLyCanTeen.service.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class SanPhamServiceImpl implements SanPhamService {

    @Autowired
    private SanPhamRepo repo;

    @Override
    @Transactional(rollbackOn = {Error.class, Exception.class})
    public Integer insertSanPham(SanPhamDto dto) {
        try{
            return repo.insertSanPham(dto.getTensanpham(), dto.getSoluongton(), dto.getGia(), dto.getManhacungung());
        }catch (Exception e){
            e.printStackTrace();
            return -1;
        }
    }
}
