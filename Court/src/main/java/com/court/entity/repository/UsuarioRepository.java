package com.court.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.court.entity.Usuario;

public interface UsuarioRepository extends JpaRepository <Usuario,Long>  {

}
