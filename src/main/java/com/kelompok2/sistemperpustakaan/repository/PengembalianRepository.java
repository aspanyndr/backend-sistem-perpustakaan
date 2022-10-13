package com.kelompok2.sistemperpustakaan.repository;

import com.kelompok2.sistemperpustakaan.model.dto.projection.TotalBayar;
import com.kelompok2.sistemperpustakaan.model.entity.Pengembalian;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PengembalianRepository extends JpaRepository<Pengembalian, Integer > {

    @Query(value = "select id_pengembalian, id_anggota, total_denda + total_denda as total_bayar from data_pengembalian", nativeQuery = true)
    List<TotalBayar> getTotalBayar();

}
