/*
    Author:Ethan Petersen(217140807)
    This class contains classroom controller test case
 */
package com.CovidHygiene.controller.user;

import com.CovidHygiene.entity.Classroom;
import com.CovidHygiene.factory.ClassroomFactory;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
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

public class ClassroomControllerTest {

    private static String USER = "Teacher";
    private static String PASSWORD = "Password9";

    @Autowired
    private TestRestTemplate restTemplate;
    private static String baseURL = "Http://localhost:8090/educationsystem/classroom";

    private static Classroom classroom = ClassroomFactory.createClassroom(10,true,25,false);
    private static Classroom classroom1 = ClassroomFactory.createClassroom(11,true,30,true);
    private static Classroom classroom2 = ClassroomFactory.createClassroom(12,false,20,false);

    @Test
    public void a_create() {
        String url = baseURL + "/create";
        ResponseEntity<Classroom> postResponse = restTemplate.withBasicAuth("admin","123").postForEntity(url,classroom,Classroom.class);
        ResponseEntity<Classroom> postResponse1 = restTemplate.withBasicAuth("admin","123").postForEntity(url,classroom1,Classroom.class);
        ResponseEntity<Classroom> postResponse2 = restTemplate.withBasicAuth("admin","123").postForEntity(url,classroom2,Classroom.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());

        System.out.println("Created Classrooms:\n" + postResponse.getBody() + postResponse1.getBody() + postResponse2.getBody());

    }

    @Test
    public void b_read(){
        String url = baseURL + "/read/" + classroom.getClassroomNum();//Must pass the value/path variable in the parameter{}
        ResponseEntity<Classroom> response = restTemplate.withBasicAuth(USER,PASSWORD).getForEntity(url,Classroom.class);
        assertEquals(classroom.getClassroomNum(),response.getBody().getClassroomNum());
        System.out.println("Read: " + response.getBody());

    }

    @Test
    public void c_update(){
        String url = baseURL + "/update";
        Classroom updatedNew = new Classroom.Builder().copy(classroom).setBooked(false).setSanitizingStation(true).build();
        ResponseEntity<Classroom> response = restTemplate.withBasicAuth("admin","123").postForEntity(url,updatedNew,Classroom.class);
        System.out.println("Updated: " + response.getBody());

    }

    @Test
    public void d_getAll() {
        String url = baseURL + "/getAll";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null,headers);
        ResponseEntity<String> response = restTemplate.withBasicAuth(USER,PASSWORD).exchange(url, HttpMethod.GET,entity,String.class);
        assertNotNull(response);
        assertNotNull(response.getBody());

        System.out.println("Get All: \n" + response.getBody());
    }

    @Test
    public void e_allSanitizedClassrooms(){
        String url = baseURL + "/getAllSanitizedClassrooms";
        ResponseEntity<String> response = restTemplate.withBasicAuth(USER,PASSWORD).getForEntity(url,String.class);
        System.out.println("Get All Sanitized Classrooms: \n" + response.getBody());

    }

    @Test
    public void f_allNotSanitizedClassrooms(){
        String url = baseURL + "/getAllNotSanitizedClassrooms";
        ResponseEntity<String> response = restTemplate.withBasicAuth(USER,PASSWORD).getForEntity(url,String.class);
        System.out.println("Get All Not Sanitized Classrooms: \n" + response.getBody());

    }

    @Test
    public void g_allBookedClassrooms(){
        String url = baseURL + "/getAllBookedClassrooms";
        ResponseEntity<String> response = restTemplate.withBasicAuth(USER,PASSWORD).getForEntity(url,String.class);
        System.out.println("Get All Booked Classrooms: \n" + response.getBody());

    }

    @Test
    public void h_allNotBookedClassrooms(){
        String url = baseURL + "/getAllNotBookedClassrooms";
        ResponseEntity<String> response = restTemplate.withBasicAuth(USER,PASSWORD).getForEntity(url,String.class);
        System.out.println("Get All Not Booked Classrooms: \n" + response.getBody());

    }



    @Test
    @Ignore
    public void i_delete(){
        String url = baseURL + "/delete/"+ classroom2.getClassroomNum();
        restTemplate.withBasicAuth(USER,PASSWORD).delete(url);
        System.out.println("URL: " + url);
    }
}