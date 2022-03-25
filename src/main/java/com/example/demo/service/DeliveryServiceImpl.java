package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.example.demo.bean.DeliveryEntity;
import com.example.demo.exception.DuplicateRecordException;
import com.example.demo.exception.RecordNotFoundException;
import com.example.demo.repository.IDeliveryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
@Service
public class DeliveryServiceImpl implements IDeliveryService{
	@Autowired
	IDeliveryRepository deliveryRepository;
	
	@Override
	public long add(DeliveryEntity bean) {
		Optional<DeliveryEntity> a=deliveryRepository.findById(bean.getId());
		if(a.isPresent())
		{
			throw new DuplicateRecordException("Record is present");
		}
		DeliveryEntity de=deliveryRepository.save(bean);
		return de.getId();	
	}

	@Override
	public void update(DeliveryEntity bean)  {
		
		Optional<DeliveryEntity> deliveryEntity = deliveryRepository.findById(bean.getId());
		if(!deliveryEntity.isPresent())
		{
			throw new RecordNotFoundException("Record Not Present");
		}
		deliveryRepository.save(bean);
		
	}

	@Override
	public void delete(DeliveryEntity bean) {
		Optional<DeliveryEntity> deliveryEntity = deliveryRepository.findById(bean.getId());
		if(!deliveryEntity.isPresent())
		{
			throw new RecordNotFoundException("Record Not Present");
		}
		deliveryRepository.delete(deliveryEntity.get());	
	}

	@Override
	public DeliveryEntity findByName(String name) {
		return deliveryRepository.findByownerName(name);
	}
	
	@Override
	public DeliveryEntity findByPk(long id) {
		Optional<DeliveryEntity> deliveryEntity=deliveryRepository.findById(id);
		if(!deliveryEntity.isPresent())
		{
			throw new RecordNotFoundException("Record Not Present");
		}
		return deliveryEntity.get();
	}

	@Override
	public List<DeliveryEntity> search(long pageNo, int pageSize) {
		PageRequest paging=PageRequest.of((int) pageNo, pageSize);
		Page<DeliveryEntity> res=deliveryRepository.findAll(paging);
		if(res.hasContent())
		{
			return res.getContent();
		}
		else
		{
			throw new RecordNotFoundException("No records Found");
		}	
	}
	@Override
	public List<DeliveryEntity> search(DeliveryEntity bean) {
		Optional<DeliveryEntity> deliveryEntity = deliveryRepository.findById(bean.getId());
		if(!deliveryEntity.isPresent())
		{
			throw new RecordNotFoundException("Record Not Found");
		}
		List<DeliveryEntity> d = new ArrayList<>();
		d.add(this.findByPk(bean.getId()));
		return d;
	}

}
