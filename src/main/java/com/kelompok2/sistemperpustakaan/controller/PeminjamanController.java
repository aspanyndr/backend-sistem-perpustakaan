package com.kelompok2.sistemperpustakaan.controller;

import com.kelompok2.sistemperpustakaan.model.dto.*;
import com.kelompok2.sistemperpustakaan.model.dto.projection.PemberitahuanPeminjaman;
import com.kelompok2.sistemperpustakaan.model.entity.Peminjaman;
import com.kelompok2.sistemperpustakaan.repository.PeminjamanRepository;
import com.kelompok2.sistemperpustakaan.service.PeminjamanService;
import com.kelompok2.sistemperpustakaan.service.serviceimpl.PeminjamanServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/peminjaman")
public class PeminjamanController {
    @Autowired
    private PeminjamanService peminjamanService;

    @GetMapping("/listSetPengembalianBuku")
    public List<PemberitahuanPeminjaman> searchPeminjaman(){

        List list = peminjamanService.searchPeminjaman();
        return list;
//        List<PemberitahuanPeminjaman> listDto = peminjamanRepository.notifPeminjaman();
//        return listDto;
    }
    @GetMapping("/pemberitahuanPeminjaman/{idPeminjaman}")
    public PeminjamanAnggotaDto getListHistoryPeminjaman(@PathVariable Integer idPeminjaman) {

        PeminjamanAnggotaDto peminjamanAnggotaDto = peminjamanService.getListHistoryPeminjaman(idPeminjaman);
        return peminjamanAnggotaDto;

    }
    @PostMapping("/save")
    public DefaultResponse<PeminjamanDto> createDataPeminjaman(@RequestBody PeminjamanDto peminjamanDto){
        DefaultResponse defaultResponse = peminjamanService.createDataPeminjaman(peminjamanDto);
        return defaultResponse;
    }
    @GetMapping("/listPeminjaman")
    public List<PeminjamanDto> getListPeminjaman(){
        List list = peminjamanService.getListPeminjaman();
        return list;

    }
}
