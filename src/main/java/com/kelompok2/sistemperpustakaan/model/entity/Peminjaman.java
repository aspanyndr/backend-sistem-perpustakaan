package com.kelompok2.sistemperpustakaan.model.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.Date;

@Entity
@Table(name = "data_peminjaman")
public class Peminjaman {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name = "id_peminjaman", length = 5)
    private Integer idPeminjaman;
//    @CreationTimestamp
//    @Temporal(TemporalType.DATE)
    @Column (name = "tgl_pinjam")
    private Date tglPinjam;
    @Column (name = "tgl_kembali")
    private Date tglKembali;
    @Column (name = "id_pustakawan")
    private Integer idPustakawan;
    @Column (name = "id_anggota")
    private Integer idAnggota;
    @Column (name = "id_buku")
    private Integer idBuku;
    @OneToOne
    @JoinColumn(name="id_anggota", insertable = false, updatable = false)
    private Anggota anggotaPeminjaman;

    @OneToOne
    @JoinColumn(name="id_pustakawan", insertable = false, updatable = false)
    private Pustakawan pustakawanPeminjaman;


    public Integer getIdBuku() {
        return idBuku;
    }

    public void setIdBuku(Integer idBuku) {
        this.idBuku = idBuku;
    }

    public Pustakawan getPustakawanPeminjaman() {
        return pustakawanPeminjaman;
    }

    public void setPustakawanPeminjaman(Pustakawan pustakawanPeminjaman) {
        this.pustakawanPeminjaman = pustakawanPeminjaman;
    }

    @OneToOne
    @JoinColumn(name="id_buku", insertable = false, updatable = false)
    private Buku bukuPeminjaman;

    public Anggota getAnggotaPeminjaman() {
        return anggotaPeminjaman;
    }

    public void setAnggotaPeminjaman(Anggota anggotaPeminjaman) {
        this.anggotaPeminjaman = anggotaPeminjaman;
    }

    public Buku getBukuPeminjaman() {
        return bukuPeminjaman;
    }

    public void setBukuPeminjaman(Buku bukuPeminjaman) {
        this.bukuPeminjaman = bukuPeminjaman;
    }

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

}
