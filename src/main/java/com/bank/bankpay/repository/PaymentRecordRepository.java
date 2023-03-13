package com.bank.bankpay.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bank.bankpay.model.PaymentRecord;

@Repository
public interface PaymentRecordRepository extends JpaRepository<PaymentRecord,Long> {
	
	@Query(value = "SELECT * FROM payment_record r where r.company_id = ?1",nativeQuery = true)
	public List<PaymentRecord> findByCompanyId(Long id);
}
