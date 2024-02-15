package gr.vbatsalis.MoneySplitApplication.repos;

import gr.vbatsalis.MoneySplitApplication.entity.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CrudRepository<Person,Integer> {
    Person findPersonById(Integer id);

}
