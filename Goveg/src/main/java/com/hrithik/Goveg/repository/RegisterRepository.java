package com.hrithik.Goveg.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hrithik.Goveg.model.RegisterBean;

public interface RegisterRepository extends JpaRepository<RegisterBean, Integer> {

	RegisterBean findByRegId(int regId);
}
