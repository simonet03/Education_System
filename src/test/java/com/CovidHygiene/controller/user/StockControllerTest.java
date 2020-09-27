package com.CovidHygiene.controller.user;

import com.CovidHygiene.factory.StockFactory;
import com.CovidHygiene.entity.Stock;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class StockControllerTest {
    @Autowired
            private TestRestTemplate restTemplate;
            private static String baseURL = "Http://localhost:8080/classroom";

            private static Stock stock = StockFactory.buildStock(50, "Face Masks");
            private static Stock stock1 = StockFactory.buildStock(60,"Hand Sanitizers");

            @Test
            public void a_create() {
                String url = baseURL + "/create";
                ResponseEntity<Stock> postResponse = restTemplate.postForEntity(url,stock,Stock.class);
                ResponseEntity<Stock> postResponse1 = restTemplate.postForEntity(url,stock1,Stock.class);
                assertNotNull(postResponse);
                assertNotNull(postResponse.getBody());

                System.out.println("Created Stock:\n" + postResponse.getBody() + postResponse1.getBody());
            }

            @Test
            public void b_read(){
                String url = baseURL + "/read/" + stock.getStockType();
                ResponseEntity<Stock> response = restTemplate.getForEntity(url,Stock.class);
                assertEquals(stock.getStockType(),response.getBody().getStockType());
                System.out.println("Read: " + response.getBody());

            }

            @Test
            public void c_update(){
                String url = baseURL + "/update";
                Stock newStock = new Stock.Builder().copy(stock).build();
                ResponseEntity<Stock> response = restTemplate.postForEntity(url,newStock,Stock.class);
                System.out.println("Updated: " + response.getBody());

            }

            @Test
            public void d_getAll() {
                String url = baseURL + "/getAll";
                HttpHeaders headers = new HttpHeaders();
                HttpEntity<String> entity = new HttpEntity<>(null,headers);
                ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET,entity,String.class);
                assertNotNull(response);
                assertNotNull(response.getBody());

                System.out.println("Get All: \n" + response.getBody());
            }

            @Test
            public void e_StockType(){
                String url = baseURL + "/getStockType";
                ResponseEntity<String> response = restTemplate.getForEntity(url,String.class);
                System.out.println("Get type of stock: \n" + response.getBody());

            }

            @Test
            public void f_StockNum(){
                String url = baseURL + "/getAmountOfStock";
                ResponseEntity<String> response = restTemplate.getForEntity(url,String.class);
                System.out.println("Get amount of stock: \n" + response.getBody());

            }

}
