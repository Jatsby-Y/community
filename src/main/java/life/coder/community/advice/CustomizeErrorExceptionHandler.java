package life.coder.community.advice;

import life.coder.community.exception.CustomizeException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Karl
 * @date 2019年 11月19日 15:33:18
 */
@ControllerAdvice
public class CustomizeErrorExceptionHandler {
    @ExceptionHandler(Exception.class)
    ModelAndView handle(Throwable e, Model model) {
        if (e instanceof CustomizeException) {
            model.addAttribute("message", e.getMessage());
        } else {
            model.addAttribute("message", "服务器冒烟啦，要不然你稍后再试试？");
        }
        return new ModelAndView("error");
    }
}
