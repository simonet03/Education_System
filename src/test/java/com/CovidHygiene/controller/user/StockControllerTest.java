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
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)

public class StockControllerTest {
    @Autowired
            private TestRestTemplate restTemplate;
            private  String url = "http://localhost:8090/educationsystem/stock/";


            private static String USER = "admin";
            private static String PASSWORD = "123";

            private static Stock stock = StockFactory.buildStock(50, "Face Masks");
            private static Stock stock1 = StockFactory.buildStock(60,"Hand Sanitizers");

            @Test
            public void a_create() {
                String createUrl = url + "create";

                        ResponseEntity<Stock> response = restTemplate
                                .withBasicAuth(USER, PASSWORD)
                                .postForEntity(createUrl, stock, Stock.class);

                        assertNotNull(response);
                        assertNotNull(response.getBody());
                        assertEquals(HttpStatus.valueOf(200), response.getStatusCode());

                        System.out.println(response.getBody());
                        System.out.println("Status code: " + response.getStatusCode());
            }

            @Test
            public void b_read(){
               String readUrl = url + "read/" + stock.getNumOfStock();

                        ResponseEntity<Stock> response = restTemplate
                                .withBasicAuth(USER, PASSWORD)
                                .getForEntity(readUrl, Stock.class);

                        assertEquals(stock.getNumOfStock(), response.getBody().getNumOfStock());
                        assertEquals(HttpStatus.valueOf(200), response.getStatusCode());

                        System.out.println(response.getBody());
                        System.out.println("Status code: " + response.getStatusCode());

            }

            @Test
            public void c_update(){
                String updateUrl = url + "update";

                        Stock stockUpdated = StockFactory.buildStock(50, "Face Masks");

                        ResponseEntity<Stock> response = restTemplate
                                .withBasicAuth(USER, PASSWORD)
                                .postForEntity(updateUrl, stockUpdated, Stock.class);

                        assertNotNull(response);
                        assertNotNull(response.getBody());
                        assertEquals(HttpStatus.valueOf(200), response.getStatusCode());

                        System.out.println(response.getBody().toString());
                        System.out.println("Status code: " + response.getStatusCode());
            }

            @Test
            public void e_delete() {
                String deleteUrl = url + "delete/" + stock.getNumOfStock();

                System.out.println(deleteUrl);

                restTemplate
                        .withBasicAuth(USER, PASSWORD)
                        .delete(deleteUrl);
                            d_getAll();
        }

            @Test
            public void d_getAll() {
                String getUrl = url + "get/all";

                HttpHeaders headers = new HttpHeaders();
                HttpEntity<String> entity = new HttpEntity<>(null, headers);

                ResponseEntity<String> response = restTemplate
                        .withBasicAuth(USER, PASSWORD)
                        .exchange(getUrl, HttpMethod.GET, entity, String.class);

                assertNotNull(response);
                assertNotNull(response.getBody());
                assertEquals(HttpStatus.valueOf(200), response.getStatusCode());

                System.out.println(response.getBody());
                System.out.println("Status code: " + response.getStatusCode());
            }

}
