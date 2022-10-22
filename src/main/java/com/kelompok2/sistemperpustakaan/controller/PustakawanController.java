package com.kelompok2.sistemperpustakaan.controller;

import com.kelompok2.sistemperpustakaan.model.dto.BukuDto;
import com.kelompok2.sistemperpustakaan.model.dto.DefaultResponse;
import com.kelompok2.sistemperpustakaan.model.dto.LoginDto;
import com.kelompok2.sistemperpustakaan.model.dto.PustakawanDto;
import com.kelompok2.sistemperpustakaan.model.entity.Pustakawan;
import com.kelompok2.sistemperpustakaan.repository.PustakawanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pustakawan")
public class PustakawanController {

    @Autowired
    private PustakawanRepository pustakawanRepository;

    @PostMapping("/login")
    public DefaultResponse loginPustakawan(@RequestBody LoginDto loginDto) {

        Optional<Pustakawan> optionalPustakawan = pustakawanRepository.findByUsernamePustakawanAndPasswordPustakawan(loginDto.getUname(), loginDto.getPass());

        DefaultResponse df = new DefaultResponse();

        if (optionalPustakawan.isPresent()) {
            df.setStatus(Boolean.TRUE);
            df.setMessage("Login berhasil");
        } else {
            df.setStatus(Boolean.FALSE);
            df.setMessage("Maaf username dan password salah");
        }
        return df;
    }

    @PostMapping("/save")
    public DefaultResponse<PustakawanDto> savePustakawan(@RequestBody PustakawanDto pustakawanDto) {
        Pustakawan pustakawan = convertDtoToEntity(pustakawanDto);
        DefaultResponse<PustakawanDto> response = new DefaultResponse();
        Optional<Pustakawan> optional = pustakawanRepository.findByUsernamePustakawanAndPasswordPustakawan(pustakawanDto.getUsernamePustakawan(), pustakawanDto.getPasswordPustakawan());
        if(optional.isPresent()){
            response.setStatus(Boolean.FALSE);
            response.setMessage("Username dan password sudah digunakan, coba menggunakan kata yang lain");
        } else {
            pustakawanRepository.save(pustakawan);
            response.setStatus(Boolean.TRUE);
            response.setMessage("Data berhasil ditambahkan");
        }

        return response;
    }

    public Pustakawan convertDtoToEntity(PustakawanDto dto) {
        Pustakawan pustakawan = new Pustakawan();
        pustakawan.setNamaPustakawan(dto.getNamaPustakawan());
        pustakawan.setJkPustakawan(dto.getJkPustakawan());
        pustakawan.setAlamatPustakawan(dto.getAlamatPustakawan());
        pustakawan.setNoHpPustakawan(dto.getNoHpPustakawan());
        pustakawan.setUsernamePustakawan(dto.getUsernamePustakawan());
        pustakawan.setPasswordPustakawan(dto.getPasswordPustakawan());
        pustakawan.setStatusPustakawan(dto.getStatusPustakawan());

        return pustakawan;
    }


    @GetMapping("/list")
    public List<PustakawanDto> getListPustakawan() {
        List<PustakawanDto> list = new ArrayList();
        for (Pustakawan pustakawan : pustakawanRepository.findAll()) {
            list.add(convertEntityToDto(pustakawan));
        }
        return list;
    }

    public PustakawanDto convertEntityToDto(Pustakawan entity) {
        PustakawanDto dto = new PustakawanDto();
        dto.setIdPustakawan(entity.getIdPustakawan());
        dto.setNamaPustakawan(entity.getNamaPustakawan());
        dto.setJkPustakawan(entity.getJkPustakawan());
        dto.setAlamatPustakawan(entity.getAlamatPustakawan());
        dto.setNoHpPustakawan(entity.getNoHpPustakawan());
        dto.setUsernamePustakawan(entity.getUsernamePustakawan());
        dto.setPasswordPustakawan(entity.getPasswordPustakawan());
        dto.setStatusPustakawan(entity.getStatusPustakawan());

        return dto;
    }

    @DeleteMapping("/delete/{idPustakawan}")
    public DefaultResponse deleteById(@PathVariable("idPustakawan") Integer idPustakawan) {
        DefaultResponse df = new DefaultResponse();
        Optional<Pustakawan> optionalPustakawan = pustakawanRepository.findById(idPustakawan);
        if (optionalPustakawan.isPresent()) {
            pustakawanRepository.delete(optionalPustakawan.get());
            df.setStatus(Boolean.TRUE);
            df.setMessage("Data Berhasil Dihapus");
        } else {
            df.setStatus(Boolean.FALSE);
            df.setMessage("Data Tidak Ditemukan");
        }
        return df;
    }

    @GetMapping("/byid/{idPustakawan}")
    public DefaultResponse getByIdBuku(@PathVariable Integer idPustakawan) {
        DefaultResponse df = new DefaultResponse();
        Optional<Pustakawan> optionalPustakawan = pustakawanRepository.findById(idPustakawan);
        if (optionalPustakawan.isPresent()) {
            df.setStatus(Boolean.TRUE);
            df.setMessage("Data ditemukan");
        } else {
            df.setStatus(Boolean.FALSE);
            df.setMessage("Data tidak ada");
        }
        return df;
    }

    @PutMapping("/update/{idPustakawan}")
    public DefaultResponse update(@PathVariable("idPustakawan") Integer idPustakawan, @RequestBody PustakawanDto pustakawanDto) {
        DefaultResponse df = new DefaultResponse();
        Optional<Pustakawan> optionalPustakawan = pustakawanRepository.findById(idPustakawan);
        Pustakawan pustakawan = optionalPustakawan.get();
        if (optionalPustakawan.isPresent()) {
            pustakawan.setNamaPustakawan(pustakawanDto.getNamaPustakawan());
            pustakawan.setJkPustakawan(pustakawanDto.getJkPustakawan());
            pustakawan.setAlamatPustakawan(pustakawanDto.getAlamatPustakawan());
            pustakawan.setNoHpPustakawan(pustakawanDto.getNoHpPustakawan());
            pustakawan.setUsernamePustakawan(pustakawanDto.getUsernamePustakawan());
            pustakawan.setPasswordPustakawan(pustakawanDto.getPasswordPustakawan());
            pustakawan.setStatusPustakawan(pustakawanDto.getStatusPustakawan());
            pustakawanRepository.save(pustakawan);
            df.setStatus(Boolean.TRUE);
            df.setMessage("Data berhasil diperbarui");
        } else {
            df.setStatus(Boolean.FALSE);
            df.setMessage("Data Sudah Terdaftar");
        }
        return df;
    }

}
