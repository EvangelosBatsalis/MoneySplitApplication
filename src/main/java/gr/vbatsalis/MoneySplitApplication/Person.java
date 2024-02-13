package gr.vbatsalis.MoneySplitApplication;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private List<Payment> paymentList = new ArrayList<>();
    int sum = 0;

    public Person(String name, Payment paymentList) {
        this.name = name;
        this.paymentList.add(paymentList);
    }

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Payment> getPaymentList() {
        return paymentList;
    }

    public void setPaymentList(Payment paymentList) {
        this.paymentList.add(paymentList);
    }

    public int getSum(){

        for(var iteration: paymentList){
            sum += iteration.getValue();
        }
        return sum;
    }
    public int getSplited(){
        return sum/2;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", paymentList=" + paymentList +
                '}';
    }
}
