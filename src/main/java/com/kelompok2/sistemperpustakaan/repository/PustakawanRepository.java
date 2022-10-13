package com.kelompok2.sistemperpustakaan.repository;

import com.kelompok2.sistemperpustakaan.model.entity.Buku;
import com.kelompok2.sistemperpustakaan.model.entity.Pustakawan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface PustakawanRepository extends JpaRepository<Pustakawan, Integer > {

    Optional<Pustakawan> findByUsernamePustakawanAndPasswordPustakawan (String uname, String pass);

}
