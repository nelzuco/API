package ar.com.ejemplo.nelson.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.com.ejemplo.nelson.demo.entities.LibroEntity;

public interface LibroRepository extends JpaRepository<LibroEntity, Long> {

}
