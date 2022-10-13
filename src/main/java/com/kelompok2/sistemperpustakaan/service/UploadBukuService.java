package com.kelompok2.sistemperpustakaan.service;

import com.kelompok2.sistemperpustakaan.model.entity.UploadFileBuku;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

public interface UploadBukuService {
    public void uploadToLocal(MultipartFile file);
    public void uploadToDb(MultipartFile file);
    public Optional<UploadFileBuku> DownloadFile(String FileId);
}
