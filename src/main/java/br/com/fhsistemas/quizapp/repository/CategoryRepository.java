package br.com.fhsistemas.quizapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fhsistemas.quizapp.entity.question.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
