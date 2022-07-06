package com.mayki.projcadastrobiblioteca.repository;

import com.mayki.projcadastrobiblioteca.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Integer> {
}
