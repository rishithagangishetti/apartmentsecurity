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
		DeliveryEntity d=new DeliveryEntity();
		d.setId(1);
		d.setCreatedBy("rishitha");
		d.setCreatedDateTime(java.sql.Timestamp.valueOf("2007-09-23 10:10:10.0"));
		d.setModifiedDateTime(java.sql.Timestamp.valueOf("2007-09-23 10:10:10.0"));
		d.setDate(new SimpleDateFormat("dd-MM-yyyy").parse("22-03-2022"));
		d.setModifiedBy("rishitha");
		d.setOwnerName("Rahul");
		d.setStatus("delivered");
		d.setTime("7:00 AM");
		Mockito.when(delRepo.save(d)).thenReturn(d);
		long delivery=delService.add(d);
		assertEquals(1,delivery);	
	}
	@Test
	void updateDeliveryTest() throws ParseException
	{
		DeliveryEntity d=new DeliveryEntity();
		d.setId(1);
		d.setCreatedBy("rishitha");
		d.setCreatedDateTime(java.sql.Timestamp.valueOf("2007-09-23 10:10:10.0"));
		d.setModifiedDateTime(java.sql.Timestamp.valueOf("2007-09-23 10:10:10.0"));
		d.setDate(new SimpleDateFormat("dd-MM-yyyy").parse("22-03-2022"));
		d.setModifiedBy("rishitha");
		d.setOwnerName("Ramesh");
		d.setStatus("delivered");
		d.setTime("7:00 AM");
		Mockito.when(delRepo.findById((long) 1)).thenReturn(Optional.of(d));
		Mockito.when(delRepo.save(d)).thenReturn(d);
		delService.update(d);
		assertEquals("Ramesh",d.getOwnerName());	
	}
	@Test
	void findByNameTest() throws ParseException
	{
		DeliveryEntity d=new DeliveryEntity();
		d.setId(1);
		d.setCreatedBy("rishitha");
		d.setCreatedDateTime(java.sql.Timestamp.valueOf("2007-09-23 10:10:10.0"));
		d.setModifiedDateTime(java.sql.Timestamp.valueOf("2007-09-23 10:10:10.0"));
		d.setDate(new SimpleDateFormat("dd-MM-yyyy").parse("22-03-2022"));
		d.setModifiedBy("rishitha");
		d.setOwnerName("Ramesh");
		d.setStatus("delivered");
		d.setTime("7:00 AM");
		Mockito.when(delRepo.findByownerName("Ramesh")).thenReturn(d);
		DeliveryEntity delEnt=delService.findByName("Ramesh");
		assertEquals("Ramesh",delEnt.getOwnerName());
	}
	@Test
	void findByPkTest() throws ParseException
	{
		DeliveryEntity d=new DeliveryEntity();
		d.setId(1);
		d.setCreatedBy("rishitha");
		d.setCreatedDateTime(java.sql.Timestamp.valueOf("2022-03-23 10:10:10.0"));
		d.setModifiedDateTime(java.sql.Timestamp.valueOf("2022-03-23 10:10:10.0"));
		d.setDate(new SimpleDateFormat("dd-MM-yyyy").parse("22-03-2022"));
		d.setModifiedBy("rishitha");
		d.setOwnerName("Ramesh");
		d.setStatus("delivered");
		d.setTime("7:00 AM");
		Mockito.when(delRepo.findById((long) 1)).thenReturn(Optional.of(d));
		DeliveryEntity delEnt=delService.findByPk(1);
		assertEquals(1,delEnt.getId());
	}
	@Test
	void searchTest()
	{
		
	}
	
	

}
