package com.CovidHygiene.controller.user;

import com.CovidHygiene.entity.LecturerSchedule;
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
public class LecturerScheduleControllerTest {

    private static LecturerSchedule schedule = new LecturerSchedule.Builder().setClassroomNum(32).setLecturerNum("24432").build();
    @Autowired
    private TestRestTemplate restTemplate = null;
    private String baseURL = "http://localhost:8080/lecturer_schedule/";

    @Test
    public void a_create() {
        String url = baseURL + "create";
        System.out.println("URL: " + url);
        System.out.println("Post data: " + schedule);
        ResponseEntity<LecturerSchedule> postResponse = restTemplate.postForEntity(url, schedule, LecturerSchedule.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        schedule = postResponse.getBody();
        System.out.println("Saved data: " + schedule);
        assertEquals(schedule.getClassroomNum(), postResponse.getBody().getClassroomNum());
    }

    @Test
    public void d_list() {
        String url = baseURL + "all";
        System.out.println("URL: " + url);
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

        System.out.println(response);
        System.out.println(response.getBody());
    }

    @Test
    public void b_read() {
        String url = baseURL + "read/" + schedule.getClassroomNum();
        System.out.println("URL: " + url);
        ResponseEntity<LecturerSchedule> response = restTemplate.getForEntity(url, LecturerSchedule.class);
        assertEquals(schedule.getClassroomNum(), response.getBody().getClassroomNum());
    }

    @Test
    public void c_update() {
        LecturerSchedule update = new LecturerSchedule.Builder().copy(schedule).
                setClassroomNum(43).build();

        String url = baseURL + "update";
        System.out.println("URL: " + url);
        System.out.println("Post data: " + update);
        ResponseEntity<LecturerSchedule> response = restTemplate.postForEntity(url, update, LecturerSchedule.class);
        assertNotEquals(schedule, response.getBody());
    }

    @Test
    public void e_delete() {
        String url = baseURL + "delete/" + schedule.getClassroomNum();
        System.out.println("URL: " + url);
        restTemplate.delete(url);
    }

}
