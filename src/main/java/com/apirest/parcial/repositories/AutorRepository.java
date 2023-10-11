package com.apirest.parcial.repositories;
import com.apirest.parcial.entities.Autor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AutorRepository extends BaseRepository<Autor, Long> {
    List<Autor> findByNombreContainingOrApellidoContaining(String nombre, String apellido);
    Page<Autor> findByNombreContainingOrApellidoContaining(String nombre, String apellido, Pageable pageable);

    // anotacion JPQL parametros indexados
    @Query(value = "SELECT a FROM Autor a WHERE a.nombre LIKE %:filtro% OR a.apellido LIKE %:filtro%")
    // con el ?1 indicamos que es indexado y q solo se pasa 1 parámetro
    List<Autor> search(@Param("filtro") String filtro);

    @Query(value = "SELECT a FROM Autor a WHERE a.nombre LIKE %:filtro% OR a.apellido LIKE %:filtro%")
    Page<Autor> search(@Param("filtro") String filtro, Pageable pageable);

    @Query(
            value = "SELECT * FROM Autor WHERE autor.nombre LIKE %:filtro% OR autor.apellido LIKE %:filtro%",
            nativeQuery = true
    )
        // con el ?1 indicamos que es indexado y q solo se pasa 1 parámetro
    List<Autor> search2(@Param("filtro") String filtro);

    //query nativa con paginación
    @Query(
            value = "SELECT * FROM Autor WHERE autor.nombre LIKE %:filtro% OR autor.apellido LIKE %:filtro%",
            countQuery = "SELECT count(*) FROM Autor",
            nativeQuery = true
    )
    // con el ?1 indicamos que es indexado y q solo se pasa 1 parámetro
    Page<Autor> search2(@Param("filtro") String filtro, Pageable pageable);
}