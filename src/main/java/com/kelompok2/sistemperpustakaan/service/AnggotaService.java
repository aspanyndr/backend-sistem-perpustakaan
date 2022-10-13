package com.kelompok2.sistemperpustakaan.service;

import com.kelompok2.sistemperpustakaan.model.dto.AnggotaDto;
import com.kelompok2.sistemperpustakaan.model.dto.DataDto;
import com.kelompok2.sistemperpustakaan.model.dto.DefaultResponse;
import com.kelompok2.sistemperpustakaan.model.dto.LoginDto;
import com.kelompok2.sistemperpustakaan.model.entity.Anggota;

import java.util.List;

public interface AnggotaService {

    DefaultResponse loginAnggota(LoginDto loginDto);

    DefaultResponse anggotaSave(AnggotaDto anggotaDto);

    DataDto getByIdAnggota(Integer idAnggota);

    List getListAnggota();

    DefaultResponse updateAnggota(Integer idAnggota, AnggotaDto anggotaDto);

    DefaultResponse deleteIdAnggota(Integer idAnggota);
}
