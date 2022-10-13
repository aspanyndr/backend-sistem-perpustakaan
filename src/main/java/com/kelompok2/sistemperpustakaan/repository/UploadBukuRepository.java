package com.kelompok2.sistemperpustakaan.repository;

import com.kelompok2.sistemperpustakaan.model.entity.UploadFileBuku;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UploadBukuRepository extends JpaRepository<UploadFileBuku, String> {
}
