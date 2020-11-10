package com.CovidHygiene.controller.user;

import com.CovidHygiene.entity.Lecturer;
import com.CovidHygiene.factory.LecturerFactory;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.servlet.support.JstlUtils;

import static org.junit.Assert.*;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class LecturerControllerTest {

        @Autowired
        private TestRestTemplate restTemplate;
        private String url = "http://localhost:8090/lecturer/";

        private static String USER = "admin";
        private static String PASSWORD = "123";



        private static Lecturer lecturer = LecturerFactory.buildLecturer("1234567", "Jack", "Chris", "Western Cape");
        private static Lecturer lecturer1 = LecturerFactory.buildLecturer("1234568", "John", "McLain", "New York");

        Lecturer updatedLect = new Lecturer.Builder().copy(lecturer).setFirstName("Jack").build();

    @Test
    public void a_create() {
        String createUrl = url + "/created";

        ResponseEntity<Lecturer> response = restTemplate
                .withBasicAuth(USER, PASSWORD)
                .postForEntity(createUrl, lecturer, Lecturer.class);
        ResponseEntity<Lecturer> response1 = restTemplate
                .withBasicAuth(USER, PASSWORD)
                .postForEntity(createUrl, lecturer1, Lecturer.class);
        assertNotNull(response);
        assertNotNull(response.getBody());

        assertNotNull(response1);
        assertNotNull(response1.getBody());
        assertEquals(HttpStatus.valueOf(200), response.getStatusCode());

        lecturer = response.getBody();
        lecturer1 = response1.getBody();

        System.out.println(response.getBody());
        System.out.println(response1.getBody());
        System.out.println("Status code: " + response.getStatusCode());

    }

    @Test
    //@Ignore
    public void b_read() {
        String readUrl = url + "/read/" + lecturer.getLecturerNum();
        ResponseEntity<Lecturer> response = restTemplate
                .withBasicAuth(USER, PASSWORD)
                .getForEntity(readUrl, Lecturer.class);
        assertEquals(lecturer.getLecturerNum(), response.getBody().getLecturerNum());
        assertEquals(HttpStatus.valueOf(200), response.getStatusCode());

        System.out.println(response.getBody());
        System.out.println("Status code: " + response.getStatusCode());
    }

    @Test
    public void d_delete() {
        String deleteUrl = url + "/delete/" + lecturer.getLecturerNum();
        System.out.println(deleteUrl);
        restTemplate
                .withBasicAuth(USER, PASSWORD)
                .delete(deleteUrl);
        c_getAll();

    }
    @Test
    //@Ignore
    public void e_update(){
        String updateUrl = url + "update";
        ResponseEntity<Lecturer> response = restTemplate
                .withBasicAuth(USER, PASSWORD)
                .postForEntity(updateUrl, updatedLect, Lecturer.class);
        String responseNum = response.getBody().getLecturerNum();

        assertNotNull(response);
        assertNotNull(response.getBody());

        assertEquals(lecturer.getLecturerNum(), responseNum);
        assertEquals(HttpStatus.valueOf(200), response.getStatusCode());

        System.out.println(response.getBody());
        System.out.println("Status code: " + response.getStatusCode());
    }

    @Test
    public void c_getAll() {
        String getUrl = url + "/get/all";

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