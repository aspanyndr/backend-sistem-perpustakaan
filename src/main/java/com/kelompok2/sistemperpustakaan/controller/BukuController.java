package com.kelompok2.sistemperpustakaan.controller;

import com.kelompok2.sistemperpustakaan.model.dto.BukuDto;
import com.kelompok2.sistemperpustakaan.model.dto.DataDto;
import com.kelompok2.sistemperpustakaan.model.dto.DefaultResponse;
import com.kelompok2.sistemperpustakaan.model.dto.projection.TotalBuku;
import com.kelompok2.sistemperpustakaan.model.entity.Book;
import com.kelompok2.sistemperpustakaan.repository.BukuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/buku")
public class BukuController {

    @Autowired
    private BukuRepository bukuRepository;

// menambahkan data buku ke data base --/buku/save
    @PostMapping("/save")
    public DefaultResponse<BukuDto> savebuku(@RequestBody BukuDto bukuDto){
        Book buku = convertDtoToEntity(bukuDto);
        DefaultResponse<BukuDto> response = new DefaultResponse();
        Optional<Book> optional = bukuRepository.findByIdBuku(bukuDto.getIdBuku());
        if(optional.isPresent()){
            response.setStatus(Boolean.FALSE);
            response.setMessage("Error, Data Sudah Tersedia");
        } else {
            bukuRepository.save(buku);
            response.setStatus(Boolean.TRUE);
            response.setMessage("Berhasil Simpan Data");
        }
        return response;
    }

    public Book convertDtoToEntity(BukuDto dto){
        Book buku = new Book();
        buku.setIdBuku(dto.getIdBuku());
        buku.setJudulBuku(dto.getJudulBuku());
        buku.setPenulisBuku(dto.getPenulisBuku());
        buku.setPenerbitBuku(dto.getPenerbitBuku());
        buku.setTahunTerbit(dto.getTahunTerbit());
        buku.setLokasiRak(dto.getLokasiRak());
        buku.setJmlBuku(dto.getJmlBuku());
        return buku;
    }

// menampilkan seluruh data buku --buku/listbuku
    @GetMapping("/listbuku")
    public List<BukuDto> getListBuku(){
//        List<BukuDto> list = listData();
        List<BukuDto> list = new ArrayList();
        for(Book buku :bukuRepository.findAll()){
            list.add(convertEntityToDto(buku));
        }
        return list;
    }

    public BukuDto convertEntityToDto(Book entity){
        BukuDto dto = new BukuDto();
        dto.setIdBuku(entity.getIdBuku());
        dto.setJudulBuku(entity.getJudulBuku());
        dto.setPenulisBuku(entity.getPenulisBuku());
        dto.setPenerbitBuku(entity.getPenerbitBuku());
        dto.setTahunTerbit(entity.getTahunTerbit());
        dto.setLokasiRak(entity.getLokasiRak());
        dto.setJmlBuku(entity.getJmlBuku());
        return dto;
    }
// menampilkan buku berdasarkan id --/buku/getbyid/{idbuku}
    @GetMapping("/getbyid/{idBuku}")
    public DataDto<BukuDto> getByIdBuku(@PathVariable Integer idBuku) {
        DataDto<BukuDto> data = new DataDto<>();
        Optional<Book> opt = bukuRepository.findByIdBuku(idBuku);
        if (opt.isPresent()) {
            data.setMessage("Data Ditemukan");
            data.setData(convertEntityToDto(opt.get()));
        } else {
            data.setMessage("Data Tidak Ditemukan");
        }
        return data;
    }
    @GetMapping("/getbyjudul/{judulBuku}")
    public DataDto<BukuDto> getByJudulBuku(@PathVariable String judulBuku) {
        DataDto<BukuDto> data = new DataDto<>();
        Optional<Book> opt = bukuRepository.findByJudulBuku(judulBuku);
        if (opt.isPresent()) {
            data.setMessage("Data Ditemukan");
            data.setData(convertEntityToDto(opt.get()));
        } else {
            data.setMessage("Data Tidak Ditemukan");
        }
        return data;
    }

    @GetMapping("/search/{search}")
    public List<BukuDto> search(@PathVariable String search) {
//        String convertString = String.valueOf(search);
        List<BukuDto> list = new ArrayList();
        for(Book buku :bukuRepository.search(search)){
            list.add(convertEntityToDto(buku));
        }
        return list;
    }
    @GetMapping("/totalbuku")
    public List<TotalBuku> getTotalBayar(){
        List<TotalBuku> list = bukuRepository.getListTotalBuku();
        return list;
    }

// menghapus data buku dari table  --/buku/delete/{idbuku}
    @DeleteMapping("/delete/{idBuku}")
    public DefaultResponse deleteById(@PathVariable("idBuku") Integer idBuku) {
        DefaultResponse df = new DefaultResponse();
        Optional<Book> optionalBuku =bukuRepository.findByIdBuku(idBuku);
        if (optionalBuku.isPresent()){
            bukuRepository.delete(optionalBuku.get());
            df.setStatus(Boolean.TRUE);
            df.setMessage("Data Berhasil Dihapus");
        } else {
            df.setStatus(Boolean.FALSE);
            df.setMessage("Data Tidak Ditemukan");
        }
        return df;
    }
// meng-update judul buku dan penulis buku berdasarkan idBuku --/buku/update/{idbuku}
    @PutMapping("/update/{idBuku}")
    public DefaultResponse update(@PathVariable("idBuku") Integer idBuku, @RequestBody BukuDto bukuDto) {
        DefaultResponse df = new DefaultResponse();
        Optional<Book> optionalBuku = bukuRepository.findByIdBuku(idBuku);
        Book book = optionalBuku.get();
        if (optionalBuku.isPresent()) {
            book.setJudulBuku(bukuDto.getJudulBuku());
            book.setPenulisBuku(bukuDto.getPenulisBuku());
            book.setLokasiRak(bukuDto.getLokasiRak());
            book.setTahunTerbit(bukuDto.getTahunTerbit());
            book.setJmlBuku(bukuDto.getJmlBuku());
            bukuRepository.save(book);
            df.setStatus(Boolean.TRUE);
//            df.setData(bukuDto);
            df.setMessage("Data berhasil diperbarui");
        } else {
            df.setStatus(Boolean.FALSE);
            df.setMessage("Data Sudah Terdaftar");
        }
        return df;
    }
}
