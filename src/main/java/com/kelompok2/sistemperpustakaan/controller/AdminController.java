package com.kelompok2.sistemperpustakaan.controller;

import com.kelompok2.sistemperpustakaan.model.dto.AdminBukuDto;
import com.kelompok2.sistemperpustakaan.model.dto.DefaultResponse;
import com.kelompok2.sistemperpustakaan.model.dto.LoginDto;
import com.kelompok2.sistemperpustakaan.model.entity.Admin;
import com.kelompok2.sistemperpustakaan.model.entity.Buku;
import com.kelompok2.sistemperpustakaan.repository.AdminRepository;
import com.kelompok2.sistemperpustakaan.repository.BukuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private BukuRepository bukuRepository;

    @PostMapping("/login")
    public DefaultResponse loginAdmin(@RequestBody LoginDto loginDto) {
        Optional<Admin> optionalAdmin = adminRepository.findByUsernameAdminAndPasswordAdmin(loginDto.getUname(), loginDto.getPass());
        DefaultResponse df = new DefaultResponse();
        if (optionalAdmin.isPresent()) {
            df.setStatus(Boolean.TRUE);
            df.setMessage("Login berhasil");
        } else {
            df.setStatus(Boolean.FALSE);
            df.setMessage("Maaf username dan password salah");
        }
        return df;
    }

    @GetMapping("/listbuku")
    public List<AdminBukuDto> getListAdminBuku(){
        List<AdminBukuDto> list = new ArrayList();
        for(Buku buku : bukuRepository.findAll()){
            list.add(convertEntityToDto(buku));
        }
        return list;
    }
    public AdminBukuDto convertEntityToDto(Buku entity){
        AdminBukuDto dto = new AdminBukuDto();
        dto.setNamaAdmin(entity.getAdminBuku().getNamaAdmin());
        dto.setJudulBuku(entity.getJudulBuku());
        dto.setJmlBuku(entity.getJmlBuku());

        return dto;
    }

}
