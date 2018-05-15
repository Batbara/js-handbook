package by.bsuir.talakh.repository;

import by.bsuir.talakh.entity.Operator;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Repository
public class OperatorRepository implements EntityRepository<Operator> {

    private final static String basicUri = "http://localhost:8080/js-handbook-spring-server-1.0/operator";

    @Override
    public List<Operator> takeAll() {
        RestTemplate restTemplate = new RestTemplate();
        String uri = basicUri + "/all";
        ResponseEntity<List<Operator>> response = restTemplate.exchange(
                uri,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Operator>>() {
                });
        return response.getBody();
    }

    @Override
    public Optional<Operator> findById(int id) {
        RestTemplate restTemplate = new RestTemplate();

        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        String uri = basicUri + "/" + Integer.toString(id);

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<?> entity = new HttpEntity<>(headers);
        ResponseEntity<Operator> response = restTemplate.exchange(
                uri,
                HttpMethod.GET,
                entity,
                Operator.class);
        return Optional.of(response.getBody());
    }

    @Override
    public Optional<Operator> findByName(String name) {
        RestTemplate restTemplate = new RestTemplate();

        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        String uri = basicUri + "/name/" + name;
        Operator operator = restTemplate.getForEntity(uri, Operator.class).getBody();
        return Optional.of(operator);
    }

    @Override
    public Operator save(Operator operator) {
        RestTemplate restTemplate = new RestTemplate();
        String uri = basicUri + "/add";
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Operator> entity = new HttpEntity<>(operator, headers);
        ResponseEntity<Operator> response = restTemplate.exchange(
                uri,
                HttpMethod.POST,
                entity,
                Operator.class);
        return response.getBody();
    }

    @Override
    public void deleteById(int id) {
        RestTemplate restTemplate = new RestTemplate();
        String uri = basicUri + "/" + Integer.toString(id);
        restTemplate.delete(uri);
    }

    @Override
    public void update(int id, Operator operator) {
        RestTemplate restTemplate = new RestTemplate();
        String uri = basicUri + "/" + Integer.toString(id);
        restTemplate.put(uri, operator);
    }
}
