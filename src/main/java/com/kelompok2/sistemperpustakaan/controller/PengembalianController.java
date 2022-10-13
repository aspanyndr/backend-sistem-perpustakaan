package com.kelompok2.sistemperpustakaan.controller;

import com.kelompok2.sistemperpustakaan.model.dto.DefaultResponse;
import com.kelompok2.sistemperpustakaan.model.dto.PengembalianAnggotaDto;
import com.kelompok2.sistemperpustakaan.model.dto.PengembalianDto;
import com.kelompok2.sistemperpustakaan.model.dto.projection.TotalBayar;
import com.kelompok2.sistemperpustakaan.model.entity.Pengembalian;
import com.kelompok2.sistemperpustakaan.repository.PengembalianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pengembalian")
public class PengembalianController {

    @Autowired
    private PengembalianRepository pengembalianRepository;

    @PostMapping("/save")
    public DefaultResponse<PengembalianDto> savePengembalian(@RequestBody PengembalianDto pengembalianDto){
        Pengembalian pengembalian = convertDtoToEntity(pengembalianDto);
        DefaultResponse<PengembalianDto> response = new DefaultResponse();

        pengembalianRepository.save(pengembalian);
        response.setStatus(Boolean.TRUE);
        response.setMessage("Data berhasil ditambahkan");

        return response;
    }

    public Pengembalian convertDtoToEntity(PengembalianDto dto){
        Pengembalian pengembalian = new Pengembalian();
        pengembalian.setTglKembali(dto.getTglKembali());
        pengembalian.setJatuhTempo(dto.getJatuhTempo());
        pengembalian.setTotalDenda(dto.getTotalDenda());
        pengembalian.setIdPustakawan(dto.getIdPustakawan());
        pengembalian.setIdAnggota(dto.getIdAnggota());
        pengembalian.setIdBuku(dto.getIdBuku());

        return pengembalian;
    }

    @GetMapping("/list")
    public List<PengembalianDto> getListPengembalian(){
        List<PengembalianDto> list = new ArrayList();
        for(Pengembalian pengembalian :pengembalianRepository.findAll()){
            list.add(convertEntityToDto(pengembalian));
        }
        return list;
    }
    public PengembalianDto convertEntityToDto(Pengembalian entity){
        PengembalianDto dto = new PengembalianDto();
        dto.setIdPengembalian(entity.getIdPengembalian());
        dto.setTglKembali(entity.getTglKembali());
        dto.setJatuhTempo(entity.getJatuhTempo());
        dto.setTotalDenda(entity.getTotalDenda());
        dto.setIdPustakawan(entity.getIdPustakawan());
        dto.setIdAnggota(entity.getIdAnggota());
        dto.setIdBuku(entity.getIdBuku());
        return dto;
    }

    @DeleteMapping("/delete/{idPengembalian}")
    public DefaultResponse deleteById(@PathVariable("idPengembalian") Integer idPengembalian) {
        DefaultResponse df = new DefaultResponse();
        Optional<Pengembalian> optionalPengembalian =pengembalianRepository.findById(idPengembalian);
        if (optionalPengembalian.isPresent()){
            pengembalianRepository.delete(optionalPengembalian.get());
            df.setStatus(Boolean.TRUE);
            df.setMessage("Data Berhasil Dihapus");
        } else {
            df.setStatus(Boolean.FALSE);
            df.setMessage("Data Tidak Ditemukan");
        }
        return df;
    }

    @GetMapping("/byid/{idPengembalian}")
    public DefaultResponse getByIdPengembalian(@PathVariable Integer idPengembalian){

        DefaultResponse df = new DefaultResponse();
        Optional<Pengembalian> optionalPengembalian = pengembalianRepository.findById(idPengembalian);
        if(optionalPengembalian.isPresent()){
            df.setStatus(Boolean.TRUE);
            df.setMessage("Data ditemukan");
        } else {
            df.setStatus(Boolean.FALSE);
            df.setMessage("Data tidak ada");
        }
        return df;
    }

    @PutMapping("/update/{idPengembalian}")
    public DefaultResponse update(@PathVariable("idPengembalian") Integer idPengembalian, @RequestBody PengembalianDto pengembalianDto) {
        DefaultResponse df = new DefaultResponse();
        Optional<Pengembalian> optionalPengembalian = pengembalianRepository.findById(idPengembalian);
        Pengembalian pengembalian = optionalPengembalian.get();
        if (optionalPengembalian.isPresent()) {
            pengembalian.setTglKembali(pengembalianDto.getTglKembali());
            pengembalian.setJatuhTempo(pengembalianDto.getJatuhTempo());
            pengembalian.setTotalDenda(pengembalianDto.getTotalDenda());
            pengembalian.setIdPustakawan(pengembalianDto.getIdPustakawan());
            pengembalian.setIdAnggota(pengembalianDto.getIdAnggota());
            pengembalian.setIdBuku(pengembalianDto.getIdBuku());

            pengembalianRepository.save(pengembalian);
            df.setStatus(Boolean.TRUE);
            df.setMessage("Data berhasil diperbarui");
        } else {
            df.setStatus(Boolean.FALSE);
            df.setMessage("Data Sudah Terdaftar");
        }
        return df;
    }

    @GetMapping("/pengembalianpustakawan/{idPengembalian}")
    public PengembalianAnggotaDto getListPengembalianAnggota(@PathVariable Integer idPengembalian){
        Optional<Pengembalian> optionalPengembalian = pengembalianRepository.findById(idPengembalian);
        PengembalianAnggotaDto dto = new PengembalianAnggotaDto();
        if(optionalPengembalian.isPresent()){
            Pengembalian pengembalian = optionalPengembalian.get();
            dto.setDenda(pengembalian.getTotalDenda());
            dto.setNama(pengembalian.getPustakawan().getNamaPustakawan());
        } else {

        }

        return dto;
    }

    @GetMapping("/totalbayar")
    public List<TotalBayar> getTotalBayar(){
        List<TotalBayar> list = pengembalianRepository.getTotalBayar();

        return list;
    }
}
