package com.cg.aps.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.cg.aps.entity.DeliveryEntity;
import com.cg.aps.entity.FlatEntity;
import com.cg.aps.entity.GardTraineeEntity;
import com.cg.aps.exception.DuplicateRecordException;
import com.cg.aps.exception.RecordNotFoundException;
import com.cg.aps.repository.DeliveryDAOInt;
//import com.cg.aps.repository.FlatDAOInt;
//import com.cg.aps.repository.GardTraineeDAOInt;
import com.cg.aps.repository.FlatDAOInt;
import com.cg.aps.repository.GardTraineeDAOInt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

@Service
public class DeliveryService implements DeliveryServiceInt {
	@Autowired
	DeliveryDAOInt deliveryDAOInt;
	@Autowired
	FlatDAOInt flatDAOInt;
	@Autowired
	GardTraineeDAOInt gardDAOInt;

	@Override
	public long add(DeliveryEntity bean) {
		Optional<DeliveryEntity> a = deliveryDAOInt.findById(bean.getId());
		if (a.isPresent()) {
			throw new DuplicateRecordException("Record is alreay present with id " + bean.getId());
		}
		DeliveryEntity de = deliveryDAOInt.save(bean);
		return de.getId();
	}

	@Override
	public void update(DeliveryEntity bean) {

		Optional<DeliveryEntity> deliveryEntity = deliveryDAOInt.findById(bean.getId());
		if (!deliveryEntity.isPresent()) {
			throw new RecordNotFoundException("Record Not Found with id " + bean.getId());
		}
		deliveryDAOInt.save(bean);

	}

	@Override
	public void delete(DeliveryEntity bean) {
		Optional<DeliveryEntity> deliveryEntity = deliveryDAOInt.findById(bean.getId());
		if (!deliveryEntity.isPresent()) {
			throw new RecordNotFoundException("Record Not Found with id " + bean.getId());
		}
		deliveryDAOInt.delete(deliveryEntity.get());
	}

	@Override
	public List<DeliveryEntity> findByName(String name) {
		List<DeliveryEntity> deliveryEntity = deliveryDAOInt.findByOwnerName(name);
		if (deliveryEntity == null) {
			throw new RecordNotFoundException("Record Not Found with Name " + name);
		}

		return deliveryEntity;
	}

	@Override
	public DeliveryEntity findByPk(long id) {
		Optional<DeliveryEntity> deliveryEntity = deliveryDAOInt.findById(id);
		if (!deliveryEntity.isPresent()) {
			throw new RecordNotFoundException("Record Not Found with id " + id);
		}
		return deliveryEntity.get();
	}

	@Override
	public List<DeliveryEntity> search(long pageNo, int pageSize) {
		PageRequest paging = PageRequest.of((int) pageNo, pageSize);
		Page<DeliveryEntity> res = deliveryDAOInt.findAll(paging);
		if (res.hasContent()) {
			return res.getContent();
		} else {
			throw new RecordNotFoundException("Record Not Found");
		}
	}

	@Override
	public List<DeliveryEntity> search(DeliveryEntity bean) {
		Optional<DeliveryEntity> deliveryEntity = deliveryDAOInt.findById(bean.getId());
		if (!deliveryEntity.isPresent()) {
			throw new RecordNotFoundException("Record Not Found with id " + bean.getId());
		}
		List<DeliveryEntity> d = new ArrayList<>();
		d.add(this.findByPk(bean.getId()));
		return d;
	}

	@Override
	public List<DeliveryEntity> getDeliveryListByFlatId(long id) {
		return deliveryDAOInt.getDeliveriesOfFlat(id);

	}

	@Override
	public DeliveryEntity mapDeliveryToFlat(long deliveryPk, long flatPk) {
		Optional<DeliveryEntity> optDeliverEntity = deliveryDAOInt.findById(deliveryPk);
		Optional<FlatEntity> optFlatEntity = flatDAOInt.findById(flatPk);
		if (!optDeliverEntity.isPresent() || !optFlatEntity.isPresent()) {
			throw new RecordNotFoundException("Record Not Found with ids");
		}
		DeliveryEntity delivery = optDeliverEntity.get();
		FlatEntity flat = optFlatEntity.get();
		delivery.setFlat(flat);
		deliveryDAOInt.save(delivery);
		return delivery;

	}

	

	@Override
	public DeliveryEntity mapDeliveryToGuard(long deliveryPk, long guardPk) {
		Optional<DeliveryEntity> optDeliverEntity = deliveryDAOInt.findById(deliveryPk);
		Optional<GardTraineeEntity> optGardEntity = gardDAOInt.findById(guardPk);
		if (!optDeliverEntity.isPresent() || !optGardEntity.isPresent()) {
			throw new RecordNotFoundException("Record Not Found with ids");
		}
		DeliveryEntity delivery = optDeliverEntity.get();
		GardTraineeEntity guardTrainee = optGardEntity.get();
		delivery.setGuardTrainee(guardTrainee);
		deliveryDAOInt.save(delivery);
		return delivery;
	}

	@Override
	public List<DeliveryEntity> getDeliveryListByGuardId(long id) {
		return deliveryDAOInt.getDeliveryListByGuardId(id);
	}

	
}
