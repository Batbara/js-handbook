package by.bsuir.talakh.dao;

import by.bsuir.talakh.entity.JsObject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface JsObjectDao extends JpaRepository<JsObject, Integer> {
    @Query("SELECT jsObj FROM JsObject jsObj WHERE LOWER(jsObj.name) = LOWER(:name)")
    JsObject findByName(@Param("name") String name);

}
