package com.hrithik.Goveg.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hrithik.Goveg.model.ItemBean;

public interface ItemRepository extends JpaRepository<ItemBean, Integer> {

}
