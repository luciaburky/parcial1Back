package com.apirest.parcial.services;
import com.apirest.parcial.entities.Autor;
import com.apirest.parcial.entities.Persona;
import com.apirest.parcial.repositories.AutorRepository;
import com.apirest.parcial.repositories.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorServiceImpl extends BaseServiceImpl<Autor,Long> implements AutorService{
    @Autowired
    private AutorRepository autorRepository;

    public AutorServiceImpl(BaseRepository<Autor, Long> baseRepository) {
        super(baseRepository);
    }

    @Override
    public List<Autor> search(String filtro) throws Exception {
        try {
            List<Autor> autores = autorRepository.search2(filtro);
            return autores;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Page<Autor> search(String filtro, Pageable pageable) throws Exception {
        try {
            Page<Autor> autores = autorRepository.search2(filtro, pageable);
            return autores;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }


}
