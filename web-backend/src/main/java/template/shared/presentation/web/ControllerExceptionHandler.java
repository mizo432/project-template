package template.shared.presentation.web;

import com.undecided.gfw.common.exception.BusinessException;
import com.undecided.gfw.common.exception.ExceptionLogger;
import com.undecided.gfw.common.exception.ResourceNotFoundException;
import com.undecided.gfw.common.exception.SystemException;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * コントローラーで発生する例外をここでハンドリングする為のクラス
 */
@ControllerAdvice
public class ControllerExceptionHandler {
    private static final ExceptionLogger exceptionLogger = new ExceptionLogger();

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({ResourceNotFoundException.class})
    public String handleResourceNotFoundException(ResourceNotFoundException e, Model model) {
        model.addAttribute("exception", e);
        return "/error/404";
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({BusinessException.class})
    public String handleBusinessException(BusinessException e, Model model) {
        model.addAttribute("exception", e);
        return "error/400";
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler({SystemException.class})
    public String handleSystemException(SystemException e, Model model) {
        exceptionLogger.log(e);
        model.addAttribute("exception", e);
        return "error/500";
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler({RuntimeException.class})
    public String handleRuntimeException(RuntimeException e, Model model) {
        exceptionLogger.log(e);
        model.addAttribute("exception", e);
        return "error/500";
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler({Exception.class})
    public String handleException(Exception e, Model model) {
        exceptionLogger.log(e);
        model.addAttribute("exception", e);
        return "error/500";
    }
}
