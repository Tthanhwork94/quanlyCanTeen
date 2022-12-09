package com.project.QuanLyCanTeen.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChangePasswordDto {
    private Long mataikhoan;
    private String matkhaucu;
    private String matkhaumoi;
}
