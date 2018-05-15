package by.bsuir.talakh.controller;

import by.bsuir.talakh.entity.Operator;
import by.bsuir.talakh.service.OperatorService;
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
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/operator")
public class OperatorController {
    @Autowired
    private OperatorService service;

    public OperatorController() {
    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<Operator> getOperatorById(@PathVariable("id") int id) {
        Optional<Operator> operator = service.findById(id);
        return operator.map(operator1 -> new ResponseEntity<>(operator1, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<Operator>> takeAllOperators() {
        List<Operator> operatorList = service.takeAll();
        return new ResponseEntity<>(operatorList, HttpStatus.OK);
    }

    @GetMapping(value = "/name/{name}")
    public ResponseEntity<Operator> getOperatorByName(@PathVariable("name") String name) {
        Optional<Operator> operator = service.findByName(name);
        return operator.map(operator1 -> new ResponseEntity<>(operator1, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping(value = "/add")
    public ResponseEntity<Operator> saveOperator(@RequestBody Operator operator) {
        Operator addedOperator = service.save(operator);
        return new ResponseEntity<>(addedOperator, HttpStatus.OK);
    }

    @PutMapping(value = {"/{id}"})
    public ResponseEntity<Void> updateOperator(@PathVariable("id") int id, @RequestBody Operator operator) {
        service.update(id, operator);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteOperator(@PathVariable("id") int id) {
        service.deleteById(id);

        return new ResponseEntity<>(HttpStatus.OK);

    }
}
