package com.example.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.bean.DeliveryEntity;
@Repository
public interface IDeliveryRepository extends JpaRepository<DeliveryEntity, Long>{
	
	 public DeliveryEntity findByownerName(String name);
	
}
