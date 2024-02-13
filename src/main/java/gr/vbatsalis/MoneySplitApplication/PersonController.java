package gr.vbatsalis.MoneySplitApplication;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api")
class PersonController {

    Person person = new Person();

    @PostMapping("post")
    public ResponseEntity<?> postHandler(@RequestBody Payment payment){
        person.setName("vag");
        person.setPaymentList(payment);
        System.out.println(person);
        return ResponseEntity.ok(HttpStatus.OK);
    }
    @GetMapping("sum")
    public int getSumHendler(){
        return person.getSum();
    }
    @GetMapping("splited")
    public int getSplitedHendler(){
        return person.getSplited();
    }

    @GetMapping("get")
    public ResponseEntity<Person> getPerson(){
        return ResponseEntity.ok(person);
    }

}
