package com.bank.bankpay.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="Record")
public class PaymentRecordDTO {

    private Long Id;

    @XmlElement(name = "ToAcctNumber")
    private Long toAcctNumber;

    @XmlElement(name = "IFSCCODE")
    private String IFSCCode;
    
    @XmlElement(name = "Purpose")
    private String purpose;
    
    @XmlElement(name = "PaymentMode")
    private String paymentMode;

    private Boolean active;



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



    @Override
    public String toString() {
        return "PaymentRecord{" +
                "Id=" + Id +
                ", toAcctNumber=" + toAcctNumber +
                ", IFSCCode='" + IFSCCode + '\'' +
                ", purpose='" + purpose + '\'' +
                ", paymentMode='" + paymentMode + '\'' +
                ", active=" + active +               
                '}';
    }
}
