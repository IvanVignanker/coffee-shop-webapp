package com.coffeeshop.service.admin.productItem;

import com.coffeeshop.configuration.RestTemplateConfiguration;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestClientResponseException;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Stream;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        properties = "spring.profiles.active=development")
public class ProductItemServiceImplTest {

    @Autowired
    private RestTemplateConfiguration templateConfiguration;

    public static Map<HttpStatus, Integer> counterByStatus = new ConcurrentHashMap<>();
    static {
        counterByStatus.put(HttpStatus.OK, 0);
        counterByStatus.put(HttpStatus.PRECONDITION_FAILED, 0);
    }

    @Test(expected=NullPointerException.class)
    public void findAndMarkAsSoldUseCase1() {
        Map<HttpStatus, Integer> counterByStatusTemp = iterateMethod(10, 50, 3L);
        Assert.assertEquals(2, counterByStatusTemp.get(HttpStatus.OK).intValue());
        Assert.assertEquals(8, counterByStatusTemp.get(HttpStatus.PRECONDITION_FAILED).intValue());
    }

    @Test(expected=NullPointerException.class)
    public void findAndMarkAsSoldUseCase2() {
        Map<HttpStatus, Integer> counterByStatusTemp = iterateMethod(10, 10, 2L);
        Assert.assertEquals(10, counterByStatusTemp.get(HttpStatus.OK).intValue());
    }

    @Test(expected=NullPointerException.class)
    public void findAndMarkAsSoldUseCase3() {
        Map<HttpStatus, Integer> counterByStatusTemp = iterateMethod(5, 20, 1L);
        Assert.assertEquals(5, counterByStatusTemp.get(HttpStatus.OK).intValue());
    }

    public Map<HttpStatus, Integer> iterateMethod(int iteration, Integer amount, Long productId) {
        String url = "http://localhost:8080/api/admin/product/findAndMark/"+productId+"/"+amount;
        Stream.iterate(1, n -> n + 1).limit(iteration).parallel().forEach(x -> {
            try {
                ResponseEntity<Object> exchange =
                        templateConfiguration.restTemplate().exchange(url, HttpMethod.GET, HttpEntity.EMPTY, Object.class);
                counterByStatus.compute(exchange.getStatusCode(), (status, i) -> i + 1);
            } catch (RestClientResponseException e) {
                counterByStatus.compute(HttpStatus.valueOf(e.getRawStatusCode()), (status, i) -> i + 1);
            }
        });
        return counterByStatus;
    }
}
