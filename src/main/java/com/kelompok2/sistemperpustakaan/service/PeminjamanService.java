package com.kelompok2.sistemperpustakaan.service;

import com.kelompok2.sistemperpustakaan.model.dto.DefaultResponse;
import com.kelompok2.sistemperpustakaan.model.dto.PeminjamanAnggotaDto;
import com.kelompok2.sistemperpustakaan.model.dto.PeminjamanDto;

import java.util.List;

public interface PeminjamanService {
    List searchPeminjaman();

    PeminjamanAnggotaDto getListHistoryPeminjaman(Integer idPeminjaman);

    DefaultResponse createDataPeminjaman(PeminjamanDto peminjamanDto);

    List getListPeminjaman();
}
