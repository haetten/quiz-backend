package br.com.fhsistemas.quizapp.dto;

import org.springframework.lang.NonNull;

import br.com.fhsistemas.quizapp.entity.question.Question.QuestionType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponderQuestaoDTO {
	
	@NonNull
	protected Long idQuestaoCaderno;

	protected QuestionType tipoQuestao;
	
	protected Long idAlternativaSelecionada;
	
	protected Boolean respondeuCerto;
	
	
	
	
	
}	
