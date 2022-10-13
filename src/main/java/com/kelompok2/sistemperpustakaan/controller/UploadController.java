package com.kelompok2.sistemperpustakaan.controller;

import com.kelompok2.sistemperpustakaan.model.entity.UploadFileBuku;
import com.kelompok2.sistemperpustakaan.service.UploadBukuService;
import com.kelompok2.sistemperpustakaan.service.UploadFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@RestController
@RequestMapping("/req")
public class UploadController {

    @Autowired
    private UploadFileService uploadFileService;
    @Autowired
    private UploadBukuService uploadBukuService;

    @PostMapping("/upload")
    public void uploadFile(@RequestParam("file") MultipartFile file) throws IllegalStateException, IOException {
        uploadFileService.uploadToLocal(file);
    }

    @PostMapping("/uploaddb")
    public void uploadFiledb(@RequestParam("file") MultipartFile file) throws IllegalStateException, IOException {
        uploadFileService.uploadToDb(file);
        uploadFileService.uploadToLocal(file);
    }

    @PostMapping("/upload/buku")
    public void uploadFileBuku(@RequestParam("file") MultipartFile file) throws IllegalStateException, IOException {
        uploadBukuService.uploadToLocal(file);
        uploadBukuService.uploadToDb(file);
    }
    @GetMapping("/download/{id}")
    public Optional<UploadFileBuku> DownloadFile(@PathVariable String id){
        return uploadBukuService.DownloadFile(id);
    }

}