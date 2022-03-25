package com.example.demo.controller;

import java.util.List;

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
	@PostMapping("/addDelivery")
    ResponseEntity<Long> add(@RequestBody DeliveryEntity deliveryEntity)  {
		long delEnt = delServ.add(deliveryEntity);
		return new ResponseEntity<>(delEnt, HttpStatus.OK);
	}
	//find deliveryEntity by Name
	@GetMapping("/delivery/byName/{name}")
	ResponseEntity<DeliveryEntity> findByName(@PathVariable("name") String name) {
		DeliveryEntity delEnt = delServ.findByName(name);
		return new ResponseEntity<>(delEnt, HttpStatus.OK);
	}
	//delete deliverEntity
	@DeleteMapping("/deleteDelivery")
	ResponseEntity<DeliveryEntity> delete(@RequestBody DeliveryEntity deliveryEntity) {
	delServ.delete(deliveryEntity);
	return new ResponseEntity<>(HttpStatus.OK); 
	}
		
	//update deliverEntity
	@PutMapping("/updateDelivery")
	ResponseEntity<DeliveryEntity> update(@RequestBody DeliveryEntity deliveryEntity) {
	delServ.update(deliveryEntity);
	return new ResponseEntity<>( HttpStatus.OK); 
	}
	//find deliveryEntity by Id
	@GetMapping("/delivery/{id}")
	DeliveryEntity findByPk(@PathVariable("id") int empId) {
		return delServ.findByPk(empId);
		
	}
	//search deliveryEntity
	@PostMapping("/searchdelivery")
	ResponseEntity<List<DeliveryEntity>> search(@RequestBody DeliveryEntity deliveryEntity) {
	List<DeliveryEntity> delEnt = delServ.search(deliveryEntity);
	return new ResponseEntity<>(delEnt, HttpStatus.OK);
		}
	//search by pageNo and PageSize
	@GetMapping("deliveryByNoAndSize/{pageNo}/{pageSize}")
	ResponseEntity<List<DeliveryEntity>> search(@PathVariable("pageNo") Long pageNo,@PathVariable("pageSize") Integer pageSize) {
		List<DeliveryEntity> delEnt = delServ.search(pageNo,pageSize);
		return new ResponseEntity<>(delEnt, HttpStatus.OK);
}
}