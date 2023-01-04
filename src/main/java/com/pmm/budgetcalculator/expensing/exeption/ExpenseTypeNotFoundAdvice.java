package com.pmm.budgetcalculator.expensing.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;


@ControllerAdvice
public class ExpenseTypeNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(ExpenseTypeNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String expenseTypeNotFoundHandler(ExpenseTypeNotFoundException ex) {

        return ex.getMessage();
    }
}

