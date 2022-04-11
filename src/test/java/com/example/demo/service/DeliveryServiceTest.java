package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.bean.DeliveryEntity;
@SpringBootTest
public class DeliveryServiceTest {
	@Autowired
	IDeliveryService deliveryServ;
	@Test
	@Disabled
	void addTest() throws ParseException
	{
		DeliveryEntity delivery=new DeliveryEntity();
		delivery.setId(130);
		delivery.setCreatedBy("rishitha");
		delivery.setModifiedBy("rishitha");
		delivery.setCreatedDateTime(java.sql.Timestamp.valueOf("2022-03-23 10:10:10.0"));
		delivery.setModifiedDateTime(java.sql.Timestamp.valueOf("2022-03-23 10:10:10.0"));
		delivery.setDate(new SimpleDateFormat("dd-MM-yyyy").parse("22-03-2022"));
		delivery.setOwnerName("Ramesh");
		delivery.setStatus("delivered");
		delivery.setTime("7:00 AM");
		long num=deliveryServ.add(delivery);
		assertEquals(num,delivery.getId());	
	}
	@Test
	void findByPkTest() throws ParseException
	{
		DeliveryEntity delivery=deliveryServ.findByPk(130);
		assertEquals(130,delivery.getId());
		assertEquals("rishitha",delivery.getCreatedBy());
		assertEquals("rishitha",delivery.getModifiedBy());
		assertEquals(java.sql.Timestamp.valueOf("2022-03-23 10:10:10.0"),delivery.getCreatedDateTime());
		assertEquals(java.sql.Timestamp.valueOf("2022-03-23 10:10:10.0"),delivery.getModifiedDateTime());
		assertEquals("Ramesh",delivery.getOwnerName());
		assertEquals("delivered",delivery.getStatus());
		assertEquals(new SimpleDateFormat("dd-MM-yyyy").parse("22-03-2022"),delivery.getDate());
		assertEquals("7:00 AM",delivery.getTime());
	}
	@Test
	void findByNameTest() throws ParseException
	{
		DeliveryEntity delivery=deliveryServ.findByName("Ramesh");
		assertEquals(130,delivery.getId());
		assertEquals("rishitha",delivery.getCreatedBy());
		assertEquals("rishitha",delivery.getModifiedBy());
		assertEquals(java.sql.Timestamp.valueOf("2022-03-23 10:10:10.0"),delivery.getCreatedDateTime());
		assertEquals(java.sql.Timestamp.valueOf("2022-03-23 10:10:10.0"),delivery.getModifiedDateTime());
		assertEquals("Ramesh",delivery.getOwnerName());
		assertEquals("delivered",delivery.getStatus());
		assertEquals(new SimpleDateFormat("dd-MM-yyyy").parse("22-03-2022"),delivery.getDate());
		assertEquals("7:00 AM",delivery.getTime());
	}
	

}
