package com.project.QuanLyCanTeen.controller;


import com.project.QuanLyCanTeen.entity.TaiKhoan;
import com.project.QuanLyCanTeen.repository.TaiKhoanRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/taikhoan")
public class TaiKhoanController {

    @Autowired
    TaiKhoanRepo repo;


    @GetMapping("")
    public List<TaiKhoan> test(){
        return repo.findAll();
    }
}
