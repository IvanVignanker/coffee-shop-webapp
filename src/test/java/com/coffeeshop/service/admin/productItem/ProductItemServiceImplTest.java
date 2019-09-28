package com.coffeeshop.service.admin.productItem;

import com.coffeeshop.SpringTestConfiguration;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Stream;

@RunWith(SpringRunner.class)
@Import(SpringTestConfiguration.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class ProductItemServiceImplTest {

    @LocalServerPort
    int randomServerPort;

    @Autowired
    private RestTemplate restTemplate;

    public static Map<HttpStatus, Integer> counterByStatus;

//    todo part should be replaces with spring test infra and converted to a proper integration test

    @Test
    public void findAndMarkAsSoldUseCase1() {
        counterByStatus = new ConcurrentHashMap<>();
        counterByStatus.put(HttpStatus.OK, 0);
        counterByStatus.put(HttpStatus.PRECONDITION_FAILED, 0);
        sendRequestToServer("http://localhost:"+randomServerPort+"/api/admin/product/findAndMark/1/50");
        for (Map.Entry<HttpStatus, Integer> map: counterByStatus.entrySet()) {
            System.out.println(map.getKey()+": "+map.getValue());
        }
        Assert.assertEquals(2, counterByStatus.get(HttpStatus.OK).intValue());
        Assert.assertEquals(8, counterByStatus.get(HttpStatus.PRECONDITION_FAILED).intValue());
    }

    @Test
    public void findAndMarkAsSoldUseCase2() {
        counterByStatus = new ConcurrentHashMap<>();
        counterByStatus.put(HttpStatus.OK, 0);
        counterByStatus.put(HttpStatus.PRECONDITION_FAILED, 0);
        sendRequestToServer( "http://localhost:"+randomServerPort+"/api/admin/product/findAndMark/2/20");
        for (Map.Entry<HttpStatus, Integer> map: counterByStatus.entrySet()) {
            System.out.println(map.getKey()+": "+map.getValue());
        }
        Assert.assertEquals(4, counterByStatus.get(HttpStatus.OK).intValue());
        Assert.assertEquals(6, counterByStatus.get(HttpStatus.PRECONDITION_FAILED).intValue());
    }

    @Test
    public void findAndMarkAsSoldUseCase3() {
        counterByStatus = new ConcurrentHashMap<>();
        counterByStatus.put(HttpStatus.OK, 0);
        counterByStatus.put(HttpStatus.PRECONDITION_FAILED, 0);
        sendRequestToServer("http://localhost:"+randomServerPort+"/api/admin/product/findAndMark/3/2/4/20");
        for (Map.Entry<HttpStatus, Integer> map: counterByStatus.entrySet()) {
            System.out.println(map.getKey()+": "+map.getValue());
        }
        Assert.assertEquals(2, counterByStatus.get(HttpStatus.OK).intValue());
        Assert.assertEquals(8, counterByStatus.get(HttpStatus.PRECONDITION_FAILED).intValue());
    }

    @SuppressWarnings("ConstantConditions")
    public void sendRequestToServer(String url) {
        Stream.iterate(1, n -> n + 1).limit(10).parallel().forEach(x -> {
            try {
                ResponseEntity<Object> exc = restTemplate.exchange(url, HttpMethod.GET, HttpEntity.EMPTY, Object.class);
                counterByStatus.compute(exc.getStatusCode(), ((httpStatus, integer) -> integer+1));
            } catch (HttpClientErrorException exc) {
                counterByStatus.compute(HttpStatus.valueOf(exc.getRawStatusCode()), ((httpStatus, integer) -> integer+1));
            }
        });
    }
}
