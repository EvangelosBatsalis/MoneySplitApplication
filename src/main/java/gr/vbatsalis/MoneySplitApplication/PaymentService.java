package gr.vbatsalis.MoneySplitApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    final
    PaymentRepository paymentRepository;

    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public void saveOrUpdate(Payment payment){
        Payment savedPayment = paymentRepository.save(payment);
    }

}
