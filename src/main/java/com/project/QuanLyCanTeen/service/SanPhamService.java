package com.project.QuanLyCanTeen.service;

import com.project.QuanLyCanTeen.dto.SanPhamDto;
import com.project.QuanLyCanTeen.entity.SanPham;
import org.springframework.data.domain.Page;

import java.util.List;

public interface SanPhamService {

    Integer insertSanPham(SanPhamDto dto);

    Page<SanPham> findAll(Integer pageIndex, Integer elementPerPage);

    SanPham findByMaSanPham(Long masanpham);

    Integer updateSanPham(SanPhamDto dto);


}
