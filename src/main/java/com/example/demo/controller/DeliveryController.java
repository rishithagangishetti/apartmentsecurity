package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.DeliveryEntity;
import com.example.demo.service.IDeliveryService;
@RestController
public class DeliveryController {
	@Autowired
	IDeliveryService delServ;
	//add DeliveryEntity
	@PostMapping("/addDeliveryEntity")
    ResponseEntity<Long> add(@RequestBody DeliveryEntity deliveryEntity) {
    	
		long delEnt = delServ.add(deliveryEntity);
		return new ResponseEntity<>(delEnt, HttpStatus.OK);
	}
	//find deliveryEntity by Name
	@GetMapping("/deliveryEntity/byName/{name}")
	ResponseEntity<DeliveryEntity> findByName(@PathVariable("name") String name) {
		DeliveryEntity delEnt = delServ.findByName(name);
		return new ResponseEntity<>(delEnt, HttpStatus.OK);
	}
	//delete deliverEntity
	@DeleteMapping("/deleteDeliveryEntity")
	ResponseEntity<DeliveryEntity> delete(@RequestBody DeliveryEntity deliveryEntity) {
	delServ.delete(deliveryEntity);
	return new ResponseEntity<>(HttpStatus.OK); 
	}
		
	//update deliverEntity
	@PutMapping("/deliveryEntity")
	ResponseEntity<DeliveryEntity> update(@RequestBody DeliveryEntity deliveryEntity) {
	delServ.update(deliveryEntity);
	return new ResponseEntity<>( HttpStatus.OK); 
	}
	//find deliveryEntity by Id
	@GetMapping("/updateDeliveryEntity/{id}")
	DeliveryEntity findByPk(@PathVariable("id") int empId) {
		return delServ.findByPk(empId);
		
	}
}
