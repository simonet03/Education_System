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
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
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


        private static Lecturer lecturer = LecturerFactory.buildLecturer("1234", "name", "lastname", "meh");

        private static Lecturer updateLecturer = new Lecturer.Builder().copy(lecturer).setFirstName("Jackson").build();

    @Test
    public void a_create() {
        String createUrl = url + "create";

        ResponseEntity<Lecturer> response = restTemplate.postForEntity(createUrl, lecturer, Lecturer.class);

        assertNotNull(response);

        lecturer = response.getBody();

        System.out.println(response.getBody());
    }

    @Test
    public void b_read() {
        String readUrl = url + "read/" + lecturer.getLecturerNum();
        ResponseEntity<Lecturer> response = restTemplate.getForEntity(readUrl, Lecturer.class);
        assertEquals(lecturer.getLecturerNum(), response.getBody().getLecturerNum());
        System.out.println(response.getBody());
    }

    @Test
    public void d_delete() {
        String deleteUrl = url + "delete/" + lecturer.getLecturerNum();
        System.out.println(deleteUrl);

    }

    @Test
    public void c_getAll() {
        String getUrl = url + "get/all";

        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);

        ResponseEntity<String> response = restTemplate.exchange(getUrl, HttpMethod.GET, entity, String.class);

        assertNotNull(response);
        assertNotNull(response.getBody());

        System.out.println(response.getBody());
    }
}