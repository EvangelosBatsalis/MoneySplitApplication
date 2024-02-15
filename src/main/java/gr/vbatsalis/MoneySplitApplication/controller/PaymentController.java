package gr.vbatsalis.MoneySplitApplication.controller;

import gr.vbatsalis.MoneySplitApplication.entity.Person;
import gr.vbatsalis.MoneySplitApplication.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class PaymentController {

    @Autowired
    private final PersonService personService;

    public PaymentController(PersonService personService) {
        this.personService = personService;
    }



}
