package com.CovidHygiene.controller.user;

import com.CovidHygiene.entity.Cleaner;
import com.CovidHygiene.entity.Stock;
import com.CovidHygiene.factory.CleanerFactory;
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

public class CleanerControllerTest {
        @Autowired
        private TestRestTemplate restTemplate;
    private  String url = "http://localhost:8090/educationsystem/cleaner/";


    private static String USER = "admin";
    private static String PASSWORD = "123";

        private static Cleaner cleaner = CleanerFactory.buildCleaner(21,"Nazeerah","Carr","2 Newfields Road");
        private static Cleaner cleaner1 = CleanerFactory.buildCleaner(20,"Alice","Cooper","105 Headway Street");

        @Test
        public void a_create() {
            String createUrl = url + "create";

            ResponseEntity<Cleaner> response = restTemplate
                    .withBasicAuth(USER, PASSWORD)
                    .postForEntity(createUrl, cleaner, Cleaner.class);

            assertNotNull(response);
            assertNotNull(response.getBody());
            assertEquals(HttpStatus.valueOf(200), response.getStatusCode());

            System.out.println(response.getBody());
            System.out.println("Status code: " + response.getStatusCode());

        }

        @Test
        public void b_read(){
            String readUrl = url + "read/" + cleaner.getCleanerNum();

            ResponseEntity<Stock> response = restTemplate
                    .withBasicAuth(USER, PASSWORD)
                    .getForEntity(readUrl, Stock.class);

            assertEquals(cleaner.getCleanerNum(), response.getBody().getNumOfStock());
            assertEquals(HttpStatus.valueOf(200), response.getStatusCode());

            System.out.println(response.getBody());
            System.out.println("Status code: " + response.getStatusCode());
        }

        @Test
        public void c_update(){
            String updateUrl = url + "update";

            Cleaner cleanerUpdated = CleanerFactory.buildCleaner(21,"Nazeerah","Carr","2 Newfields Road");

            ResponseEntity<Cleaner> response = restTemplate
                    .withBasicAuth(USER, PASSWORD)
                    .postForEntity(updateUrl, cleanerUpdated, Cleaner.class);

            assertNotNull(response);
            assertNotNull(response.getBody());
            assertEquals(HttpStatus.valueOf(200), response.getStatusCode());

            System.out.println(response.getBody().toString());
            System.out.println("Status code: " + response.getStatusCode());
        }
        @Test
        public void e_delete() {
            String deleteUrl = url + "delete/" + cleaner.getCleanerNum();

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
