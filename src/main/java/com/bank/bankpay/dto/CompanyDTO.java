package com.bank.bankpay.dto;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;



@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="CompanyName")
public class CompanyDTO {

    private Long id;

    @XmlAttribute(name="Name")
    private String name;

    private Boolean active;

    @XmlElement(name = "Record", type = PaymentRecordDTO.class)
    private List<PaymentRecordDTO> paymentRecordList = new ArrayList<PaymentRecordDTO>();


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

    public List<PaymentRecordDTO> getPaymentRecordList() {
        return paymentRecordList;
    }

    public void setPaymentRecordList(List<PaymentRecordDTO> paymentRecordList) {
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
