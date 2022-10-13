package com.kelompok2.sistemperpustakaan.service;

import org.springframework.web.multipart.MultipartFile;

public interface UploadFileService {
    public void uploadToLocal(MultipartFile file);
    public void uploadToDb(MultipartFile file);
}
