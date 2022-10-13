package com.kelompok2.sistemperpustakaan.controller;

import com.kelompok2.sistemperpustakaan.model.dto.DefaultResponse;
import com.kelompok2.sistemperpustakaan.model.dto.LoginDto;
import com.kelompok2.sistemperpustakaan.model.entity.Buku;
import com.kelompok2.sistemperpustakaan.model.entity.Pustakawan;
import com.kelompok2.sistemperpustakaan.repository.BukuRepository;
import com.kelompok2.sistemperpustakaan.repository.PustakawanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/pustakawan1")
public class SistemPerpustakaanController {

    @Autowired
    private PustakawanRepository pustakawanRepository;

    @Autowired
    private BukuRepository bukuRepository;

    @GetMapping("/byid/{idbuku}/namabuku/{namabuku}")
    public DefaultResponse getByIdBuku(@PathVariable Integer idbuku, @PathVariable String namabuku){

        DefaultResponse df = new DefaultResponse();
        Optional<Buku> optionalBuku = bukuRepository.findByIdBuku(idbuku);
        if(optionalBuku.isPresent()){
            df.setStatus(Boolean.TRUE);
            df.setMessage("Data ditemukan");
        } else {
            df.setStatus(Boolean.FALSE);
            df.setMessage("Data tidak ada");
        }
        return df;
    }


}
