package by.bsuir.talakh.dao;

import by.bsuir.talakh.entity.Method;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MethodDao extends JpaRepository<Method, Integer> {
    @Query("SELECT m FROM Method m WHERE LOWER(m.name) = LOWER(:name)")
    Method findByName(@Param("name") String name);

    @Query("SELECT m FROM Method m WHERE m.methodObject.id = (:objId)")
    List<Method> takeAllForObject(@Param("objId") int objectId);

    @Modifying
    @Query("update Method m set m.description = :#{#newObj.description} " +
            "where m.id = :#{#newObj.id}")
    void updateDescription(@Param("newObj") Method method);
}
