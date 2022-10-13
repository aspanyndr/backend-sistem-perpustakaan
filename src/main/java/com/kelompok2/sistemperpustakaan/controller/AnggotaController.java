package com.kelompok2.sistemperpustakaan.controller;

import com.kelompok2.sistemperpustakaan.model.dto.*;
import com.kelompok2.sistemperpustakaan.model.entity.Anggota;
import com.kelompok2.sistemperpustakaan.repository.AnggotaRepository;
import com.kelompok2.sistemperpustakaan.service.AnggotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/anggota")
public class AnggotaController {

    @Autowired
    AnggotaService anggotaService;

    @PostMapping("/loginAnggota")
    public DefaultResponse loginAnggota(@RequestBody LoginDto loginDto){
        DefaultResponse defaultResponse = anggotaService.loginAnggota(loginDto);
        return defaultResponse;
    }

    // Insert Data diri Anggota
    @PostMapping("/save")
    public DefaultResponse<AnggotaDto> savaDataAnggota(@RequestBody AnggotaDto anggotaDto){
        DefaultResponse defaultResponse = anggotaService.anggotaSave(anggotaDto);
        return defaultResponse;
    }

// mencari data anggota sesuai Id
    @GetMapping("/getbyid/{idAnggota}")
    public DataDto<AnggotaDto> getByIdAnggota(@PathVariable Integer idAnggota) {
        DataDto dataDto = anggotaService.getByIdAnggota(idAnggota);
        return dataDto;
    }

    // menampilkan data mahasisiwa dalam database
    @GetMapping("/listanggota")
    public List<AnggotaDto> getListAnggota(){
        List list = anggotaService.getListAnggota();
        return list;
    }

    @PutMapping("/updateAnggota/{idAnggota}")
    public DefaultResponse updateAnggota(
            @PathVariable("idAnggota") Integer idAnggota,
            @RequestBody AnggotaDto anggotaDto) {
        DefaultResponse defaultResponse = anggotaService.updateAnggota(idAnggota, anggotaDto);
        return defaultResponse;
    }
    @DeleteMapping("/delete/{idAnggota}")
    public DefaultResponse deleteIdAnggota(@PathVariable("idAnggota") Integer idAnggota) {
        DefaultResponse defaultResponse = anggotaService.deleteIdAnggota(idAnggota);
        return defaultResponse;
    }

//    public Anggota convertDtoToEntity(AnggotaDto anggotaDto){
//        Anggota anggota = new Anggota();
//
//        anggota.setIdAnggota(anggotaDto.getIdAnggota());
//        anggota.setUserName(anggotaDto.getUserName());
//        anggota.setNamaAnggota(anggotaDto.getNamaAnggota());
//        anggota.setJkAnggota(anggotaDto.getJkAnggota());
//        anggota.setPekerjaan(anggotaDto.getPekerjaan());
//        anggota.setAlamatAnggota(anggotaDto.getAlamatAnggota());
//        anggota.setNoHpAnggota(anggotaDto.getNoHpAnggota());
//        anggota.setPasswordAnggota(anggotaDto.getPasswordAnggota());
//        anggota.setStatusAnggota(anggotaDto.getStatusAnggota());
//
//     return anggota;
//    }
//
//    public AnggotaDto convertEntityToDto(Anggota entity){
//        AnggotaDto dto = new AnggotaDto();
//
//        dto.setIdAnggota(entity.getIdAnggota());
//        dto.setUserName(entity.getUserName());
//        dto.setNamaAnggota(entity.getNamaAnggota());
//        dto.setJkAnggota(entity.getJkAnggota());
//        dto.setPekerjaan(entity.getPekerjaan());
//        dto.setAlamatAnggota(entity.getAlamatAnggota());
//        dto.setNoHpAnggota(entity.getNoHpAnggota());
//        dto.setPasswordAnggota(entity.getPasswordAnggota());
//        dto.setStatusAnggota(entity.getStatusAnggota());
//
//        return dto;
//    }
}
