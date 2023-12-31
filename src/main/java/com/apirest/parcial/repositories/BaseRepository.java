package com.apirest.parcial.repositories;
import com.apirest.parcial.entities.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

@NoRepositoryBean
public interface BaseRepository <E extends BaseEntity, Id extends Serializable> extends JpaRepository <E, Id>{

}