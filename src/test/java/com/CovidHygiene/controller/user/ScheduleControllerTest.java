package com.CovidHygiene.controller.user;

import com.CovidHygiene.entity.Schedule;
import com.CovidHygiene.factory.ScheduleFactory;
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

import java.time.LocalTime;

import static org.junit.Assert.*;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ScheduleControllerTest {

    private static Schedule schedule= ScheduleFactory.buildSchedule(30, LocalTime.of(10,30),LocalTime.of(16,30),true,false);

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8090/schedule/";

    private static String USER = "admin";
    private static String PASSWORD = "123";

    private static Schedule schedule1 = ScheduleFactory.buildSchedule(30, LocalTime.of(10,30),LocalTime.of(16,30),true,false);

    @Test
    public void a_create() {
        String url = baseURL + "create";
        System.out.println("URL: " + url);
        System.out.println("Post data: " + schedule);
        ResponseEntity<Schedule> postResponse = restTemplate.withBasicAuth(USER,PASSWORD).postForEntity(url, schedule, Schedule.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        assertEquals(HttpStatus.valueOf(200) , postResponse.getStatusCode());
        schedule = postResponse.getBody();
        System.out.println("Saved data: " + schedule);
        assertEquals(schedule.getClassroomNum(), postResponse.getBody().getClassroomNum());
        System.out.println(postResponse.getBody());
        System.out.println("Status code:" + postResponse.getStatusCode());

    }

    @Test
    public void d_list() {
        String url = baseURL + "all";
        System.out.println("URL: " + url);
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.withBasicAuth(USER, PASSWORD).exchange(url, HttpMethod.GET, entity, String.class);

        assertNotNull(response);
        assertNotNull(response.getBody());
        assertEquals(HttpStatus.valueOf(200) , response.getStatusCode());


        System.out.println(response);
        System.out.println(response.getBody());
        System.out.println("Status code :" + response.getStatusCode());
    }

    @Test
    public void b_read() {
        String url = baseURL + "read/" + schedule.getClassroomNum();
        System.out.println("URL: " + url);
        ResponseEntity<Schedule> response = restTemplate.withBasicAuth(USER, PASSWORD).getForEntity(url, Schedule.class);
        assertEquals(schedule.getClassroomNum(), response.getBody().getClassroomNum());
        assertEquals(HttpStatus.valueOf(200), response.getStatusCode());

        System.out.println(response.getBody());
        System.out.println("Status code: " + response.getStatusCode());
    }

    @Test
    public void c_update() {
        Schedule update = new Schedule.ScheduleBuilder().copy(schedule).
                setBookedForTeach(false).build();

        String url = baseURL + "update";
        Schedule scheduleUpdated = ScheduleFactory.buildSchedule(30, LocalTime.of(10,30),LocalTime.of(16,30),true,false);
        System.out.println("URL: " + url);
        System.out.println("Post data: " + update);
        ResponseEntity<Schedule> response = restTemplate.withBasicAuth(USER, PASSWORD).postForEntity(url, update, Schedule.class);
        assertNotEquals(schedule, response.getBody());
        assertNotNull(response);
        assertNotNull(response.getBody());
        assertEquals(HttpStatus.valueOf(200), response.getStatusCode());

        System.out.println(response.getBody().toString());
        System.out.println("Status code:" + response.getStatusCode());
    }

    @Test
    public void e_delete() {
        String url = baseURL + "delete/" + schedule.getClassroomNum();
        System.out.println("URL: " + url);
        restTemplate.withBasicAuth(USER, PASSWORD).delete(url);

        d_list();
    }

}