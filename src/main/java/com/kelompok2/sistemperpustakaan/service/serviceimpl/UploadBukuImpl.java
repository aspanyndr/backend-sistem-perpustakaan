package com.kelompok2.sistemperpustakaan.service.serviceimpl;

import com.kelompok2.sistemperpustakaan.model.entity.UploadFileBuku;
import com.kelompok2.sistemperpustakaan.repository.UploadBukuRepository;
import com.kelompok2.sistemperpustakaan.service.UploadBukuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

@Service

public class UploadBukuImpl implements UploadBukuService {

    private String uploadFolderPath = "C:\\Users\\lenovo\\Documents\\Nurulfik\\";


    @Autowired
    public UploadBukuRepository uploadBukuRepository;

    @Override
    public void uploadToLocal(MultipartFile file) {
        try{
            byte[] data = file.getBytes();
            Path path = Paths.get(uploadFolderPath+file.getOriginalFilename()) ;
            Files.write(path,data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void uploadToDb(MultipartFile file) {
        UploadFileBuku uploadFileBuku = new UploadFileBuku();
        try {
            uploadFileBuku.setFileData(file.getBytes());
            uploadFileBuku.setFileType(file.getContentType());
            uploadFileBuku.setFileName(file.getOriginalFilename());
            uploadBukuRepository.save(uploadFileBuku);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<UploadFileBuku> DownloadFile(String FileId) {
        Optional<UploadFileBuku> uploadFileBuku = uploadBukuRepository.findById(FileId);
        return uploadFileBuku;
    }


}
