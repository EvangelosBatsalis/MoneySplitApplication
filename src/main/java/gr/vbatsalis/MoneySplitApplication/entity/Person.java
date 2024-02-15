package gr.vbatsalis.MoneySplitApplication.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "full_name")
    private String name;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_person")
    private List<Payment> paymentList = new ArrayList<>();

    public Person(String name, Payment paymentList) {
        this.name = name;
        this.paymentList.add(paymentList);
    }


    //public List<Payment> getPaymentList() {
    //    return paymentList;
    //}

    public void setPaymentList(Payment paymentList) {
        this.paymentList.add(paymentList);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", paymentList=" + paymentList +
                '}';
    }
}
