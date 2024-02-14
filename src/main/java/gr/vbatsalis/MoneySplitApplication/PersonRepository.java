package gr.vbatsalis.MoneySplitApplication;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CrudRepository<Person,Integer> {
    Person findPersonById(Integer id);

}
