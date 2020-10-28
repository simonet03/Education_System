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
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class AdminControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    private static String url = "http://localhost:8080/admin";

   private static Admin admin = new Admin.Builder().setAdminNum("A001").setFirstName("Daphney").setLastName("Kgosiejang").setAddress("Cape Town").build();
   private static Admin admin2 = new Admin.Builder().setAdminNum("B006").setFirstName("Thabisa").setLastName("Setlhare").setAddress("Bellville").build();

    @Test
    public void a_create() {
        String createUrl = url + "/create";
        ResponseEntity<Admin> postResponse = restTemplate.postForEntity(createUrl,admin,Admin.class);
        ResponseEntity<Admin> postResponse2 = restTemplate.postForEntity(createUrl,admin2,Admin.class);

        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        System.out.println("Created Admin:\n" + postResponse.getBody() + postResponse.getBody() + postResponse2.getBody());

    }

    @Test
    public void b_read() {
        String readUrl = url + "read/" + admin.getAdminNum();
        ResponseEntity<Admin> response = restTemplate.getForEntity(readUrl,Admin.class);

        assertEquals(admin.getAdminNum(),response.getBody().getAdminNum());
        System.out.println(response.getBody());

    }

    @Test
    public void c_update() {
        String updateUrl = url + "update";
        Admin admUpdated = AdminFactory.buildAdmin("A002","Rethabile","Sibe","More");
        ResponseEntity<Admin> response = restTemplate.postForEntity(updateUrl, admUpdated, Admin.class);

        assertNotNull(response);
        assertNotNull(response.getBody());
        System.out.println(response.getBody());
    }

    @Test
    public void e_getAll() {
        String getUrl = url + "get/all";

        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null,headers);

        ResponseEntity<String> response = restTemplate.exchange(getUrl, HttpMethod.GET, entity, String.class);

        assertNotNull(response);
        assertNotNull(response.getBody());
    }

    @Test
    public void d_delete() {
        String deleteUrl = url +"delete/" +  admin.getAdminNum();
        restTemplate.delete(deleteUrl);

        System.out.println(deleteUrl);

    }
}