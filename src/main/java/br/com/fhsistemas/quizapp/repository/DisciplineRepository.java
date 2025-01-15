package br.com.fhsistemas.quizapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fhsistemas.quizapp.entity.question.Discipline;

public interface DisciplineRepository extends JpaRepository<Discipline, Long> {

}