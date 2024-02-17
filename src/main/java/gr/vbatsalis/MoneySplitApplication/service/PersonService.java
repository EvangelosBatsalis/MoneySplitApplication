package gr.vbatsalis.MoneySplitApplication.service;

import gr.vbatsalis.MoneySplitApplication.entity.Person;
import gr.vbatsalis.MoneySplitApplication.repos.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person saveOrUpdate(Person person){
        return personRepository.save(person);
    }

    public Boolean isExist(String name){
        if(personRepository.findPersonByFullName(name) != null){return true;
        }else return false;
    }

    public Person findByUserName(String name){
        return personRepository.findPersonByFullName(name);
    }

    public Person findByUserNameAndId(String name, int id){
        return personRepository.findPersonByFullNameAndAndId(name, id);
    }


}
