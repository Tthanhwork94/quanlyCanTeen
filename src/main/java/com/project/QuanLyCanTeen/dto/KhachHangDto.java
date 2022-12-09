package com.project.QuanLyCanTeen.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class KhachHangDto {

    private Long maacc;
    private String email;
    private String hoten;
    private String diachi;
}
