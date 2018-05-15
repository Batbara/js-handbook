package by.bsuir.talakh.service;

import by.bsuir.talakh.dao.OperatorDao;
import by.bsuir.talakh.entity.Operator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OperatorService implements IService<Operator> {
    @Autowired
    private OperatorDao dao;
    @Override
    public List<Operator> takeAll() {
        return dao.findAll();
    }

    @Override
    public Optional<Operator> findById(int id) {
        return dao.findById(id);
    }

    @Override
    public Optional<Operator> findByName(String name) {
        return Optional.of(dao.findByName(name));
    }

    @Override
    public Operator save(Operator entity) {
        return dao.saveAndFlush(entity);
    }

    @Override
    public void deleteById(int id) {
        dao.deleteById(id);
    }

    @Override
    public void update(int id, Operator entity) {
        dao.save(entity);
    }
}
