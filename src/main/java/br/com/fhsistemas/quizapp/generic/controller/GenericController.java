package br.com.fhsistemas.quizapp.generic.controller;

import java.io.Serializable;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.fhsistemas.quizapp.generic.model.PersistentEntity;
import br.com.fhsistemas.quizapp.generic.service.GenericService;

public abstract class GenericController<
	T extends PersistentEntity<I>
  , I extends Serializable
  , S extends GenericService<T, I>
> {

	protected S service;

    protected GenericController(S service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<T>> find() {
        return ResponseEntity.ok(service.find());
    }

    @GetMapping(value = "/count")
    public ResponseEntity<Long> count() {
        return ResponseEntity.ok(service.count());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<T> findById(@PathVariable I id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<T> save(@RequestBody T obj) {
        return ResponseEntity.ok(service.save(obj));
    }

    @PutMapping
    public ResponseEntity<T> update(@RequestBody T obj) {
        return ResponseEntity.ok(service.update(obj));
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@RequestBody I id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
    
}
