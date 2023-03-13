package com.bank.bankpay.dto.common;

public class ResponseDTO {

    private Boolean status;

    private String Message;

    public ResponseDTO() {
    }

    public ResponseDTO(Boolean status, String message) {
        this.status = status;
        Message = message;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    @Override
    public String toString() {
        return "ResponseDTO{" +
                "status=" + status +
                ", Message='" + Message + '\'' +
                '}';
    }
}
