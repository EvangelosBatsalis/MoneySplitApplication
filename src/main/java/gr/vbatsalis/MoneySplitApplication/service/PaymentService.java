package gr.vbatsalis.MoneySplitApplication.service;

import gr.vbatsalis.MoneySplitApplication.entity.Payment;
import gr.vbatsalis.MoneySplitApplication.entity.Person;
import gr.vbatsalis.MoneySplitApplication.repos.PaymentRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
    }

    public Optional<Payment> findById(int id){
        return paymentRepository.findById(id);
    }

    public Boolean isPaymentExists(int id){
        return paymentRepository.existsById(id);
    }

    public Boolean isExist(int id){
        return paymentRepository.existsById(id);
    }



}
