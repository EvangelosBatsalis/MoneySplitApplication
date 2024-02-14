package gr.vbatsalis.MoneySplitApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    private final PersonRepository personRepository;


    public PersonService(PersonRepository personRepository, PaymentRepository paymentRepository) {
        this.personRepository = personRepository;
    }

    public int saveOrUpdate(Person person){
        Person savedPerson = personRepository.save(person);
        return savedPerson.getId();
    }

}
