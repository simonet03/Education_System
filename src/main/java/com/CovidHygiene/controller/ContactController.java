package com.CovidHygiene.controller;


import com.CovidHygiene.entity.Contact;
import com.CovidHygiene.factory.ContactFactory;
import com.CovidHygiene.service.user.impl.ContactServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/contact")
public class ContactController {

    @Autowired
    private ContactServiceImpl service;


    @PostMapping("/create")
    public Contact create (@RequestBody Contact contact){

        Contact contact1 =  ContactFactory.createContact(contact.getCellPhone(), contact.getHomePhone(), contact.getEmail());
        return service.create(contact1);
    }



    @GetMapping("/read/{cellNum}")
    public Contact read (@PathVariable Long cellNum){
        return service.read(cellNum);
    }



    @PostMapping("/update")
    public Contact update(@RequestBody Contact contact){
        return service.update(contact);
    }



    @DeleteMapping("/delete/{cellNum}")
    public String delete(@PathVariable Long cellNum){
        boolean result = service.delete(cellNum);
        if(result == true){
            return "success";
        }
        else{
            return "something went wrong";
        }
    }



    @GetMapping("/get/all")
    public Set<Contact> getAll(){
        return service.getAll();
    }
}
