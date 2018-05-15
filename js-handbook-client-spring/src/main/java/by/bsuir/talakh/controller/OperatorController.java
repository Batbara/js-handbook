package by.bsuir.talakh.controller;

import by.bsuir.talakh.entity.Operator;
import by.bsuir.talakh.repository.OperatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/operator")
public class OperatorController {
    @Autowired
    private OperatorRepository repository;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ModelAndView redirectToOperator(@PathVariable("id") int id, ModelAndView modelAndView) {
        modelAndView.addObject("operator", repository.findById(id).get());
        modelAndView.setViewName("operator");
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView addOperator(@ModelAttribute("newOperator") Operator operator, ModelAndView modelAndView) {
        Operator newOperator = repository.save(operator);
        modelAndView.addObject("operator", newOperator);
        String redirectAddress = String.format("redirect:/operator/%d", newOperator.getId());
        modelAndView.setViewName(redirectAddress);
        return modelAndView;
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public ModelAndView updateOperator(@PathVariable("id") int id, @ModelAttribute("operator") Operator operator, ModelAndView modelAndView) {
        repository.update(id, operator);
        modelAndView.addObject("operator", operator);
        String redirectAddress = String.format("redirect:/operator/%d", id);
        modelAndView.setViewName(redirectAddress);
        return modelAndView;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public ModelAndView deleteOperator(@PathVariable("id") int id, ModelAndView modelAndView) {
        repository.deleteById(id);
        modelAndView.clear();
        modelAndView.setViewName("redirect:/");
        return modelAndView;
    }
}
