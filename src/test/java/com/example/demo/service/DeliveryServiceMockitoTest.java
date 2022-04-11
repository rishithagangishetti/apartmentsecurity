package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.demo.bean.DeliveryEntity;
import com.example.demo.repository.IDeliveryRepository;

@ExtendWith(SpringExtension.class)
public class DeliveryServiceMockitoTest {
	@InjectMocks
	DeliveryServiceImpl delService;
	@MockBean
	IDeliveryRepository delRepo;
	@BeforeEach
	void init()
	{
		MockitoAnnotations.openMocks(this);
	}
	@Test
	void addDeliveryTest() throws ParseException
	{
		DeliveryEntity delivery=new DeliveryEntity();
		delivery.setId(1);
		delivery.setCreatedBy("rishitha");
		delivery.setCreatedDateTime(java.sql.Timestamp.valueOf("2022-03-23 10:10:10.0"));
		delivery.setModifiedDateTime(java.sql.Timestamp.valueOf("2022-03-23 10:10:10.0"));
		delivery.setDate(new SimpleDateFormat("dd-MM-yyyy").parse("22-03-2022"));
		delivery.setModifiedBy("rishitha");
		delivery.setOwnerName("Ramesh");
		delivery.setStatus("delivered");
		delivery.setTime("7:00 AM");
		Mockito.when(delRepo.save(delivery)).thenReturn(delivery);
		long num=delService.add(delivery);
		assertEquals(1,num);	
	}
	@Test
	void updateDeliveryTest() throws ParseException
	{
		DeliveryEntity delivery=new DeliveryEntity();
		delivery.setId(1);
		delivery.setCreatedBy("rishitha");
		delivery.setCreatedDateTime(java.sql.Timestamp.valueOf("2022-03-23 10:10:10.0"));
		delivery.setModifiedDateTime(java.sql.Timestamp.valueOf("2022-03-23 10:10:10.0"));
		delivery.setDate(new SimpleDateFormat("dd-MM-yyyy").parse("22-03-2022"));
		delivery.setModifiedBy("rishitha");
		delivery.setOwnerName("Ramesh");
		delivery.setStatus("delivered");
		delivery.setTime("7:00 AM");
		Mockito.when(delRepo.findById((long) 1)).thenReturn(Optional.of(delivery));
		Mockito.when(delRepo.save(delivery)).thenReturn(delivery);
		delService.update(delivery);
		assertEquals("Ramesh",delivery.getOwnerName());	
	}
	@Test
	void findByNameTest() throws ParseException
	{
		DeliveryEntity delivery=new DeliveryEntity();
		delivery.setId(1);
		delivery.setCreatedBy("rishitha");
		delivery.setCreatedDateTime(java.sql.Timestamp.valueOf("2022-03-23 10:10:10.0"));
		delivery.setModifiedDateTime(java.sql.Timestamp.valueOf("2022-03-23 10:10:10.0"));
		delivery.setDate(new SimpleDateFormat("dd-MM-yyyy").parse("22-03-2022"));
		delivery.setModifiedBy("rishitha");
		delivery.setOwnerName("Ramesh");
		delivery.setStatus("delivered");
		delivery.setTime("7:00 AM");
		Mockito.when(delRepo.findByownerName("Ramesh")).thenReturn(delivery);
		DeliveryEntity delEnt=delService.findByName("Ramesh");
		assertEquals("Ramesh",delEnt.getOwnerName());
	}
	@Test
	void findByPkTest() throws ParseException
	{
		DeliveryEntity delivery=new DeliveryEntity();
		delivery.setId(1);
		delivery.setCreatedBy("rishitha");
		delivery.setCreatedDateTime(java.sql.Timestamp.valueOf("2022-03-23 10:10:10.0"));
		delivery.setModifiedDateTime(java.sql.Timestamp.valueOf("2022-03-23 10:10:10.0"));
		delivery.setDate(new SimpleDateFormat("dd-MM-yyyy").parse("22-03-2022"));
		delivery.setModifiedBy("rishitha");
		delivery.setOwnerName("Ramesh");
		delivery.setStatus("delivered");
		delivery.setTime("7:00 AM");
		Mockito.when(delRepo.findById((long) 1)).thenReturn(Optional.of(delivery));
		DeliveryEntity delEnt=delService.findByPk(1);
		assertEquals(1,delEnt.getId());
		assertEquals("rishitha",delEnt.getCreatedBy());
		assertEquals("rishitha",delEnt.getModifiedBy());
		assertEquals("Ramesh",delEnt.getOwnerName());
		assertEquals("delivered",delEnt.getStatus());
		assertEquals("7:00 AM",delEnt.getTime());
	}
	@Test
	void searchTest()
	{
		
	}
	
	

}
