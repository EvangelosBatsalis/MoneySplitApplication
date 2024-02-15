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

    public Payment saveOrUpdate(Payment payment){
        return paymentRepository.save(payment);
    }

}
