package gr.vbatsalis.MoneySplitApplication.service;

import gr.vbatsalis.MoneySplitApplication.entity.Payment;
import gr.vbatsalis.MoneySplitApplication.repos.PaymentRepository;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    final
    PaymentRepository paymentRepository;

    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public void saveOrUpdate(Payment payment){
        System.out.println(payment.getDescription());
        System.out.println(payment.getValue());
        paymentRepository.save(payment);
//        return paymentRepository.save(payment);
    }

}
