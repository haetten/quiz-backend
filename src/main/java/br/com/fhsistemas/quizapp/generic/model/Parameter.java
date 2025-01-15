package br.com.fhsistemas.quizapp.generic.model;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Parameter{
	String nome;
	String query;
	Object valor;
	
	public Parameter(String query, Object valor) {
		super();
		
		this.nome = "p"+UUID.randomUUID().toString().replace("-", "").substring(0, 8);
		this.query = query.replace("?", ":" + nome);
		this.valor = valor;
	}
	
	
}
