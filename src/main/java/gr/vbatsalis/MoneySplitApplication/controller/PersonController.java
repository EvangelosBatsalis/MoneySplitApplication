package gr.vbatsalis.MoneySplitApplication.controller;

import gr.vbatsalis.MoneySplitApplication.entity.Payment;
import gr.vbatsalis.MoneySplitApplication.entity.Person;
import gr.vbatsalis.MoneySplitApplication.service.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api")
class PersonController {

    Person person = new Person();

    final
    PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping("newUserRegistration")
    public ResponseEntity<String> newUserRegistration(@RequestBody Person person){
        if(personService.isExist(person.getFullName())){
            return new ResponseEntity<>("User "+person.getFullName()+" already exists", HttpStatus.BAD_REQUEST);
        }else{
            Person newPersonSaved = personService.saveOrUpdate(person);
        return new ResponseEntity<>("User Registered Successful"+" id: "+newPersonSaved.getId(), HttpStatus.OK);
    }

//    @PostMapping("post")
//    public ResponseEntity<?> postHandler( Payment payment){
//        person.setFullName("vag");
//        person.setPaymentList(payment);
//        System.out.println(person);
//
//        return ResponseEntity.ok(HttpStatus.OK);
    }
//    @GetMapping("sum")
//    public int getSumHendler(){
//        return person.getSum();
//    }
//    @GetMapping("splited")
//    public int getSplitedHendler(){
//        return person.getSplited();
//    }

    @GetMapping("get")
    public ResponseEntity<Person> getPerson(){
        return ResponseEntity.ok(person);
    }

}
