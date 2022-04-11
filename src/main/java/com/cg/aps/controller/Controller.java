package com.cg.aps.controller;

import java.util.List;

import javax.validation.Valid;

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

import com.cg.aps.entity.DeliveryEntity;
import com.cg.aps.entity.DomesticHelpEntity;
import com.cg.aps.service.DeliveryServiceInt;
import com.cg.aps.service.DomesticHelpServiceInt;

@RestController
public class Controller {
	@Autowired
	DeliveryServiceInt deliveryService;
	@Autowired
	DomesticHelpServiceInt domesticHelpService;

	// add DeliveryEntity
	@PostMapping("/addDelivery")
	ResponseEntity<Long> add(@Valid @RequestBody DeliveryEntity deliveryEntity) {
		long delEnt = deliveryService.add(deliveryEntity);
		return new ResponseEntity<>(delEnt, HttpStatus.OK);
	}

	// find deliveryEntity by Name
	@GetMapping("/delivery/byName/{name}")
	ResponseEntity<List<DeliveryEntity>> findByName(@PathVariable("name") String name) {
		List<DeliveryEntity> delEnt = deliveryService.findByName(name);
		return new ResponseEntity<>(delEnt, HttpStatus.OK);
	}

	// delete deliverEntity
	@DeleteMapping("/deleteDelivery")
	ResponseEntity<DeliveryEntity> delete(@RequestBody DeliveryEntity deliveryEntity) {
		deliveryService.delete(deliveryEntity);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	// update deliverEntity
	@PutMapping("/updateDelivery")
	ResponseEntity<DeliveryEntity> update(@Valid @RequestBody DeliveryEntity deliveryEntity) {
		deliveryService.update(deliveryEntity);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	// find deliveryEntity by Id
	@GetMapping("/delivery/{id}")
	ResponseEntity<DeliveryEntity> findByPk(@PathVariable("id") int empId) {
		return new ResponseEntity<>(deliveryService.findByPk(empId), HttpStatus.OK);

	}

	// search deliveryEntity
	@PostMapping("/searchdelivery")
	ResponseEntity<List<DeliveryEntity>> search(@RequestBody DeliveryEntity deliveryEntity) {
		List<DeliveryEntity> delEnt = deliveryService.search(deliveryEntity);
		return new ResponseEntity<>(delEnt, HttpStatus.OK);
	}

	// search by pageNo and PageSize
	@GetMapping("deliveryByNoAndSize/{pageNo}/{pageSize}")
	ResponseEntity<List<DeliveryEntity>> searchDomesticHelp(@PathVariable("pageNo") Long pageNo,
			@PathVariable("pageSize") Integer pageSize) {
		List<DeliveryEntity> delEnt = deliveryService.search(pageNo, pageSize);
		return new ResponseEntity<>(delEnt, HttpStatus.OK);
	}

	// add flat to delivery
	@GetMapping("mapflattodelivery/{deliveryId}/{flatId}")
	ResponseEntity<DeliveryEntity> mapDeliveytoFlat(@PathVariable("deliveryId") Long deliveryId,
			@PathVariable("flatId") Long flatId) {
		return new ResponseEntity<>(deliveryService.mapDeliveryToFlat(deliveryId, flatId), HttpStatus.OK);
	}

	// add guard to delivery
	@GetMapping("mapguardtodelivery/{deliveryId}/{guardId}")
	ResponseEntity<DeliveryEntity> mapDeliveytoguard(@PathVariable("deliveryId") Long deliveryId,
			@PathVariable("guardId") Long guardId) {
		return new ResponseEntity<>(deliveryService.mapDeliveryToGuard(deliveryId, guardId), HttpStatus.OK);
	}
	
	// add domesticHelp
		@PostMapping("/addDomesticHelp")
		ResponseEntity<Long> add(@Valid @RequestBody DomesticHelpEntity domesticHelp) {
			long domHelpEnt = domesticHelpService.add(domesticHelp);
			return new ResponseEntity<>(domHelpEnt, HttpStatus.OK);
		}

		// find DomesticHelpEntity by name
		@GetMapping("/domesticHelp/byName/{name}")
		ResponseEntity<List<DomesticHelpEntity>> getEmpByName(@PathVariable("name") String name) {
			List<DomesticHelpEntity> domHelpEnt = domesticHelpService.findByName(name);
			return new ResponseEntity<>(domHelpEnt, HttpStatus.OK);
		}

		// delete DomesticHelpEntity
		@DeleteMapping("/domesticHelp/{id}")
		ResponseEntity<DomesticHelpEntity> delete(@RequestBody DomesticHelpEntity domesticHelpEntity) {
			domesticHelpService.delete(domesticHelpEntity);
			return new ResponseEntity<>(HttpStatus.OK);
		}

		// update DomesticHelpEntity
		@PutMapping("/updateDomesticHelp")
		ResponseEntity<DomesticHelpEntity> update(@Valid @RequestBody DomesticHelpEntity domesticHelpEntity) {
			domesticHelpService.update(domesticHelpEntity);
			return new ResponseEntity<>(HttpStatus.OK);
		}

		// find DomesticHelpEntity by Id
		@GetMapping("/domesticHelp/{id}")
		ResponseEntity<DomesticHelpEntity> findByPkDomesticEntity(@PathVariable("id") int id) {
			return new ResponseEntity<>(domesticHelpService.findByPk(id), HttpStatus.OK);
		}

		// search DomesticHelpEntity
		@PostMapping("/searchDomesticHelp")
		ResponseEntity<List<DomesticHelpEntity>> search(@RequestBody DomesticHelpEntity domesticHelpEntity) {
			List<DomesticHelpEntity> domEnt = domesticHelpService.search(domesticHelpEntity);
			return new ResponseEntity<>(domEnt, HttpStatus.OK);
		}

		// search by pageNo and PageSize
		@GetMapping("domesticHelpByNoAndSize/{pageNo}/{pageSize}")
		ResponseEntity<List<DomesticHelpEntity>> search(@PathVariable("pageNo") Long pageNo,
				@PathVariable("pageSize") Integer pageSize) {
			List<DomesticHelpEntity> domEnt = domesticHelpService.search(pageNo, pageSize);
			return new ResponseEntity<>(domEnt, HttpStatus.OK);
		}

		// add guard to domesticHelp
		@GetMapping("mapguardtodomesticHelp/{domesticHelpId}/{guardId}")
		ResponseEntity<DomesticHelpEntity> mapDomesticHelptoguard(@PathVariable("domesticHelpId") Long domesticHelpId,
				@PathVariable("guardId") Long guardId) {
			return new ResponseEntity<>(domesticHelpService.mapDomesticHelpToGuard(domesticHelpId, guardId), HttpStatus.OK);
		}
}
