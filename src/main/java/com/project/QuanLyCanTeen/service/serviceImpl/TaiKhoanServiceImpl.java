package com.project.QuanLyCanTeen.service.serviceImpl;

import com.project.QuanLyCanTeen.dto.ChangePasswordDto;
import com.project.QuanLyCanTeen.entity.TaiKhoan;
import com.project.QuanLyCanTeen.repository.TaiKhoanRepo;
import com.project.QuanLyCanTeen.service.TaiKhoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class TaiKhoanServiceImpl implements TaiKhoanService {

    private BCryptPasswordEncoder bCrypt=new BCryptPasswordEncoder();


    @Autowired
    private TaiKhoanRepo repo;

    @Override
    @Transactional(rollbackOn = {Exception.class, Error.class})
    public ResponseEntity<TaiKhoan> doLogin(TaiKhoan taiKhoan) {
        TaiKhoan taiKhoandb=repo.findByTentaikhoan(taiKhoan.getTentaikhoan());
        try {
            //not exist
            if(taiKhoandb == null){
                System.out.println("chua ton tai");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(taiKhoan); //404
            }else{
                Boolean flag = bCrypt.matches(taiKhoan.getMatkhau(), taiKhoandb.getMatkhau());
                if (flag == true){
                    System.out.println("dang nhap thanh cong");
                    return ResponseEntity.status(HttpStatus.OK).body(taiKhoandb); //200
                }else{
                    System.out.println("sai mat khau");
                    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(taiKhoan); //401
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("xay ra loi");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(taiKhoan); //400
        }
    }

    @Override
    public TaiKhoan findByTenTaiKhoan(String tentaikhoan) {
        return repo.findByTentaikhoan(tentaikhoan);
    }

    @Override
    @Transactional(rollbackOn = {Error.class, Exception.class})
    public Integer updateMatKhau(ChangePasswordDto dto) {
        TaiKhoan taiKhoan=repo.findByMataikhoan(dto.getMataikhoan());
        if(bCrypt.matches(dto.getMatkhaucu(),taiKhoan.getMatkhau())){
            return repo.updateMatKhau(dto.getMataikhoan(), dto.getMatkhaucu(), bCrypt.encode(dto.getMatkhaumoi()));
        }else{
            return -1;
        }
    }

    @Override
    public List<TaiKhoan> findAll() {
        return repo.findAll();
    }

    @Override
    @Transactional(rollbackOn = {Exception.class,Error.class})
    public Integer updateTinhTrang(TaiKhoan taiKhoan) {
        return repo.updateTinhTrang(taiKhoan.getMataikhoan(), taiKhoan.getTinhtrang());
    }


    @Override
    @Transactional(rollbackOn = {Exception.class, Error.class})
    public ResponseEntity<TaiKhoan> doRegister(TaiKhoan taiKhoan) {
        String tentaikhoan= taiKhoan.getTentaikhoan();
        String matkhau=taiKhoan.getMatkhau();
        TaiKhoan taiKhoandb=repo.findByTentaikhoan(tentaikhoan);
        //Not exist
        try{
            if (taiKhoandb == null){
                taiKhoan.setTinhtrang("kích hoạt");
                taiKhoan.setMatkhau(bCrypt.encode(matkhau));
                TaiKhoan saved= repo.save(taiKhoan);
                System.out.println("dang ky thanh cong");
                return ResponseEntity.status(HttpStatus.CREATED).body(saved); //201
            }else{
                System.out.println("tai khoan da ton tai");
                return ResponseEntity.status(HttpStatus.CONFLICT).body(taiKhoan); //409
            }
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(taiKhoan);
        }

    }
}
