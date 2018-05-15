package by.bsuir.talakh.controller;

import by.bsuir.talakh.entity.JsObject;
import by.bsuir.talakh.service.JsObjectService;
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
@RequestMapping("/object")
public class JsObjectController {
    @Autowired
    private JsObjectService service;

    public JsObjectController() {
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<JsObject> getJsObjectById(@PathVariable("id") int id) {
        Optional<JsObject> jsObject = service.findById(id);
        return jsObject.map(jsObject1 -> new ResponseEntity<>(jsObject1, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<JsObject>> takeAllJsObjects() {
        List<JsObject> jsObjectList = service.takeAll();
        return new ResponseEntity<>(jsObjectList, HttpStatus.OK);
    }

    @GetMapping(value = "/name/{name}")
    public ResponseEntity<JsObject> getJsObjectByName(@PathVariable("name") String name) {
        Optional<JsObject> jsObject = service.findByName(name);
        return jsObject.map(jsObject1 -> new ResponseEntity<>(jsObject1, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping(value = "/add")
    public ResponseEntity<JsObject> saveJsObject(@RequestBody JsObject jsObject) {
        JsObject object = service.save(jsObject);
        return new ResponseEntity<>(object,HttpStatus.OK);
    }

    @PutMapping(value = {"/{id}"})
    public ResponseEntity<Void> updateJsObject(@PathVariable("id") int id, @RequestBody JsObject jsObject) {
        service.update(id, jsObject);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteJsObject(@PathVariable("id") int id) {
        service.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }
}
