package com.kelompok2.sistemperpustakaan.model.dto;

public class AnggotaDto {

    private Integer idAnggota;
    private String userName;
    private String namaAnggota;
    private String jkAnggota;
    private String pekerjaan;
    private String alamatAnggota;
    private String noHpAnggota;
    private String passwordAnggota;
    private String statusAnggota;

    public Integer getIdAnggota() {
        return idAnggota;
    }

    public void setIdAnggota(Integer idAnggota) {
        this.idAnggota = idAnggota;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNamaAnggota() {
        return namaAnggota;
    }

    public void setNamaAnggota(String namaAnggota) {
        this.namaAnggota = namaAnggota;
    }

    public String getJkAnggota() {
        return jkAnggota;
    }

    public void setJkAnggota(String jkAnggota) {
        this.jkAnggota = jkAnggota;
    }

    public String getPekerjaan() {
        return pekerjaan;
    }

    public void setPekerjaan(String pekerjaan) {
        this.pekerjaan = pekerjaan;
    }

    public String getAlamatAnggota() {
        return alamatAnggota;
    }

    public void setAlamatAnggota(String alamatAnggota) {
        this.alamatAnggota = alamatAnggota;
    }

    public String getNoHpAnggota() {
        return noHpAnggota;
    }

    public void setNoHpAnggota(String noHpAnggota) {
        this.noHpAnggota = noHpAnggota;
    }

    public String getPasswordAnggota() {
        return passwordAnggota;
    }

    public void setPasswordAnggota(String passwordAnggota) {
        this.passwordAnggota = passwordAnggota;
    }

    public String getStatusAnggota() {
        return statusAnggota;
    }

    public void setStatusAnggota(String statusAnggota) {
        this.statusAnggota = statusAnggota;
    }
}
