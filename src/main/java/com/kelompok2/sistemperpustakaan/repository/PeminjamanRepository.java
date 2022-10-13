package com.kelompok2.sistemperpustakaan.repository;

import com.kelompok2.sistemperpustakaan.model.dto.projection.PemberitahuanPeminjaman;
import com.kelompok2.sistemperpustakaan.model.entity.Peminjaman;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PeminjamanRepository extends JpaRepository<Peminjaman, Long > {
    Optional<Peminjaman> findByIdPeminjaman(Integer idPeminjaman);

    Optional<Peminjaman> findByIdAnggota(Integer idAnggota);
    @Query(value = "SELECT id_anggota, id_buku, tgl_pinjam, 600tgl_pinjam +interval'60 days'as pengembalian_buku FROM data_peminjaman", nativeQuery = true)
    List<PemberitahuanPeminjaman> notifPeminjaman();

//    @Query(value = "SELECT id_anggota, id_buku, tgl_pinjam, tgl_pinjam +interval'60 days'as pengembalian_buku FROM data_peminjaman WHERE ", nativeQuery = true)
//    List<PemberitahuanPeminjaman> notifPeminjamanById();
}
