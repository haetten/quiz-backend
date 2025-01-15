package br.com.fhsistemas.quizapp.safdarjamal;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.fhsistemas.quizapp.entity.question.Category;
import br.com.fhsistemas.quizapp.entity.question.Question;
import br.com.fhsistemas.quizapp.entity.question.Question.QuestionDifficulty;
import br.com.fhsistemas.quizapp.entity.question.Question.QuestionType;
import br.com.fhsistemas.quizapp.filter.QuestionFilter;
import br.com.fhsistemas.quizapp.service.CategoryService;
import br.com.fhsistemas.quizapp.service.QuestionService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/safdar-jamal", produces = MediaType.APPLICATION_JSON_VALUE)
public class SafdarJamalController {

	protected final QuestionService questoesService;

	protected final CategoryService categoryService;
		
	protected SafdarJamalController(QuestionService questoesService, CategoryService categoryService) {
		this.questoesService = questoesService;
		this.categoryService = categoryService;
	}

    @GetMapping(value = "/questions/count")
	public ResponseEntity<Long> countQuestions(
			@RequestParam(required = true) Integer amount,
			@RequestParam(required = false) Long category,
			@RequestParam(required = false) QuestionDifficulty difficulty,
			@RequestParam(required = false) QuestionType type,
			@RequestParam(required = false) String question
) {
		Long count = questoesService.count(new QuestionFilter(amount, category, difficulty, type, question));
				
		return ResponseEntity.ok(count);
	}

    @GetMapping(value = "/questions")
	public ResponseEntity<ApiResponse> getQuestions(
			@RequestParam(required = true) Integer amount,
			@RequestParam(required = false) Long category,
			@RequestParam(required = false) QuestionDifficulty difficulty,
			@RequestParam(required = false) QuestionType type,
			@RequestParam(required = false) String question
) {
		
		List<QuestionDTO> results = new ArrayList<>();
		List<Question> questions = questoesService.find(new QuestionFilter(amount, category, difficulty, type, question));
		
		questions.forEach(obj ->  results.add(new QuestionDTO(obj)));
		
		return ResponseEntity.ok(new ApiResponse(200, results));
	}

    @GetMapping(value = "/categories")
	public ResponseEntity<?> getCategories() {
		
		List<CategoryDTO> results = new ArrayList<>();
		List<Category> categories = categoryService.find();
		
		categories.forEach(obj ->  results.add(new CategoryDTO(obj)));
		
		return ResponseEntity.ok(results);
	}

}
