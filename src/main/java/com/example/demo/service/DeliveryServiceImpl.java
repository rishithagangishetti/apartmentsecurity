package com.example.demo.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.demo.bean.DeliveryEntity;
import com.example.demo.repository.IDeliveryRepository;
import org.springframework.beans.factory.annotation.Autowired;
@Service
public class DeliveryServiceImpl implements IDeliveryService{
	@Autowired
	IDeliveryRepository deliveryRepository;
	@Override
	public long add(DeliveryEntity bean) {
		// TODO Auto-generated method stub
		return deliveryRepository.save(bean).getId();	
	}

	@Override
	public void update(DeliveryEntity bean) {
		// TODO Auto-generated method stub
		DeliveryEntity deliveryEntity = deliveryRepository.findById(bean.getId());
		if(deliveryEntity==null)
		{
			;
		}
		deliveryRepository.save(bean);
		
	}

	@Override
	public void delete(DeliveryEntity bean) {
		// TODO Auto-generated method stub
		DeliveryEntity deliveryEntity = deliveryRepository.findById(bean.getId());
		deliveryRepository.delete(deliveryEntity);
		
	}

	@Override
	public DeliveryEntity findByName(String name) {
		// TODO Auto-generated method stub
		
		return deliveryRepository.findByownerName(name);
	}

	@Override
	public DeliveryEntity findByPk(long id) {
		// TODO Auto-generated method stub
		return deliveryRepository.findById(id);
	}

	@Override
	public List<DeliveryEntity> search(DeliveryEntity bean, long pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DeliveryEntity> search(DeliveryEntity bean) {
		// TODO Auto-generated method stub
		return null;
	}

}
