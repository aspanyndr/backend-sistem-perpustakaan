package com.kelompok2.sistemperpustakaan.repository;

import com.kelompok2.sistemperpustakaan.model.dto.projection.TotalBuku;
import com.kelompok2.sistemperpustakaan.model.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface BukuRepository extends JpaRepository<Book, Long> {

    Optional<Book> findByIdBuku (Integer idBuku);

    @Query(value = "SELECT id_buku, judul_buku, jml_buku + jml_buku as total_buku FROM data_buku", nativeQuery = true)
    List<TotalBuku> getListTotalBuku();

    Optional<Book> findByJudulBuku(String judulBuku);

    @Query(value = "SELECT * FROM data_buku WHERE LOWER (data_buku.judul_buku) LIKE %?1% OR LOWER (data_buku.penulis_buku) LIKE %?1% OR LOWER (data_buku.penerbit_buku) LIKE %?1% OR LOWER (data_buku.lokasi_rak) LIKE %?1%", nativeQuery = true)
    List<Book> search (String search);
}
