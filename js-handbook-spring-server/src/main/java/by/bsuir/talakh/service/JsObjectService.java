package by.bsuir.talakh.service;

import by.bsuir.talakh.dao.JsObjectDao;
import by.bsuir.talakh.entity.JsObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JsObjectService implements IService<JsObject> {
    @Autowired
    private JsObjectDao dao;

    @Override
    public List<JsObject> takeAll() {
        return dao.findAll();
    }

    @Override
    public Optional<JsObject> findById(int id) {
        return dao.findById(id);
    }

    @Override
    public Optional<JsObject> findByName(String name) {
        return Optional.of(dao.findByName(name));
    }

    @Override
    public JsObject save(JsObject entity) {
        return dao.saveAndFlush(entity);
    }

    @Override
    public void deleteById(int id) {
        dao.deleteById(id);
    }

    @Override
    public void update(int id, JsObject entity) {
        dao.save(entity);
    }
}
