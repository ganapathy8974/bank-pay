package com.bank.bankpay.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "payment_record")
public class PaymentRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private Long toAcctNumber;

    private String IFSCCode;

    private String purpose;

    private String paymentMode;

    private Boolean active = true;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "company_id")
    private Company company;

    public PaymentRecord() {
    }

    public PaymentRecord(Long id, Long toAcctNumber, String IFSCCode, String purpose, String paymentMode, Boolean active, Company company) {
        Id = id;
        this.toAcctNumber = toAcctNumber;
        this.IFSCCode = IFSCCode;
        this.purpose = purpose;
        this.paymentMode = paymentMode;
        this.active = active;
        this.company = company;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Long getToAcctNumber() {
        return toAcctNumber;
    }

    public void setToAcctNumber(Long toAcctNumber) {
        this.toAcctNumber = toAcctNumber;
    }

    public String getIFSCCode() {
        return IFSCCode;
    }

    public void setIFSCCode(String IFSCCode) {
        this.IFSCCode = IFSCCode;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "PaymentRecord{" +
                "Id=" + Id +
                ", toAcctNumber=" + toAcctNumber +
                ", IFSCCode='" + IFSCCode + '\'' +
                ", purpose='" + purpose + '\'' +
                ", paymentMode='" + paymentMode + '\'' +
                ", active=" + active +
                ", company=" + company +
                '}';
    }
}
