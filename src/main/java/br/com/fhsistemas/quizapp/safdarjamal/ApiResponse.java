package br.com.fhsistemas.quizapp.safdarjamal;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApiResponse {
    private int responseCode;
    private Object results;

}
