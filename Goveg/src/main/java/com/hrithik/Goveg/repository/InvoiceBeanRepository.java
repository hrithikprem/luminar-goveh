package com.hrithik.Goveg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hrithik.Goveg.model.InvoiceBean;
@Repository
public interface InvoiceBeanRepository extends JpaRepository<InvoiceBean, Integer> {
	List<InvoiceBean> findByRegId(int regId);

}
