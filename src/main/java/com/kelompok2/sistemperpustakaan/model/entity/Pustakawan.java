package com.kelompok2.sistemperpustakaan.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "data_pustakawan")
public class Pustakawan {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_pustakawan")
    @Column (name = "id_pustakawan", length = 8)
    private Integer idPustakawan;
    @Column (name = "nama_pustakawan")
    private String namaPustakawan;
    @Column (name = "jk_pustakawan")
    private String jkPustakawan;
    @Column (name = "alamat_pustakawan")
    private String alamatPustakawan;
    @Column (name = "no_hp_pustakawan")
    private String noHpPustakawan;
    @Column (name = "username_pustakawan")
    private String usernamePustakawan;
    @Column (name = "password_pustakawan")
    private String passwordPustakawan;
    @Column (name = "status_pustakawan")
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
