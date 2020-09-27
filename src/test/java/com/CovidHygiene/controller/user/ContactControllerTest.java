package com.CovidHygiene.controller.user;

import com.CovidHygiene.entity.Contact;
import com.CovidHygiene.factory.ContactFactory;
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



@FixMethodOrder(MethodSorters.NAME_ASCENDING)

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)

public class ContactControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    private  String url = "http://localhost:8080/contact/";


    private static Contact contact = ContactFactory.createContact(27735843267L, 0, "email@gmail.com");


    @Test
    public void a_create() {
        String createUrl = url + "create";

        ResponseEntity<Contact> response = restTemplate.postForEntity(createUrl, contact, Contact.class);

        assertNotNull(response);
        assertNotNull(response.getBody());

        System.out.println(response.getBody());
    }



    @Test
    public void b_read() {
        String readUrl = url + "read/" + contact.getCellPhone();

        ResponseEntity<Contact> response = restTemplate.getForEntity(readUrl, Contact.class);

        System.out.println(response.getBody());
        assertEquals(contact.getCellPhone(), response.getBody().getCellPhone());
    }



    @Test
    public void d_update() {
        String updateUrl = url + "update";

        Contact contUpdated = ContactFactory.createContact(27735843267L, 0, "Mally@gmail.com");

        ResponseEntity<Contact> response = restTemplate.postForEntity(updateUrl, contUpdated, Contact.class);

        assertNotNull(response);
        assertNotNull(response.getBody());

        System.out.println(response.getBody().toString());
    }



    @Test
    public void e_delete() {
        String deleteUrl = url + "delete/" + contact.getCellPhone();

        System.out.println(deleteUrl);
        restTemplate.delete(deleteUrl);

        c_getAll();
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