package com.kelompok2.sistemperpustakaan.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class PeminjamanAnggotaDto {
    private String namaAnggota;
    private String pekerjaan;
    private String judulBuku;
    @JsonFormat(shape =JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date tglPinjam;
    @JsonFormat(shape =JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date tglKembali;
    private String namaPustakawan;
    private String noHpPustakawan;

    public String getJudulBuku() {
        return judulBuku;
    }

    public void setJudulBuku(String judulBuku) {
        this.judulBuku = judulBuku;
    }

    public String getNamaPustakawan() {
        return namaPustakawan;
    }

    public void setNamaPustakawan(String namaPustakawan) {
        this.namaPustakawan = namaPustakawan;
    }

    public String getNoHpPustakawan() {
        return noHpPustakawan;
    }

    public void setNoHpPustakawan(String noHpPustakawan) {
        this.noHpPustakawan = noHpPustakawan;
    }

    public String getNamaAnggota() {
        return namaAnggota;
    }

    public void setNamaAnggota(String namaAnggota) {
        this.namaAnggota = namaAnggota;
    }

    public String getPekerjaan() {
        return pekerjaan;
    }

    public void setPekerjaan(String pekerjaan) {
        this.pekerjaan = pekerjaan;
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
}
