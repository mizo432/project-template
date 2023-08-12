package template.shared.presentation.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * コントローラーで発生する例外をここでハンドリングする為のクラス
 */
@Slf4j
@ControllerAdvice
public class ControllerExceptionHandler {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({NumberFormatException.class})
    public String handleBadNumberValue(NumberFormatException e, Model model) {
        log.info(e.getMessage(), e);
        model.addAttribute("exception", e);
        return "error/400";
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler({RuntimeException.class})
    public String handleRuntimeException(RuntimeException e, Model model) {
        log.error(e.getMessage(), e);
        model.addAttribute("exception", e);
        return "error/500";
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler({Exception.class})
    public String handleException(Exception e, Model model) {
        log.error(e.getMessage(), e);
        model.addAttribute("exception", e);
        return "error/500";
    }
}
