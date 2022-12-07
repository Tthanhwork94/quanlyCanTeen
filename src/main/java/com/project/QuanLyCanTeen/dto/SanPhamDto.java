package com.project.QuanLyCanTeen.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SanPhamDto {
    private Long masanpham;
    private String tensanpham;
    private Integer soluongton;
    private Float gia;
    private Long manhacungung;
}
