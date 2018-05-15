package by.bsuir.talakh.dao;

import by.bsuir.talakh.entity.Operator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OperatorDao extends JpaRepository<Operator, Integer> {
    @Query("SELECT op FROM Operator op WHERE LOWER(op.name) = LOWER(:name)")
    Operator findByName(@Param("name") String name);

}
