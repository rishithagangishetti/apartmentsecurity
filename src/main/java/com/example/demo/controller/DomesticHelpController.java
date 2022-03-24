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
import com.example.demo.bean.DomesticHelpEntity;
import com.example.demo.service.IDomesticHelpService;

@RestController
public class DomesticHelpController {
	@Autowired
	IDomesticHelpService domesticHelpService;
	@PostMapping("/domesticHelpAdd")
    ResponseEntity<Long> add(@RequestBody DomesticHelpEntity domesticHelp) {
		long domHelpEnt = domesticHelpService.add(domesticHelp);
		return new ResponseEntity<>(domHelpEnt, HttpStatus.OK);
	}
	//find DomesticHelpEntity by name
	@GetMapping("/domesticHelp/byName/{name}")
	ResponseEntity< DomesticHelpEntity> getEmpByName(@PathVariable("name") String name) {
		 DomesticHelpEntity  domHelpEnt  = domesticHelpService.findByName(name);
		return new ResponseEntity<>(domHelpEnt , HttpStatus.OK);
	}
	//delete DomesticHelpEntity
		@DeleteMapping("/domesticHelp/{id}")
		ResponseEntity<DomesticHelpEntity> delete(@RequestBody DomesticHelpEntity domesticHelpEntity) {
		domesticHelpService.delete(domesticHelpEntity);
		return new ResponseEntity<>(HttpStatus.OK); 
		}
			
		//update DomesticHelpEntity
		@PutMapping("/domesticHelp")
		ResponseEntity<DomesticHelpEntity> update(@RequestBody DomesticHelpEntity domesticHelpEntity) {
		domesticHelpService.update(domesticHelpEntity);
		return new ResponseEntity<>( HttpStatus.OK); 
		}
		//find DomesticHelpEntity by Id
		@GetMapping("/domesticHelp/{id}")
		DomesticHelpEntity findByPk(@PathVariable("id") int id) {
			return domesticHelpService.findByPk(id);
			
		}
		
}
