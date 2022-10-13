package com.kelompok2.sistemperpustakaan.model.dto;

public class BukuDto {
    private Integer idBuku;
    private String judulBuku;
    private String penulisBuku;
    private String penerbitBuku;
    private Integer tahunTerbit;
    private String lokasiRak;
    private Integer jmlBuku;

    public Integer getIdBuku() {
        return idBuku;
    }

    public void setIdBuku(Integer idBuku) {
        this.idBuku = idBuku;
    }

    public String getJudulBuku() {
        return judulBuku;
    }

    public void setJudulBuku(String judulBuku) {
        this.judulBuku = judulBuku;
    }

    public String getPenulisBuku() {
        return penulisBuku;
    }

    public void setPenulisBuku(String penulisBuku) {
        this.penulisBuku = penulisBuku;
    }

    public String getPenerbitBuku() {
        return penerbitBuku;
    }

    public void setPenerbitBuku(String penerbitBuku) {
        this.penerbitBuku = penerbitBuku;
    }

    public Integer getTahunTerbit() {
        return tahunTerbit;
    }

    public void setTahunTerbit(Integer tahunTerbit) {
        this.tahunTerbit = tahunTerbit;
    }

    public String getLokasiRak() {
        return lokasiRak;
    }

    public void setLokasiRak(String lokasiRak) {
        this.lokasiRak = lokasiRak;
    }

    public Integer getJmlBuku() {
        return jmlBuku;
    }

    public void setJmlBuku(Integer jmlBuku) {
        this.jmlBuku = jmlBuku;
    }
}
