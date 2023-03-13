package com.bank.bankpay.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.bank.bankpay.dto.common.ResponseDTO;
import com.bank.bankpay.model.PaymentRecord;
import com.bank.bankpay.service.PaymentRecordService;

@RestController
public class PaymentRecordController {

    @Autowired
    PaymentRecordService paymentRecordService;

    @PostMapping("/v1/payment/process")
    public ResponseEntity<ResponseDTO> processPayment(@RequestParam(name = "file") MultipartFile file){
    	paymentRecordService.savePaymetRecord(paymentRecordService.convertXMLToObject(file));
        return new ResponseEntity<ResponseDTO>(
                new ResponseDTO(true,"Paymet Record saved Successfully"),
                HttpStatus.OK);
    }

    @GetMapping("/v1/payment/payment-by-comapany/{id}")
    public ResponseEntity<List<PaymentRecord>> getAllPaymentRecords(@PathVariable(name="id") Long id){
    	List<PaymentRecord> response = paymentRecordService.getPaymentRecord(id);
    	return new ResponseEntity<List<PaymentRecord>>(
                response,
                HttpStatus.OK);
    }
}
