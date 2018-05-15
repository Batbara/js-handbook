package by.bsuir.talakh.controller;

import by.bsuir.talakh.entity.JsObject;
import by.bsuir.talakh.entity.Method;
import by.bsuir.talakh.repository.JsObjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/object")
public class JsObjectController {
    @Autowired
    private JsObjectRepository repository;

    @RequestMapping("/{id}")
    public ModelAndView redirectToObject(@PathVariable("id") int id, ModelAndView modelAndView) {
        modelAndView.addObject("jsObject", repository.findById(id).get());
        modelAndView.setViewName("jsObject");
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView addJsObject(@ModelAttribute("newJsObject") JsObject jsObject, ModelAndView modelAndView) {
        JsObject addedObject = repository.save(jsObject);
        modelAndView.addObject("jsObject", addedObject);
        modelAndView.setViewName("jsObject");
        return modelAndView;
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public ModelAndView updateJsObject(@PathVariable("id") int id, @ModelAttribute("jsObject") JsObject jsObject,
                                   ModelAndView modelAndView) {
        repository.update(id, jsObject);
        modelAndView.addObject("jsObject", jsObject);
        modelAndView.setViewName("jsObject");
        return modelAndView;
    }
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public ModelAndView deleteJsObject(@PathVariable("id") int id,
                                   ModelAndView modelAndView) {
        repository.deleteById(id);
        modelAndView.clear();
        modelAndView.setViewName("redirect:/");
        return modelAndView;
    }
}
