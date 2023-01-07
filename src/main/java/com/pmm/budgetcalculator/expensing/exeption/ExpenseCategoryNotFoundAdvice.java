package com.pmm.budgetcalculator.expensing.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExpenseCategoryNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(ExpenseCategoryNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String expenseCategoryNotFoundHandler(ExpenseCategoryNotFoundException ex) {

        return ex.getMessage();
    }
}

