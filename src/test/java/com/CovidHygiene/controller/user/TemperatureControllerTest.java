package com.CovidHygiene.controller.user;

import com.CovidHygiene.entity.Temperature;
import com.CovidHygiene.factory.TemperatureFactory;

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

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TemperatureControllerTest {

    //config security details
    private static String secure_user = "Thing";
    private static String secure_password = "that";

    private static final Temperature temp = TemperatureFactory.buildTemperature(36.00);
    private static final Temperature temp1 = TemperatureFactory.buildTemperature(37.00);
    private static final Temperature temp2 = TemperatureFactory.buildTemperature(38.00);

    @Autowired
    private TestRestTemplate restTemplate;
    private static final String baseURL ="Http://localhost:8090/temperature";

    @Test
    public void a_create() {
        String url = baseURL + "/create";
        ResponseEntity<Temperature> postResponse = restTemplate
                .withBasicAuth(secure_user, secure_password).postForEntity(url,temp,Temperature.class);
        ResponseEntity<Temperature> postResponse1 = restTemplate
                .withBasicAuth(secure_user, secure_password).postForEntity(url,temp1,Temperature.class);
        ResponseEntity<Temperature> postResponse2 = restTemplate
                .withBasicAuth(secure_user, secure_password).postForEntity(url,temp2,Temperature.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        assertNotNull(String.valueOf(HttpStatus.OK), postResponse.getStatusCode());

        System.out.println("Created Temperatures:\n" + postResponse.getBody() + postResponse1.getBody() + postResponse2.getBody());
    }

    @Test
    public void b_read() {
        String url = baseURL + "/read/temperature" + temp.getEnteringTemp();//pass the value/path variable in the param
        ResponseEntity<Temperature> response = restTemplate.withBasicAuth(secure_user, secure_password)
                .getForEntity(url,Temperature.class);
        assertNotNull(String.valueOf(temp.getEnteringTemp()),response.getBody().getEnteringTemp());

        System.out.println("Read: \n" + response.getBody());

    }

    @Test
    public void c_update() {
        String url = baseURL + "/update";
        Temperature updateNew = new Temperature.Builder().copy(temp).setEnteringTemp(37.00).build();
        ResponseEntity<Temperature> response = restTemplate.withBasicAuth(secure_user, secure_password)
                .postForEntity(url,updateNew,Temperature.class);

        assertNotNull(response);
        assertNotNull(response.getBody());

        System.out.println("Update: \n" + response.getBody());
    }

    @Test
    public void d_getAll() {
        String url = baseURL + "/getAll/temperature";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.withBasicAuth(secure_user, secure_password)
                .exchange(url, HttpMethod.GET,entity,String.class);
        assertNotNull(response);
        assertNotNull(response.getBody());

        System.out.println("Get All Temperatures: \n" + response.getBody());
    }

   /** @Test
    public void e_getAboveAvg() {
        String url = baseURL + "/getAboveAvg";
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

        System.out.println("Get All Temperatures Above Average: \n" + response.getBody());
    }**/

    @Test
    public void e_delete() {
        String url = baseURL + "/delete/temperature";
        restTemplate.withBasicAuth(secure_user, secure_password)
                .delete(url);

        System.out.println("deleted: " +url);

        d_getAll();
    }
}