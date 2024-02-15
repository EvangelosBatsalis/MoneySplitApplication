package gr.vbatsalis.MoneySplitApplication.repos;

import gr.vbatsalis.MoneySplitApplication.entity.Payment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends CrudRepository<Payment, Integer> {



}
