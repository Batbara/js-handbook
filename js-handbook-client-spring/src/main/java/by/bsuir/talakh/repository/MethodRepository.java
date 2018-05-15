package by.bsuir.talakh.repository;

import by.bsuir.talakh.entity.Method;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
public class MethodRepository implements EntityRepository<Method> {
    private final static String basicUri = "http://localhost:8080/js-handbook-spring-server-1.0/method";
    @Override
    public List<Method> takeAll() {
        RestTemplate restTemplate = new RestTemplate();
        String uri = basicUri + "/all";
        ResponseEntity<List<Method>> response = restTemplate.exchange(
                uri,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Method>>() {
                });
        return response.getBody();
    }

    @Override
    public Optional<Method> findById(int id) {
        RestTemplate restTemplate = new RestTemplate();

        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        String uri = basicUri + "/" + Integer.toString(id);

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<?> entity = new HttpEntity<>(headers);
        ResponseEntity<Method> response = restTemplate.exchange(
                uri,
                HttpMethod.GET,
                entity,
                Method.class);
        return Optional.of(response.getBody());
    }

    @Override
    public Optional<Method> findByName(String name) {
        RestTemplate restTemplate = new RestTemplate();

        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        String uri = basicUri + "/name/" + name;
        Method method = restTemplate.getForEntity(uri, Method.class).getBody();
        return Optional.of(method);
    }

    @Override
    public Method save(Method method) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        restTemplate.getMessageConverters().add(new StringHttpMessageConverter());

        String uri = basicUri + "/add";
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Method> entity = new HttpEntity<>(method,headers);
        ResponseEntity<Method> response = restTemplate.exchange(
                uri,
                HttpMethod.POST,
                entity,
                Method.class);
        return response.getBody();
    }

    @Override
    public void deleteById(int id) {
        RestTemplate restTemplate = new RestTemplate();
        String uri = basicUri + "/" + Integer.toString(id);
        restTemplate.delete(uri);
    }

    @Override
    public void update(int id, Method method) {
        RestTemplate restTemplate = new RestTemplate();
        String uri = basicUri + "/" + Integer.toString(id);
        restTemplate.put(uri, method);
    }
}
