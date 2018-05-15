package by.bsuir.talakh.repository;

import by.bsuir.talakh.entity.JsObject;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Repository
public class JsObjectRepository implements EntityRepository<JsObject> {
    private final static String basicUri = "http://localhost:8080/js-handbook-spring-server-1.0/object";

    public JsObjectRepository() {
    }

    @Override
    public List<JsObject> takeAll() {
        RestTemplate restTemplate = new RestTemplate();
        String uri = basicUri + "/all";
        ResponseEntity<List<JsObject>> jsObjectResponse = restTemplate.exchange(
                uri,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<JsObject>>() {
                });
        return jsObjectResponse.getBody();
    }

    @Override
    public Optional<JsObject> findById(int id) {
        RestTemplate restTemplate = new RestTemplate();

        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        String uri = basicUri + "/" + Integer.toString(id);

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<?> entity = new HttpEntity<>(headers);
        ResponseEntity<JsObject> response = restTemplate.exchange(
                uri,
                HttpMethod.GET,
                entity,
                JsObject.class);
        return Optional.of(response.getBody());
    }

    @Override
    public Optional<JsObject> findByName(String name) {
        RestTemplate restTemplate = new RestTemplate();

        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        String uri = basicUri + "/name/" + name;
        JsObject jsObject = restTemplate.getForEntity(uri, JsObject.class).getBody();
        return Optional.of(jsObject);
    }

    @Override
    public JsObject save(JsObject jsObject) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
        String uri = basicUri + "/add";
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<JsObject> entity = new HttpEntity<>(jsObject, headers);
        ResponseEntity<JsObject> response = restTemplate.exchange(
                uri,
                HttpMethod.POST,
                entity,
                JsObject.class);
        return response.getBody();
    }

    @Override
    public void deleteById(int id) {
        RestTemplate restTemplate = new RestTemplate();
        String uri = basicUri + "/" + Integer.toString(id);
        restTemplate.delete(uri);
    }

    @Override
    public void update(int id, JsObject object) {
        RestTemplate restTemplate = new RestTemplate();
        String uri = basicUri + "/" + Integer.toString(id);
        restTemplate.put(uri, object);
    }
}
