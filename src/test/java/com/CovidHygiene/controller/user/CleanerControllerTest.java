package com.CovidHygiene.controller.user;

import com.CovidHygiene.entity.Cleaner;
import com.CovidHygiene.factory.CleanerFactory;
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

public class CleanerControllerTest {
        @Autowired
        private TestRestTemplate restTemplate;

        private static String baseURL = "http://localhost:8090/cleaner";

        private static Cleaner cleaner = CleanerFactory.buildCleaner(21,"Nazeerah","Carr","2 Newfields Road");
        private static Cleaner cleaner1 = CleanerFactory.buildCleaner(20,"Alice","Cooper","105 Headway Street");

        private static Cleaner newCleaner = new Cleaner.Builder().copy(cleaner).build();

        @Test
        public void a_create() {
            String url = baseURL + "/create";
            ResponseEntity<Cleaner> postResponse = restTemplate.postForEntity(url,cleaner,Cleaner.class);
            ResponseEntity<Cleaner> postResponse1 = restTemplate.postForEntity(url,cleaner1,Cleaner.class);
            assertNotNull(postResponse);
            assertNotNull(postResponse.getBody());

            System.out.println("Created Cleaners:\n" + postResponse.getBody() + postResponse1.getBody());

        }

        @Test
        public void b_read(){
            String url = baseURL + "/read/" + cleaner.getCleanerNum();
            ResponseEntity<Cleaner> response = restTemplate.getForEntity(url, Cleaner.class);

            assertEquals(cleaner.getCleanerNum(), response.getBody().getCleanerNum());
            System.out.println("Read: " + response.getBody());

        }

        @Test
        public void c_update(){
            String url = baseURL + "/update";

            ResponseEntity<Cleaner> response = restTemplate.postForEntity(url,newCleaner,Cleaner.class);
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
        public void e_CleanerNum(){
            String url = baseURL + "/getCleanerNum";
            ResponseEntity<String> response = restTemplate.getForEntity(url,String.class);
            System.out.println("Get all cleaners numbers: \n" + response.getBody());

        }

        @Test
        public void f_FirstName(){
            String url = baseURL + "/getAllCleanersFirstNames";
            ResponseEntity<String> response = restTemplate.getForEntity(url,String.class);
            System.out.println("Get all firstnames: \n" + response.getBody());

        }

        @Test
        public void g_LastName(){
            String url = baseURL + "/getAllCleanersLastNames";
            ResponseEntity<String> response = restTemplate.getForEntity(url,String.class);
            System.out.println("Get All Booked Classrooms: \n" + response.getBody());

        }

        @Test
        public void h_Address(){
            String url = baseURL + "/getAllCleanersAddresses";
            ResponseEntity<String> response = restTemplate.getForEntity(url,String.class);
            System.out.println("Get all addresses: \n" + response.getBody());

        }

}
