package com.kelompok2.sistemperpustakaan.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class PengembalianDto {
    private Integer idPengembalian;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date tglKembali;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date jatuhTempo;
    private Integer totalDenda;
    private Integer idPustakawan;
    private Integer idAnggota;
    private String idBuku;

    public Integer getIdPengembalian() {
        return idPengembalian;
    }

    public void setIdPengembalian(Integer idPengembalian) {
        this.idPengembalian = idPengembalian;
    }

    public Date getTglKembali() {
        return tglKembali;
    }

    public void setTglKembali(Date tglKembali) {
        this.tglKembali = tglKembali;
    }

    public Date getJatuhTempo() {
        return jatuhTempo;
    }

    public void setJatuhTempo(Date jatuhTempo) {
        this.jatuhTempo = jatuhTempo;
    }

    public Integer getTotalDenda() {
        return totalDenda;
    }

    public void setTotalDenda(Integer totalDenda) {
        this.totalDenda = totalDenda;
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

    public String getIdBuku() {
        return idBuku;
    }

    public void setIdBuku(String idBuku) {
        this.idBuku = idBuku;
    }
}
