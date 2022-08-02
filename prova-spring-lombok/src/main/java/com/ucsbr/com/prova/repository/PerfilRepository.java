package com.ucsbr.com.prova.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ucsbr.com.prova.entity.Perfil;

@Repository
public interface PerfilRepository extends JpaRepository<Perfil, Long> {}
