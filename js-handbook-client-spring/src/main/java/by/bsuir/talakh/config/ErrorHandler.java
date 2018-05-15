package by.bsuir.talakh.config;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

@Controller
public class ErrorHandler implements ErrorController {
    @RequestMapping(value = "/error")
    public ModelAndView error(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView(getErrorPath());
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        String errorMessage = "Sorry, something went wrong, but we will fix this soon!";
        Integer statusCode = Integer.valueOf(status.toString());

        if (statusCode == HttpStatus.NOT_FOUND.value()) {
            errorMessage = "Sorry, this page is not found";
        }
        modelAndView.addObject("errorMessage", errorMessage);
        return modelAndView;
    }

    @Override
    public String getErrorPath() {
        return "error";
    }
}
