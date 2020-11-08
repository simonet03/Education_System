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
    //made the port 8090 because something else is using 8080
    private  String url = "http://localhost:8090/educationsystem/student/";


    private static String USER = "admin";
    private static String PASSWORD = "123";


    //private static Student student  = new Student.Builder().setFirstName("Damni").setLastName("Mally").setAddress("Cape Town").build();
    //private static Student student2  = new Student.Builder().setFirstName("Jason").setLastName("Mally").setAddress("Nowhere").build();

    private static  Student student = StudentFactory.createStudent("Dam455", "Mally", "Cape Town");
    private static  Student student2 = StudentFactory.createStudent("Jason", "Mally", "Nowhere");

    Student updatedStud = new Student.Builder().copy(student).setFirstName("Damien").build();



    @Test
    public void a_create() {
        String createUrl = url + "create";

        ResponseEntity<Student> response = restTemplate
                .withBasicAuth(USER, PASSWORD)
                .postForEntity(createUrl, student, Student.class);

        ResponseEntity<Student> response2 = restTemplate
                .withBasicAuth(USER, PASSWORD)
                .postForEntity(createUrl, student2, Student.class);

        assertNotNull(response);
        assertNotNull(response.getBody());

        assertNotNull(response2);
        assertNotNull(response2.getBody());

        assertEquals(HttpStatus.valueOf(200), response.getStatusCode());

        student = response.getBody();
        student2 = response2.getBody();

        System.out.println(response.getBody());
        System.out.println(response2.getBody());
        System.out.println("Status code: " + response.getStatusCode());
    }



    @Test
    //@Ignore
    public void b_read() {

        String readUrl = url + "read/" + student.getStudentNum();

        ResponseEntity<Student> response = restTemplate
                .withBasicAuth(USER, PASSWORD)
                .getForEntity(readUrl, Student.class);

        assertEquals(student.getStudentNum(), response.getBody().getStudentNum());
        assertEquals(HttpStatus.valueOf(200), response.getStatusCode());

        System.out.println(response.getBody());
        System.out.println("Status code: " + response.getStatusCode());
    }



    @Test
    //@Ignore
    public void d_update() {

        String updateUrl = url + "update";

        ResponseEntity<Student> response = restTemplate
                .withBasicAuth(USER, PASSWORD)
                .postForEntity(updateUrl, updatedStud, Student.class);

        String responseNum = response.getBody().getStudentNum();

        assertNotNull(response);
        assertNotNull(response.getBody());

        assertEquals(student.getStudentNum(),responseNum);
        assertEquals(HttpStatus.valueOf(200), response.getStatusCode());

        System.out.println(response.getBody());
        System.out.println("Status code: " + response.getStatusCode());
    }



    @Test
    //@Ignore
    public void h_delete() {

        String deleteUrl = url + "delete/" + student.getStudentNum();

        System.out.println(deleteUrl);

        restTemplate
                .withBasicAuth(USER, PASSWORD)
                .delete(deleteUrl);


        c_getAll();
    }



    @Test
    //@Ignore
    public void c_getAll() {
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

    @Test
    //@Ignore
    public void f_getFirstNames() {
        String nameUrl = url + "get/firstnames/" + "Damien";

        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);

        ResponseEntity<String> response = restTemplate
                .withBasicAuth(USER, PASSWORD)
                .exchange(nameUrl, HttpMethod.GET, entity, String.class);

        assertNotNull(response);
        assertNotNull(response.getBody());
        assertEquals(HttpStatus.valueOf(200), response.getStatusCode());

        System.out.println("Get ALL first names that are equal to Damien: ");
        System.out.println(response.getBody());
        System.out.println("Status code: " + response.getStatusCode());
    }

    @Test
    //@Ignore
    public void g_getLastNames() {
        String lastNameUrl = url + "get/lastnames/" + "Mally";

        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);

        ResponseEntity<String> response = restTemplate
                .withBasicAuth(USER, PASSWORD)
                .exchange(lastNameUrl, HttpMethod.GET, entity, String.class);

        assertNotNull(response);
        assertNotNull(response.getBody());
        assertEquals(HttpStatus.valueOf(200), response.getStatusCode());

        System.out.println("Get ALL last names that are equal to Mally: ");
        System.out.println(response.getBody());
        System.out.println("Status code: " + response.getStatusCode());
    }

    @Test
    //@Ignore
    public void e_getNamesThatStart() {

        String nameLetterUrl = url + "get/nameswithletter/" + "d";

        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);

        ResponseEntity<String> response = restTemplate
                .withBasicAuth(USER, PASSWORD)
                .exchange(nameLetterUrl, HttpMethod.GET, entity, String.class);

        assertNotNull(response);
        assertNotNull(response.getBody());
        assertEquals(HttpStatus.valueOf(200), response.getStatusCode());

        System.out.println("Get first names that start with 'd': ");
        System.out.println(response.getBody());
        System.out.println("Status code: " + response.getStatusCode());
    }
}