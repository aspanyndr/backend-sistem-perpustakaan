package com.kelompok2.sistemperpustakaan.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class PeminjamanDto {
    private Integer idPeminjaman;
    @JsonFormat(shape =JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date tglPinjam;
    @JsonFormat(shape =JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date tglKembali;
    private Integer idPustakawan;
    private Integer idAnggota;
    private Integer idBuku;

    public Integer getIdPeminjaman() {
        return idPeminjaman;
    }

    public void setIdPeminjaman(Integer idPeminjaman) {
        this.idPeminjaman = idPeminjaman;
    }

    public Date getTglPinjam() {
        return tglPinjam;
    }

    public void setTglPinjam(Date tglPinjam) {
        this.tglPinjam = tglPinjam;
    }

    public Date getTglKembali() {
        return tglKembali;
    }

    public void setTglKembali(Date tglKembali) {
        this.tglKembali = tglKembali;
    }

    public Integer getIdPustakawan() {
        return idPustakawan;
    }

    public void setIdPustakawan(Integer idPustakawan) {
        this.idPustakawan = idPustakawan;
    }

    public Integer getIdAnggota() {
        return idAnggota;
    }

    public void setIdAnggota(Integer idAnggota) {
        this.idAnggota = idAnggota;
    }

    public Integer getIdBuku() {
        return idBuku;
    }

    public void setIdBuku(Integer idBuku) {
        this.idBuku = idBuku;
    }
}
