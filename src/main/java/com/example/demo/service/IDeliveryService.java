package com.example.demo.service;
import java.util.List;
import com.example.demo.bean.DeliveryEntity;
public interface IDeliveryService {
public long add(DeliveryEntity bean);
	
	public void update(DeliveryEntity bean);
	
	public void delete(DeliveryEntity bean);
	
	public DeliveryEntity findByName(String name);
	
	public DeliveryEntity findByPk(long id);
	
	public List<DeliveryEntity> search(long pageNo, int pageSize);
	
	public List<DeliveryEntity> search(DeliveryEntity bean);
}
