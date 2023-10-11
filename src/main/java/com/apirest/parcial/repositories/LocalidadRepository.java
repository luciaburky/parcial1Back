package com.apirest.parcial.repositories;
import com.apirest.parcial.entities.Localidad;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocalidadRepository extends BaseRepository<Localidad, Long> {
    List<Localidad> findByDenominacionContaining(String denominacion);
    Page<Localidad> findByDenominacionContaining(String denominacion, Pageable pageable);

    // anotacion JPQL parametros indexados
    @Query(value = "SELECT l FROM Localidad l WHERE l.denominacion LIKE %:filtro%")
    // con el ?1 indicamos que es indexado y q solo se pasa 1 parámetro
    List<Localidad> search(@Param("filtro") String filtro);

    @Query(value = "SELECT l FROM Localidad l WHERE l.denominacion LIKE %:filtro%")
    Page<Localidad> search(@Param("filtro") String filtro, Pageable pageable);

    @Query(
            value = "SELECT * FROM Localidad WHERE localidad.denominacion LIKE %:filtro%",
            nativeQuery = true
    )
        // con el ?1 indicamos que es indexado y q solo se pasa 1 parámetro
    List<Localidad> search2(@Param("filtro") String filtro);

    //query nativa con paginación
    @Query(
            value = "SELECT * FROM Localidad WHERE localidad.denominacion LIKE %:filtro%",
            countQuery = "SELECT count(*) FROM Localidad",
            nativeQuery = true
    )
    // con el ?1 indicamos que es indexado y q solo se pasa 1 parámetro
    Page<Localidad> search2(@Param("filtro") String filtro, Pageable pageable);
}

