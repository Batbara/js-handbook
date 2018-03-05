package by.lab.java.talakh.questionnaire.service;

import by.lab.java.talakh.questionnaire.entity.User;

public interface UserService {
    void register(User user);

    User findUser(String userName);
}
