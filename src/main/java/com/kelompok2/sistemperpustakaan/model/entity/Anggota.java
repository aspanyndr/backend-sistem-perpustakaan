package com.kelompok2.sistemperpustakaan.model.entity;

import javax.persistence.*;

@Entity
@Table(name="data_anggota")

public class Anggota {
    @Id
    @SequenceGenerator(
            name="anggota_seq",
            sequenceName="anggota_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "anggota_seq"
    )
    @Column(name = "id_Anggota", length  = 5)
    private Integer idAnggota;
    @Column(name = "user_Name", unique = true)
    private String userName;
    @Column(name = "nama_Anggota")
    private String namaAnggota;
    @Column(name = "jk_Anggota")
    private String jkAnggota;
    @Column(name = "pekerjaan")
    private String pekerjaan;
    @Column(name = "alamat_Anggota")
    private String alamatAnggota;
    @Column(name = "no_Hp_Anggota")
    private String noHpAnggota;
    @Column(name = "password_Anggota")
    private String passwordAnggota;
    @Column(name = "status_Anggota")
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


