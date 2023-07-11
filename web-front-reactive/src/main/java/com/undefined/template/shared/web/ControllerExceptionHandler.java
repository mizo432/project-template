package com.undefined.template.shared.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.thymeleaf.exceptions.TemplateInputException;

@Slf4j
@ControllerAdvice
public class ControllerExceptionHandler {
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({TemplateInputException.class})
    public String handleNotFound(TemplateInputException e, Model model) {
        log.info(e.getMessage());
        model.addAttribute("exception", e);
        return "error/404";
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({NumberFormatException.class})
    public String handleBadNumberValue(NumberFormatException e, Model model) {
        log.info(e.getMessage());
        model.addAttribute("exception", e);
        return "error/400";
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler({Exception.class})
    public String handleBadNumberValue(Exception e, Model model) {
        log.error(e.getMessage());
        model.addAttribute("exception", e);
        return "error/500";
    }
}
