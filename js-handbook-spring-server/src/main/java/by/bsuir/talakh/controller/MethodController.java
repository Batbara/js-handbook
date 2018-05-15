package by.bsuir.talakh.controller;

import by.bsuir.talakh.entity.Method;
import by.bsuir.talakh.service.MethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/method")
public class MethodController {

    @Autowired
    private MethodService service;

    public MethodController() {
    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<Method> getMethodById(@PathVariable("id") int id) {
        Optional<Method> method = service.findById(id);
        return method.map(method1 -> new ResponseEntity<>(method1, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @GetMapping(value = "/all/for/{id}")
    public ResponseEntity<List<Method>> takeAllMethods(@PathVariable("id") int id) {
        List<Method> methodList = service.takeAllForObject(id);
        return new ResponseEntity<>(methodList, HttpStatus.OK);
    }

    @GetMapping(value = "/name/{name}")
    public ResponseEntity<Method> getMethodByName(@PathVariable("name") String name) {
        Optional<Method> method = service.findByName(name);
        return method.map(method1 -> new ResponseEntity<>(method1, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<Method> saveMethod(@RequestBody Method method) {
        Method newMethod = service.save(method);
        return new ResponseEntity<>(newMethod, HttpStatus.OK);
    }

    @PutMapping(value = {"/{id}"})
    public ResponseEntity<Void> updateMethod(@PathVariable("id")int id, @RequestBody Method method) {
        service.update(id, method);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteMethod(@PathVariable("id")int id) {
        service.deleteById(id);

        return new ResponseEntity<>(HttpStatus.OK);

    }


}
