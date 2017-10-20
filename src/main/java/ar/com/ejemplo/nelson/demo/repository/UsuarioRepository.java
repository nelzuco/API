package ar.com.ejemplo.nelson.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.com.ejemplo.nelson.demo.entities.UsuarioEntity;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {

}
