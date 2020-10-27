package com.CovidHygiene.controller.user;

import com.CovidHygiene.entity.Student;
import com.CovidHygiene.factory.StudentFactory;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import static org.junit.Assert.*;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class StudentControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    private  String url = "http://localhost:8080/student/";


    private static Student student  = new Student.Builder().setFirstName("Damni").setLastName("Mally").setAddress("Cape Town").build();
    private static Student student2  = new Student.Builder().setFirstName("Jason").setLastName("Mally").setAddress("Nowhere").build();

    Student updatedStud = new Student.Builder().copy(student).setFirstName("Damien").build();



    @Test
    public void a_create() {
        String createUrl = url + "create";

        ResponseEntity<Student> response = restTemplate.postForEntity(createUrl, student, Student.class);
        ResponseEntity<Student> response2 = restTemplate.postForEntity(createUrl, student2, Student.class);

        assertNotNull(response);
        assertNotNull(response.getBody());

        student = response.getBody();
        student2 = response2.getBody();

        System.out.println(response.getBody());
        System.out.println(response2.getBody());
    }



    @Test
    @Ignore
    public void b_read() {

        String readUrl = url + "read/" + student.getStudentNum();

        ResponseEntity<Student> response = restTemplate.getForEntity(readUrl, Student.class);

        assertEquals(student.getStudentNum(), response.getBody().getStudentNum());

        System.out.println(response.getBody());
    }



    @Test
    @Ignore
    public void d_update() {

        String updateUrl = url + "update";

        ResponseEntity<Student> response = restTemplate.postForEntity(updateUrl, updatedStud, Student.class);

        String responseNum = response.getBody().getStudentNum();

        assertNotNull(response);
        assertNotNull(response.getBody());

        assertEquals(student.getStudentNum(),responseNum);

        System.out.println(response.getBody());
    }



    @Test
    @Ignore
    public void h_delete() {

        String deleteUrl = url + "delete/" + student.getStudentNum();

        System.out.println(deleteUrl);
        restTemplate.delete(deleteUrl);

        c_getAll();
    }



    @Test
    @Ignore
    public void c_getAll() {
        String getUrl = url + "get/all";

        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);

        ResponseEntity<String> response = restTemplate.exchange(getUrl, HttpMethod.GET, entity, String.class);

        assertNotNull(response);
        assertNotNull(response.getBody());

        System.out.println(response.getBody());


    }

    @Test
    @Ignore
    public void f_getFirstNames() {
        String nameUrl = url + "get/firstnames/" + "Damien";

        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);

        ResponseEntity<String> response = restTemplate.exchange(nameUrl, HttpMethod.GET, entity, String.class);

        assertNotNull(response);
        assertNotNull(response.getBody());

        System.out.println("Get ALL first names that are equal to Damien: ");
        System.out.println(response.getBody());

    }

    @Test
    @Ignore
    public void g_getLastNames() {
        String lastNameUrl = url + "get/lastnames/" + "Mally";

        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);

        ResponseEntity<String> response = restTemplate.exchange(lastNameUrl, HttpMethod.GET, entity, String.class);

        assertNotNull(response);
        assertNotNull(response.getBody());

        System.out.println("Get ALL last names that are equal to Mally: ");
        System.out.println(response.getBody());

    }

    @Test
    @Ignore
    public void e_getNamesThatStart() {

        String nameLetterUrl = url + "get/nameswithletter/" + "d";

        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);

        ResponseEntity<String> response = restTemplate.exchange(nameLetterUrl, HttpMethod.GET, entity, String.class);

        assertNotNull(response);
        assertNotNull(response.getBody());

        System.out.println("Get first names that start with 'd': ");
        System.out.println(response.getBody());
    }
}