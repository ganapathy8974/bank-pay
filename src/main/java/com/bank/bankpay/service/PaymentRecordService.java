package com.bank.bankpay.service;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.bank.bankpay.dto.CompanyDTO;
import com.bank.bankpay.dto.PaymentRecordDTO;
import com.bank.bankpay.model.Company;
import com.bank.bankpay.model.PaymentRecord;
import com.bank.bankpay.repository.CompanyRepository;
import com.bank.bankpay.repository.PaymentRecordRepository;


@Service
public class PaymentRecordService {

    @Autowired
    PaymentRecordRepository paymentRecordRepository;
    
    @Autowired
    CompanyRepository companyRepository;
    
    public List<PaymentRecord> getPaymentRecord(Long id) {
    	return paymentRecordRepository.findByCompanyId(id);
    }

    public Boolean savePaymetRecord(CompanyDTO companyDTO) {

    	try {
    	Company company = new Company();
    	List<PaymentRecord> paymentRecords = new ArrayList<>();
    	company.setPaymentRecordList(paymentRecords);
    	BeanUtils.copyProperties(companyDTO, company);
    	Company companyResponse = companyRepository.save(company);
    	for(PaymentRecordDTO e : companyDTO.getPaymentRecordList()) {
    		PaymentRecord paymentRecord = new PaymentRecord();  
    		paymentRecord.setCompany(companyResponse);
    		BeanUtils.copyProperties(e, paymentRecord);   
    		company.getPaymentRecordList().add(paymentRecord);
    	}
    	paymentRecordRepository.saveAll(paymentRecords);
    	
    	return true;
    	}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
    	
    }


    public CompanyDTO convertXMLToObject(MultipartFile xmlFile) {
        try {
            JAXBContext context = JAXBContext.newInstance(CompanyDTO.class);
            Unmarshaller un = context.createUnmarshaller();           
            CompanyDTO company = (CompanyDTO) un.unmarshal(xmlFile.getInputStream());
      
            return company;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        
    }

}
