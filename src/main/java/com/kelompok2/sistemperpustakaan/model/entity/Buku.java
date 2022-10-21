package com.kelompok2.sistemperpustakaan.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "data_buku")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_buku")
    @Column (name = "id_buku")
    private Integer idBuku;
    @Column (name = "judul_buku")
    private String judulBuku;
    @Column (name = "penulis_buku")
    private String penulisBuku;
    @Column (name = "penerbit_buku")
    private String penerbitBuku;
    @Column (name = "tahun_terbit")
    private Integer tahunTerbit;
    @Column (name = "lokasi_rak")
    private String lokasiRak;
    @Column (name = "jml_buku")
    private Integer jmlBuku;

    @Column (name = "id_admin")
    private Integer idAdmin;

    @ManyToOne
    @JoinColumn(name = "id_admin", insertable = false, updatable = false)
    private Admin admin;

    public Integer getIdAdminn() {
        return idAdmin;
    }

    public void setIdAdminn(Integer idAdminn) {
        this.idAdmin = idAdminn;
    }

    public Admin getAdminBuku() {
        return admin;
    }

    public void setAdminBuku(Admin adminBuku) {
        this.admin = admin;
    }

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
