package gr.vbatsalis.MoneySplitApplication.controller;

import gr.vbatsalis.MoneySplitApplication.entity.Payment;
import gr.vbatsalis.MoneySplitApplication.entity.Person;
import gr.vbatsalis.MoneySplitApplication.service.PaymentService;
import gr.vbatsalis.MoneySplitApplication.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api")
public class PaymentController {

    @Autowired
    private final PersonService personService;
    @Autowired
    private final PaymentService paymentService;

    public PaymentController(PersonService personService, PaymentService paymentService) {
        this.personService = personService;
        this.paymentService = paymentService;
    }

    @PostMapping("payment/new/{username}")
    public ResponseEntity<String> paymentHandler(@RequestBody Payment payment, @PathVariable String username){
        if(personService.isExist(username)){
            System.out.println("found");
            Person person = personService.findByUserName(username);
            System.out.println(person.getId());
            payment.setPerson_id(person.getId());
            paymentService.saveOrUpdate(payment);
        }else{
            return new ResponseEntity<>("User does not exist. Please register first", HttpStatus.BAD_GATEWAY);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
