package com.project.QuanLyCanTeen.repository;

import com.project.QuanLyCanTeen.entity.NhaCungUng;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NhaCungUngRepo extends JpaRepository<NhaCungUng,Long> {
    List<NhaCungUng> findAll();
}
