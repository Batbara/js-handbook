package by.lab.java.talakh.questionnaire.repository;

import by.lab.java.talakh.questionnaire.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    @Query(value="SELECT usr FROM user WHERE usr.userName = :name",nativeQuery = true)
    User findByUserName(@Param("name") String userName);
}
