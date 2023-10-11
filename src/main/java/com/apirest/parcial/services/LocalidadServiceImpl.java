package com.apirest.parcial.services;
import com.apirest.parcial.entities.Localidad;
import com.apirest.parcial.entities.Persona;
import com.apirest.parcial.repositories.BaseRepository;
import com.apirest.parcial.repositories.LocalidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocalidadServiceImpl extends BaseServiceImpl<Localidad,Long> implements LocalidadService {
    @Autowired
    private LocalidadRepository localidadRepository;

    public LocalidadServiceImpl(BaseRepository<Localidad, Long> baseRepository) {
        super(baseRepository);
    }

    @Override
    public List<Localidad> search(String filtro) throws Exception {
        try {
            List<Localidad> localidades = localidadRepository.search2(filtro);
            return localidades;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Page<Localidad> search(String filtro, Pageable pageable) throws Exception {
        try {
            Page<Localidad> localidades = localidadRepository.search2(filtro, pageable);
            return localidades;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

}
