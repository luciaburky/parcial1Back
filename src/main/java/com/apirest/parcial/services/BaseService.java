package com.apirest.parcial.services;
import com.apirest.parcial.entities.BaseEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

// INTERFAZ GENÉRICA
public interface BaseService<E extends BaseEntity, Id extends Serializable> {
    // declaramos metodos principales
    // son generales, le podemos pasar una persona, autor, libro, etc

    public List<E> findAll() throws Exception;
    // me trae todos los objetos de esa entidad de la bd
    public Page<E> findAll(Pageable pageable) throws Exception;
    public E findbyId(Id id) throws Exception;
    // me trae el objeto q cumpla con ese id

    public E save(E entity) throws Exception;
    // guardamos un objeto en la bd, enviamos la entity al repositorio

    public E update(Id id, E entity) throws Exception;
    // pasamos el id del objeto a actualizar y el entity

    public boolean delete(Id id) throws Exception;
    // elimina registro de la base de datos
}
