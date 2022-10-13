package com.kelompok2.sistemperpustakaan.model.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table (name = "data_pengembalian")
public class Pengembalian {
    @Id
    @Column (name = "id_pengembalian", length = 10)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_pengembalian")
    private Integer idPengembalian;
    @Temporal(TemporalType.DATE)
    @Column (name = "tgl_kembali")
    private Date tglKembali;
    @Temporal(TemporalType.DATE)
    @Column (name = "jatuh_tempo")
    private Date jatuhTempo;
    @Column (name = "total_denda")
    private Integer totalDenda;
    @Column (name = "id_pustakawan")
    private Integer idPustakawan;
    @Column (name = "id_anggota")
    private Integer idAnggota;
    @Column (name = "id_buku")
    private String idBuku;

    @OneToOne
    @JoinColumn(name = "id_pustakawan", insertable = false, updatable = false)
    private Pustakawan pustakawan;
//
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

    public Pustakawan getPustakawan() {
        return pustakawan;
    }

    public void setPustakawan(Pustakawan pustakawan) {
        this.pustakawan = pustakawan;
    }
}
