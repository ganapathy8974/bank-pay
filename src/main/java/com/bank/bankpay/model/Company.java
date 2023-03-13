package com.bank.bankpay.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="company")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Boolean active = true;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "company")
    private List<PaymentRecord> paymentRecordList;

    public Company() {

    }

    public Company(Long id, String name, Boolean active, List<PaymentRecord> paymentRecordList) {
        this.id = id;
        this.name = name;
        this.active = active;
        this.paymentRecordList = paymentRecordList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public List<PaymentRecord> getPaymentRecordList() {
        return paymentRecordList;
    }

    public void setPaymentRecordList(List<PaymentRecord> paymentRecordList) {
        this.paymentRecordList = paymentRecordList;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", active=" + active +
                ", paymentRecordList=" + paymentRecordList +
                '}';
    }
}
