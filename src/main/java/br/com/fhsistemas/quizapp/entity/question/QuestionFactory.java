package br.com.fhsistemas.quizapp.entity.question;

import java.util.Arrays;
import java.util.HashSet;

import br.com.fhsistemas.quizapp.dto.QuestionSaveRequest;
import br.com.fhsistemas.quizapp.service.QuestionService;

public class QuestionFactory {
	
    private final QuestionService service;

    public QuestionFactory(QuestionService service) {
        this.service = service;
    }

    public Question createQuestion(QuestionSaveRequest obj) {
        switch (obj.getType()) {
                
            case MULTIPLE:			
				QuestionMultiple q1 = obj.getId() == null ?new QuestionMultiple() : service.findMultipleById(obj.getId());
				return createMultipleChoiceQuestion(q1, obj);
				
            case BOOLEAN:
				QuestionBoolean q = obj.getId() == null ? new QuestionBoolean() : service.findBooleanById(obj.getId());
				return createBooleanQuestion(q, obj);
				
            default:
            	throw new IllegalArgumentException("Unsupported question type");
            	
        }
		
    }
    
    private void updatebasic(Question question, QuestionSaveRequest obj) {
        question.setCategoryId(obj.getCategoryId());
        question.setQuestion(obj.getQuestion());
        question.setDifficulty(obj.getDifficulty());
        question.setExplanation(obj.getExplanation());
    	
    }

    private QuestionMultiple createMultipleChoiceQuestion(QuestionMultiple question, QuestionSaveRequest obj) {
        updatebasic(question, obj);

        question.setCorrectAnswer(obj.getCorrectAnswer());
        
		question.getIncorrectAnswers().clear();
		
        for (String incorrectAnswer : new HashSet<>(Arrays.asList(obj.getIncorrectAnswers()))) {
            question.addIncorrectAnswer(incorrectAnswer);
        }

        return question;
    }


    private QuestionBoolean createBooleanQuestion(QuestionBoolean question, QuestionSaveRequest obj) {
        updatebasic(question, obj);
        
        question.setCorrectAnswer(Boolean.parseBoolean(obj.getCorrectAnswer()));

        return question;
    }
}