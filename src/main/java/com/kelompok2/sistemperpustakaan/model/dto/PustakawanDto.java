package com.kelompok2.sistemperpustakaan.model.dto;

import javax.persistence.Column;

public class PustakawanDto {
    private Integer idPustakawan;
    private String namaPustakawan;
    private String jkPustakawan;
    private String alamatPustakawan;
    private String noHpPustakawan;
    private String usernamePustakawan;
    private String passwordPustakawan;
    private String statusPustakawan;

    public Integer getIdPustakawan() {
        return idPustakawan;
    }

    public void setIdPustakawan(Integer idPustakawan) {
        this.idPustakawan = idPustakawan;
    }

    public String getNamaPustakawan() {
        return namaPustakawan;
    }

    public void setNamaPustakawan(String namaPustakawan) {
        this.namaPustakawan = namaPustakawan;
    }

    public String getJkPustakawan() {
        return jkPustakawan;
    }

    public void setJkPustakawan(String jkPustakawan) {
        this.jkPustakawan = jkPustakawan;
    }

    public String getAlamatPustakawan() {
        return alamatPustakawan;
    }

    public void setAlamatPustakawan(String alamatPustakawan) {
        this.alamatPustakawan = alamatPustakawan;
    }

    public String getNoHpPustakawan() {
        return noHpPustakawan;
    }

    public void setNoHpPustakawan(String noHpPustakawan) {
        this.noHpPustakawan = noHpPustakawan;
    }

    public String getUsernamePustakawan() {
        return usernamePustakawan;
    }

    public void setUsernamePustakawan(String usernamePustakawan) {
        this.usernamePustakawan = usernamePustakawan;
    }

    public String getPasswordPustakawan() {
        return passwordPustakawan;
    }

    public void setPasswordPustakawan(String passwordPustakawan) {
        this.passwordPustakawan = passwordPustakawan;
    }

    public String getStatusPustakawan() {
        return statusPustakawan;
    }

    public void setStatusPustakawan(String statusPustakawan) {
        this.statusPustakawan = statusPustakawan;
    }
}
