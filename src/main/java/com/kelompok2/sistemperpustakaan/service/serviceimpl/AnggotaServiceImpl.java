package com.kelompok2.sistemperpustakaan.service.serviceimpl;

import com.kelompok2.sistemperpustakaan.model.dto.AnggotaDto;
import com.kelompok2.sistemperpustakaan.model.dto.DataDto;
import com.kelompok2.sistemperpustakaan.model.dto.DefaultResponse;
import com.kelompok2.sistemperpustakaan.model.dto.LoginDto;
import com.kelompok2.sistemperpustakaan.model.entity.Anggota;
import com.kelompok2.sistemperpustakaan.repository.AnggotaRepository;
import com.kelompok2.sistemperpustakaan.service.AnggotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AnggotaServiceImpl implements AnggotaService {

    @Autowired
    private AnggotaRepository anggotaRepository;

    @Override
    public DefaultResponse loginAnggota(LoginDto loginDto) {
        Optional <Anggota> optionalAnggota = anggotaRepository.
                findByUserNameAndPasswordAnggota(
                        loginDto.getUname(),
                        loginDto.getPass());
        Anggota anggota = new Anggota();
        DefaultResponse defaultResponse = new DefaultResponse();

        if(optionalAnggota.isPresent()){
            defaultResponse.setStatus(true);
            defaultResponse.setMessage("Login Berhasil");
        }
        else{
            defaultResponse.setStatus(false);
            defaultResponse.setMessage("Login Berhasil");
        }
        return defaultResponse;
    }

    @Override
    public DefaultResponse anggotaSave(AnggotaDto anggotaDto) {
        Anggota anggota = convertDtoToEntity(anggotaDto);
        DefaultResponse <AnggotaDto> dto = new DefaultResponse<>();
        Optional <Anggota> optionalAnggota = anggotaRepository.
                findByIdAnggota(anggota.getIdAnggota());
        if(optionalAnggota.isEmpty()){
            anggotaRepository.save(anggota);
            dto.setMessage("Data anda sudah disimpan");
            dto.setStatus(true);
        }
        else {
            dto.setMessage("Data yang anda masukan sudah tersedia");
            dto.setStatus(false);
        }
        return dto;
    }

    @Override
    public DataDto getByIdAnggota(Integer idAnggota) {
        DataDto<AnggotaDto> data = new DataDto<>();
        Optional<Anggota> opt = anggotaRepository.findByIdAnggota(idAnggota);
        if (opt.isPresent()) {
            data.setMessage("Data Ditemukan");
            data.setData(convertEntityToDto(opt.get()));
        } else {
            data.setMessage("Data Tidak Ditemukan");
        }
        return data;
    }

    @Override
    public List getListAnggota() {
        List<AnggotaDto> list = new ArrayList();
        for(Anggota anggota : anggotaRepository.findAll()){
            list.add(convertEntityToDto(anggota));
        }
        return list;
    }

    @Override
    public DefaultResponse updateAnggota(Integer idAnggota, AnggotaDto anggotaDto) {
        DefaultResponse defResA = new DefaultResponse();
        Optional<Anggota> optAng = anggotaRepository.findByIdAnggota(idAnggota);
        Anggota objAng = optAng.get();
        if (optAng.isPresent()) {

            objAng.setUserName(anggotaDto.getUserName());
            objAng.setNoHpAnggota(anggotaDto.getNoHpAnggota());
            objAng.setJkAnggota(anggotaDto.getJkAnggota());
            objAng.setStatusAnggota(anggotaDto.getStatusAnggota());
            objAng.setAlamatAnggota(anggotaDto.getAlamatAnggota());
            objAng.setNamaAnggota(anggotaDto.getNamaAnggota());
            objAng.setPekerjaan(anggotaDto.getPekerjaan());
            objAng.setPasswordAnggota(anggotaDto.getPasswordAnggota());

            anggotaRepository.save(objAng);
            defResA.setStatus(Boolean.TRUE);
            defResA.setMessage("Data Berhasil Disimpan");
        } else {
            defResA.setStatus(Boolean.FALSE);
            defResA.setMessage("Kode Sudah Terdaftar");
        }
        return defResA;
    }

    @Override
    public DefaultResponse deleteIdAnggota(Integer idAnggota) {
        DefaultResponse df = new DefaultResponse();
        Optional<Anggota> optAg =anggotaRepository.findByIdAnggota(idAnggota);
        if (optAg.isPresent()){
            anggotaRepository.delete(optAg.get());
            df.setStatus(Boolean.TRUE);
            df.setMessage("Data idAnggota Berhasil Dihapus");
        } else {
            df.setStatus(Boolean.FALSE);
            df.setMessage("Data Tidak Ditemukan");
        }
        return df;
    }

    public Anggota convertDtoToEntity(AnggotaDto anggotaDto){
        Anggota anggota = new Anggota();

        anggota.setIdAnggota(anggotaDto.getIdAnggota());
        anggota.setUserName(anggotaDto.getUserName());
        anggota.setNamaAnggota(anggotaDto.getNamaAnggota());
        anggota.setJkAnggota(anggotaDto.getJkAnggota());
        anggota.setPekerjaan(anggotaDto.getPekerjaan());
        anggota.setAlamatAnggota(anggotaDto.getAlamatAnggota());
        anggota.setNoHpAnggota(anggotaDto.getNoHpAnggota());
        anggota.setPasswordAnggota(anggotaDto.getPasswordAnggota());
        anggota.setStatusAnggota(anggotaDto.getStatusAnggota());

        return anggota;
    }

    public AnggotaDto convertEntityToDto(Anggota entity){
        AnggotaDto dto = new AnggotaDto();

        dto.setIdAnggota(entity.getIdAnggota());
        dto.setUserName(entity.getUserName());
        dto.setNamaAnggota(entity.getNamaAnggota());
        dto.setJkAnggota(entity.getJkAnggota());
        dto.setPekerjaan(entity.getPekerjaan());
        dto.setAlamatAnggota(entity.getAlamatAnggota());
        dto.setNoHpAnggota(entity.getNoHpAnggota());
        dto.setPasswordAnggota(entity.getPasswordAnggota());
        dto.setStatusAnggota(entity.getStatusAnggota());

        return dto;
    }
}
