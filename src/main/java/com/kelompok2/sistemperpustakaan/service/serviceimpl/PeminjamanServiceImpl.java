package com.kelompok2.sistemperpustakaan.service.serviceimpl;

import com.kelompok2.sistemperpustakaan.model.dto.DefaultResponse;
import com.kelompok2.sistemperpustakaan.model.dto.PeminjamanAnggotaDto;
import com.kelompok2.sistemperpustakaan.model.dto.PeminjamanDto;
import com.kelompok2.sistemperpustakaan.model.dto.projection.PemberitahuanPeminjaman;
import com.kelompok2.sistemperpustakaan.model.entity.Peminjaman;
import com.kelompok2.sistemperpustakaan.repository.PeminjamanRepository;
import com.kelompok2.sistemperpustakaan.service.PeminjamanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PeminjamanServiceImpl implements PeminjamanService {

    @Autowired
    private PeminjamanRepository peminjamanRepository;


    @Override
    public List searchPeminjaman() {
//        List<PemberitahuanPeminjaman> list = peminjamanRepository.
//        return ;
        List<PemberitahuanPeminjaman> listDto = peminjamanRepository.notifPeminjaman();
        return listDto;
    }

    @Override
    public PeminjamanAnggotaDto getListHistoryPeminjaman(Integer idPeminjaman) {
        Optional<Peminjaman> optPem = peminjamanRepository.findByIdPeminjaman(idPeminjaman);
        PeminjamanAnggotaDto dto = new PeminjamanAnggotaDto();
        if (optPem.isPresent()) {
            Peminjaman peminjaman = optPem.get();
            dto.setNamaAnggota(peminjaman.getAnggotaPeminjaman().getNamaAnggota());
            dto.setPekerjaan(peminjaman.getAnggotaPeminjaman().getPekerjaan());
            dto.setJudulBuku(peminjaman.getBukuPeminjaman().getJudulBuku());
            dto.setTglKembali(peminjaman.getTglKembali());
            dto.setTglPinjam(peminjaman.getTglPinjam());
            dto.setNamaPustakawan(peminjaman.getPustakawanPeminjaman().getNamaPustakawan());
            dto.setNoHpPustakawan(peminjaman.getPustakawanPeminjaman().getNoHpPustakawan());
        }
        return dto;
    }

    @Override
    public DefaultResponse createDataPeminjaman(PeminjamanDto peminjamanDto) {
        Peminjaman peminjaman = convertDtoToEntity(peminjamanDto);
        DefaultResponse<PeminjamanDto> responesePeminjaman = new DefaultResponse<>();
        Optional<Peminjaman> opt = peminjamanRepository.findByIdPeminjaman(peminjamanDto.getIdPeminjaman());
        if(opt.isPresent()){
            responesePeminjaman.setStatus(Boolean.FALSE);
            responesePeminjaman.setMessage("Data yang anda masuka sudah Terisi");
        }
        else{
            peminjamanRepository.save(peminjaman);
            responesePeminjaman.setStatus(Boolean.TRUE);
            responesePeminjaman.setMessage("Terima kasih, data anda sudah tersimpan");
        }
    return responesePeminjaman;
    }

    @Override
    public List getListPeminjaman() {
        List<PeminjamanDto> listPeminjaman = new ArrayList();
        for(Peminjaman peminjaman : peminjamanRepository.findAll()){
            listPeminjaman.add(convertEntityToDto(peminjaman));
        }
        return listPeminjaman;
    }

    public Peminjaman convertDtoToEntity(PeminjamanDto peminjamanDto){
        Peminjaman peminjaman = new Peminjaman();
        peminjaman.setIdAnggota(peminjamanDto.getIdAnggota());
        peminjaman.setIdBuku(peminjamanDto.getIdBuku());
        peminjaman.setIdPeminjaman(peminjamanDto.getIdPeminjaman());
        peminjaman.setIdPustakawan(peminjamanDto.getIdPustakawan());
        peminjaman.setTglPinjam(peminjamanDto.getTglPinjam());
        peminjaman.setTglKembali(peminjamanDto.getTglKembali());
        return peminjaman;
    }
    public PeminjamanDto convertEntityToDto(Peminjaman entity){
        PeminjamanDto dto = new PeminjamanDto();
        dto.setIdAnggota(entity.getIdAnggota());
        dto.setIdBuku(entity.getIdBuku());
        dto.setIdPeminjaman(entity.getIdPeminjaman());
        dto.setIdPustakawan(entity.getIdPustakawan());
        dto.setTglPinjam(entity.getTglPinjam());
        dto.setTglKembali(entity.getTglKembali());
        return dto;
    }
}
