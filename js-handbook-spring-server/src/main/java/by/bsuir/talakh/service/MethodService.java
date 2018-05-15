package by.bsuir.talakh.service;

import by.bsuir.talakh.dao.MethodDao;
import by.bsuir.talakh.entity.Method;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MethodService implements IService<Method> {

    @Autowired
    private MethodDao dao;

    public List<Method> takeAllForObject(int id) {
        return dao.takeAllForObject(id);
    }

    @Override
    public List<Method> takeAll() {
        return dao.findAll();
    }

    @Override
    public Optional<Method> findById(int id) {
        return dao.findById(id);
    }

    @Override
    public Optional<Method> findByName(String name) {
        return Optional.of(dao.findByName(name));
    }


    @Override
    public Method save(Method entity) {
        return dao.saveAndFlush(entity);
    }

    @Override
    public void deleteById(int id) {
        dao.deleteById(id);
    }

    @Override
    public void update(int id, Method entity) {
        dao.save(entity);
    }
}
