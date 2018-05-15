package by.bsuir.talakh.controller;

import by.bsuir.talakh.entity.Method;
import by.bsuir.talakh.repository.MethodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/method")
public class MethodController {
    @Autowired
    private MethodRepository repository;

    @RequestMapping("/{id}")
    public ModelAndView redirectToMethod(@PathVariable("id") int id, ModelAndView modelAndView) {
        Method method = repository.findById(id).get();
        modelAndView.addObject("method", method);
        modelAndView.setViewName("method");
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView addMethod(@ModelAttribute("newMethod") Method method, ModelAndView modelAndView) {
        Method added = repository.save(method);
        modelAndView.addObject("method", added);
        String redirectAddress = String.format("redirect:/method/%d", added.getId());
        modelAndView.setViewName(redirectAddress);
        return modelAndView;
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public ModelAndView updateMethod(@PathVariable("id") int id, @ModelAttribute("method") Method method,
                                     ModelAndView modelAndView) {
        repository.update(id, method);
        modelAndView.addObject("method", repository.findById(id));
        String redirectAddress = String.format("redirect:/method/%d", id);
        modelAndView.setViewName(redirectAddress);
        return modelAndView;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public ModelAndView deleteMethod(@PathVariable("id") int id, ModelAndView modelAndView) {
        repository.deleteById(id);
        modelAndView.setViewName("redirect:/");
        return modelAndView;
    }
    /*@ModelAttribute("method")
    public Method getUserObject() {
        return new Method();

    }
    /*
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView redirectToObject(){
       return new ModelAndView("method","method",new Method());
    }*/

}
