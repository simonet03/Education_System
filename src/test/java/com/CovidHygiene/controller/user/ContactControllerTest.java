package com.CovidHygiene.controller.user;

import com.CovidHygiene.entity.Contact;
import com.CovidHygiene.factory.ContactFactory;
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

import static org.junit.Assert.*;



@FixMethodOrder(MethodSorters.NAME_ASCENDING)

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)

public class ContactControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    //made the port 8090 because something else is using 8080
    private  String url = "http://localhost:8090/educationsystem/contact/";


    private static String USER = "admin";
    private static String PASSWORD = "123";

    private static Contact contact = ContactFactory.createContact(27735843267L, 0, "email@gmail.com");


    @Test
    public void a_create() {
        String createUrl = url + "create";

        ResponseEntity<Contact> response = restTemplate
                .withBasicAuth(USER, PASSWORD)
                .postForEntity(createUrl, contact, Contact.class);

        assertNotNull(response);
        assertNotNull(response.getBody());
        assertEquals(HttpStatus.valueOf(200), response.getStatusCode());

        System.out.println(response.getBody());
        System.out.println("Status code: " + response.getStatusCode());
    }



    @Test
    //@Ignore
    public void b_read() {
        String readUrl = url + "read/" + contact.getCellPhone();

        ResponseEntity<Contact> response = restTemplate
                .withBasicAuth(USER, PASSWORD)
                .getForEntity(readUrl, Contact.class);

        assertEquals(contact.getCellPhone(), response.getBody().getCellPhone());
        assertEquals(HttpStatus.valueOf(200), response.getStatusCode());

        System.out.println(response.getBody());
        System.out.println("Status code: " + response.getStatusCode());
    }



    @Test
    //@Ignore
    public void d_update() {
        String updateUrl = url + "update";

        Contact contUpdated = ContactFactory.createContact(27735843267L, 0, "Mally@gmail.com");

        ResponseEntity<Contact> response = restTemplate
                .withBasicAuth(USER, PASSWORD)
                .postForEntity(updateUrl, contUpdated, Contact.class);

        assertNotNull(response);
        assertNotNull(response.getBody());
        assertEquals(HttpStatus.valueOf(200), response.getStatusCode());

        System.out.println(response.getBody().toString());
        System.out.println("Status code: " + response.getStatusCode());
    }



    @Test
    //@Ignore
    public void e_delete() {
        String deleteUrl = url + "delete/" + contact.getCellPhone();

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
}