package com.coffeeshop.service.admin.productItem;

import com.coffeeshop.SpringTestConfiguration;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestClientResponseException;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Stream;

@RunWith(SpringRunner.class)
@Import(SpringTestConfiguration.class)
@TestPropertySource(properties = "test.properties")
public class ProductItemServiceImplTest {

    @Autowired(required = false)
    private SpringTestConfiguration testConfiguration;

    public static Map<HttpStatus, Integer> counterByStatus = new ConcurrentHashMap<>();

    @BeforeEach
    void before() {
        counterByStatus.put(HttpStatus.OK, 0);
        counterByStatus.put(HttpStatus.PRECONDITION_FAILED, 0);
        counterByStatus.put(HttpStatus.INTERNAL_SERVER_ERROR, 0);
    }

//    todo part should be replaces with spring test infra and converted to a proper integration test

    @Test
    public void findAndMarkAsSoldUseCase1() {
        Map<HttpStatus, Integer> counterByStatusTemp = iterateMethod(50, 1L);
        Assert.assertEquals(2, counterByStatusTemp.get(HttpStatus.OK).intValue());
        Assert.assertEquals(8, counterByStatusTemp.get(HttpStatus.PRECONDITION_FAILED).intValue());
    }

    @Test(expected = NullPointerException.class)
    public void findAndMarkAsSoldUseCase2() {
        Map<HttpStatus, Integer> counterByStatusTemp = iterateMethod(20, 2L);
        Assert.assertEquals(4, counterByStatusTemp.get(HttpStatus.OK).intValue());
        Assert.assertEquals(6, counterByStatusTemp.get(HttpStatus.PRECONDITION_FAILED).intValue());
    }

    @Test(expected = NullPointerException.class)
    public void findAndMarkAsSoldUseCase3() {
        Map<HttpStatus, Integer> counterByStatusTemp = iterateMethod2(2, 3L, 20,  4L);
        Assert.assertEquals(2, counterByStatusTemp.get(HttpStatus.OK).intValue());
        Assert.assertEquals(8, counterByStatusTemp.get(HttpStatus.PRECONDITION_FAILED).intValue());
    }

    public Map<HttpStatus, Integer> iterateMethod2(Integer amount, Long productId, Integer amount2, Long productId2) {
        String url = "http://localhost:8080/api/admin/product/findAndMark/"+productId+"/"
                +amount+"/"+productId2+"/"+amount2;
        Stream.iterate(1, n -> n + 1).limit(10).parallel().forEach(x -> {
            try {
                ResponseEntity<Object> exchange =
                        testConfiguration.restTemplate().exchange(url, HttpMethod.GET, HttpEntity.EMPTY, Object.class);
                counterByStatus.compute(exchange.getStatusCode(), (status, i) -> i + 1);
            } catch (RestClientResponseException e) {
                counterByStatus.compute(HttpStatus.valueOf(e.getRawStatusCode()), (status, i) -> i + 1);
            }
        });
        return counterByStatus;
    }

    public Map<HttpStatus, Integer> iterateMethod(Integer amount, Long productId) {
        String url = "http://localhost:8080/api/admin/product/findAndMark/"+productId+"/"+amount;
        Stream.iterate(1, n -> n + 1).limit(10).parallel().forEach(x -> {
            try {
                ResponseEntity<Object> exchange =
                        testConfiguration.restTemplate().exchange(url, HttpMethod.GET, HttpEntity.EMPTY, Object.class);
                counterByStatus.compute(exchange.getStatusCode(), (status, i) -> i + 1);
            } catch (RestClientResponseException e) {
                counterByStatus.compute(HttpStatus.valueOf(e.getRawStatusCode()), (status, i) -> i + 1);
            }
        });
        return counterByStatus;
    }
}
