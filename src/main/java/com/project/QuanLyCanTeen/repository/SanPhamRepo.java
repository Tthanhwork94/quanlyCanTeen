package com.project.QuanLyCanTeen.repository;

import com.project.QuanLyCanTeen.entity.SanPham;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SanPhamRepo extends JpaRepository<SanPham,Long> {

    @Modifying(clearAutomatically = true)
    @Query(value = "EXECUTE proc_nv_themsp :tensanpham,:soluongton,:gia,:nhacungung",nativeQuery = true)
    Integer insertSanPham(String tensanpham,Integer soluongton,Float gia,Long nhacungung);

    Page<SanPham> findAll(Pageable pageable);

    SanPham findByMasanpham(Long masanpham);

//    @Modifying(clearAutomatically = true)
    @Query(value = "EXECUTE proc_nv_chinhsuasanpham :masanpham,:tensanpham,:gia",nativeQuery = true)
    Integer updateSanPham(Long masanpham,String tensanpham,Float gia);

}
