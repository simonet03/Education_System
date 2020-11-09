package com.CovidHygiene.controller.user;

import com.CovidHygiene.entity.Admin;
import com.CovidHygiene.factory.AdminFactory;
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
public class AdminControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    private static String url = "http://localhost:8090/admin";

    private static String USER = "admin";
    private static String PASSWORD = "123";

    //private static Admin admin = new Admin.Builder().setAdminNum("A001").setFirstName("Daphney").setLastName("Kgosiejang").setAddress("Cape Town").build();
   // private static Admin admin2 = new Admin.Builder().setAdminNum("B006").setFirstName("Thabisa").setLastName("Setlhare").setAddress("Bellville").build();

    private static Admin admin = AdminFactory.buildAdmin("A001","Daphney","Kgosiejang","Cape Town");
    private static Admin admin2 = AdminFactory.buildAdmin("B006","Thabisa","Setlhare","Bellville");

    private static Admin admUpdated = AdminFactory.buildAdmin("A001","Rethabile","Sibe","More");

    @Test
    public void a_create() {
        String createUrl = url + "/create";
        ResponseEntity<Admin> postResponse = restTemplate
                .withBasicAuth(USER, PASSWORD)
                .postForEntity(createUrl,admin,Admin.class);

        ResponseEntity<Admin> postResponse2 = restTemplate
                .withBasicAuth(USER, PASSWORD)
                .postForEntity(createUrl,admin2,Admin.class);

        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());

        assertNotNull(postResponse2);
        assertNotNull(postResponse2.getBody());

        assertEquals(HttpStatus.valueOf(200), postResponse.getStatusCode());

        admin = postResponse.getBody();
        admin2 = postResponse2.getBody();

        System.out.println(postResponse.getBody());
        System.out.println(postResponse2.getBody());
        System.out.println("Status code:" + postResponse.getStatusCode());

    }

    @Test
    public void b_read() {
        String readUrl = url + "/read/" + admin.getAdminNum();
        ResponseEntity<Admin> response = restTemplate
                .withBasicAuth(USER, PASSWORD)
                .getForEntity(readUrl,Admin.class);

        assertEquals(admin.getAdminNum(),response.getBody().getAdminNum());
        assertEquals(HttpStatus.valueOf(200), response.getStatusCode());

        System.out.println(response.getBody());
        System.out.println("Status code:" + response.getStatusCode());

    }

    @Test
    public void e_update() {
        String updateUrl = url + "/update";

        ResponseEntity<Admin> response = restTemplate
                .withBasicAuth(USER, PASSWORD)
                .postForEntity(updateUrl, admUpdated, Admin.class);

        assertNotNull(response);
        assertNotNull(response.getBody());

        assertEquals(HttpStatus.valueOf(200), response.getStatusCode());

        System.out.println(response.getBody());
        System.out.println("Status code:" + response.getStatusCode());
    }

    @Test
    public void c_getAll() {
        String getUrl = url + "getAll";

        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null,headers);

        ResponseEntity<String> response = restTemplate
                .withBasicAuth(USER, PASSWORD)
                .exchange(getUrl, HttpMethod.GET, entity, String.class);

        assertNotNull(response);
        assertNotNull(response.getBody());
        assertEquals(HttpStatus.valueOf(200), response.getStatusCode());

        System.out.println(response.getBody());
        System.out.println("Status code: " + response.getStatusCode());
    }

    @Test
    public void d_delete() {
        String deleteUrl = url +"/delete/" +  admin.getAdminNum();

        System.out.println(deleteUrl);

        restTemplate
                .withBasicAuth(USER, PASSWORD)
                .delete(deleteUrl);

        c_getAll();

    }
}