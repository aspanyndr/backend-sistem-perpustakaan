package com.kelompok2.sistemperpustakaan.repository;

import com.kelompok2.sistemperpustakaan.model.entity.Admin;
import com.kelompok2.sistemperpustakaan.model.entity.Pustakawan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin, Integer> {

    Optional<Admin> findByUsernameAdminAndPasswordAdmin (String uname, String pass);

    Optional<Admin> findByNamaAdmin(String namaAdmin);
}
