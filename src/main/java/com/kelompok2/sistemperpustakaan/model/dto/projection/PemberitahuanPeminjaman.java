package com.kelompok2.sistemperpustakaan.model.dto.projection;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public interface PemberitahuanPeminjaman {

    String getId_anggota();
    String getId_buku();
    @JsonFormat(shape =JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    Date getTgl_pinjam();
    @JsonFormat(shape =JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    Date getPengembalian_buku();
}
