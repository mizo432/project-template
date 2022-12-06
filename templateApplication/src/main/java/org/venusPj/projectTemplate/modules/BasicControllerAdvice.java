package org.venusPj.projectTemplate.modules;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.venusPj.gfw.web.token.transaction.InvalidTransactionTokenException;

@ControllerAdvice
public class BasicControllerAdvice {

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.initDirectFieldAccess();

    }

    @ExceptionHandler(InvalidTransactionTokenException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public String invalidTransactionTokenExceptionHandler(InvalidTransactionTokenException e) {
        // 省略
        return "redirect:/error";
    }
}
