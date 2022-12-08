package com.project.QuanLyCanTeen.service.serviceImpl;

import com.project.QuanLyCanTeen.dto.SanPhamDto;
import com.project.QuanLyCanTeen.entity.SanPham;
import com.project.QuanLyCanTeen.repository.SanPhamRepo;
import com.project.QuanLyCanTeen.service.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

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

    @Override
    public Page<SanPham> findAll(Integer pageIndex, Integer elementPerPage) {
        return  repo.findAll(PageRequest.of(pageIndex-1,elementPerPage));
    }

    @Override
    public SanPham findByMaSanPham(Long masanpham) {
        return repo.findByMasanpham(masanpham);
    }

    @Override
    @Transactional(rollbackOn = {Error.class, Exception.class})
    public Integer updateSanPham(SanPhamDto dto) {
        try{
            return repo.updateSanPham(dto.getMasanpham(), dto.getTensanpham(), dto.getGia());
        }catch (Exception e){
            e.printStackTrace();
            return -1;
        }

    }
}
