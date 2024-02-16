package gr.vbatsalis.MoneySplitApplication.repos;

import gr.vbatsalis.MoneySplitApplication.entity.Payment;
import gr.vbatsalis.MoneySplitApplication.entity.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PaymentRepository extends CrudRepository<Payment, Integer> {

    Optional<Person> findByPerson_idAndId(int person_id, int id);

}
