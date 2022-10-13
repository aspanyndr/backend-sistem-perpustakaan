package com.kelompok2.sistemperpustakaan.model.dto;

public class AdminBukuDto {
    private String namaAdmin;
    private String judulBuku;
    private Integer jmlBuku;

    public String getNamaAdmin() {
        return namaAdmin;
    }

    public void setNamaAdmin(String namaAdmin) {
        this.namaAdmin = namaAdmin;
    }


    public String getJudulBuku() {
        return judulBuku;
    }

    public void setJudulBuku(String judulBuku) {
        this.judulBuku = judulBuku;
    }

    public Integer getJmlBuku() {
        return jmlBuku;
    }

    public void setJmlBuku(Integer jmlBuku) {
        this.jmlBuku = jmlBuku;
    }
}
