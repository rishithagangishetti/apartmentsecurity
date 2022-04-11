package com.cg.aps.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import com.cg.aps.entity.DomesticHelpEntity;
import com.cg.aps.repository.DomesticHelpDAOInt;
import com.cg.aps.service.DomesticHelpService;

@ExtendWith(SpringExtension.class)
public class DomesticHelpMockitoTest {
	@InjectMocks
	DomesticHelpService domesticService;
	@MockBean
	DomesticHelpDAOInt domesticHelpDAOInt;

	@BeforeEach
	void init() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void addTest() {
		DomesticHelpEntity domesticHelp = new DomesticHelpEntity();
		domesticHelp.setId(1);
		domesticHelp.setCreatedBy("rishitha");
		domesticHelp.setCreatedDateTime(java.sql.Timestamp.valueOf("2022-03-23 10:10:10.0"));
		domesticHelp.setModifiedDateTime(java.sql.Timestamp.valueOf("2022-03-23 10:10:10.0"));
		domesticHelp.setDate(java.sql.Timestamp.valueOf("2022-03-23 10:10:10.0"));
		domesticHelp.setModifiedBy("rishitha");
		domesticHelp.setArrivalTime("7:00 AM");
		domesticHelp.setDepartureTime("11:00 AM");
		domesticHelp.setHelpType("electricity");
		Mockito.when(domesticHelpDAOInt.save(domesticHelp)).thenReturn(domesticHelp);
		long num = domesticService.add(domesticHelp);
		assertEquals(1, num);
	}

	@Test
	void updateTest() {
		DomesticHelpEntity domesticHelp = new DomesticHelpEntity();
		domesticHelp.setId(1);
		domesticHelp.setCreatedBy("rishitha");
		domesticHelp.setCreatedDateTime(java.sql.Timestamp.valueOf("2022-03-23 10:10:10.0"));
		domesticHelp.setModifiedDateTime(java.sql.Timestamp.valueOf("2022-03-23 10:10:10.0"));
		domesticHelp.setDate(java.sql.Timestamp.valueOf("2022-03-23 10:10:10.0"));
		domesticHelp.setModifiedBy("rishitha");
		domesticHelp.setName("Ravi");
		domesticHelp.setArrivalTime("7:00 AM");
		domesticHelp.setDepartureTime("11:00 AM");
		domesticHelp.setHelpType("gardenini");
		Mockito.when(domesticHelpDAOInt.findById((long) 1)).thenReturn(Optional.of(domesticHelp));
		Mockito.when(domesticHelpDAOInt.save(domesticHelp)).thenReturn(domesticHelp);
		domesticService.update(domesticHelp);
		assertEquals("Ravi", domesticHelp.getName());
	}

	@Test
	void findByNameTest() {
		List<DomesticHelpEntity> domesticHelpList=new ArrayList<>();
		DomesticHelpEntity domesticHelp = new DomesticHelpEntity();
		domesticHelp.setId(1);
		domesticHelp.setCreatedBy("rishitha");
		domesticHelp.setCreatedDateTime(java.sql.Timestamp.valueOf("2022-03-23 10:10:10.0"));
		domesticHelp.setModifiedDateTime(java.sql.Timestamp.valueOf("2022-03-23 10:10:10.0"));
		domesticHelp.setDate(java.sql.Timestamp.valueOf("2022-03-23 10:10:10.0"));
		domesticHelp.setModifiedBy("rishitha");
		domesticHelp.setName("Ramesh");
		domesticHelp.setArrivalTime("7:00 AM");
		domesticHelp.setDepartureTime("11:00 AM");
		domesticHelp.setHelpType("electricity");
		domesticHelpList.add(domesticHelp);
		Mockito.when(domesticHelpDAOInt.findByName("Ramesh")).thenReturn(domesticHelpList);
		List<DomesticHelpEntity> domEnt = domesticService.findByName("Ramesh");
		assertEquals(1, domEnt.size());
		
	}

	@Test
	void findByPkTest() {
		DomesticHelpEntity domesticHelp = new DomesticHelpEntity();
		domesticHelp.setId(1);
		domesticHelp.setCreatedBy("rishitha");
		domesticHelp.setCreatedDateTime(java.sql.Timestamp.valueOf("2022-03-23 10:10:10.0"));
		domesticHelp.setModifiedDateTime(java.sql.Timestamp.valueOf("2022-03-23 10:10:10.0"));
		domesticHelp.setDate(java.sql.Timestamp.valueOf("2022-03-23 10:10:10.0"));
		domesticHelp.setModifiedBy("rishitha");
		domesticHelp.setArrivalTime("7:00 AM");
		domesticHelp.setDepartureTime("11:00 AM");
		domesticHelp.setHelpType("electricity");
		Mockito.when(domesticHelpDAOInt.findById((long) 1)).thenReturn(Optional.of(domesticHelp));
		DomesticHelpEntity delEnt = domesticService.findByPk(1);
		assertEquals(1, delEnt.getId());
		assertEquals("rishitha", delEnt.getCreatedBy());
		assertEquals("rishitha", delEnt.getModifiedBy());
		assertEquals("electricity", delEnt.getHelpType());
	}

	@Test
	void deleteTest() {
		DomesticHelpEntity domesticHelp = new DomesticHelpEntity();
		domesticHelp.setId(1);
		domesticHelp.setCreatedBy("rishitha");
		domesticHelp.setCreatedDateTime(java.sql.Timestamp.valueOf("2022-03-23 10:10:10.0"));
		domesticHelp.setModifiedDateTime(java.sql.Timestamp.valueOf("2022-03-23 10:10:10.0"));
		domesticHelp.setDate(java.sql.Timestamp.valueOf("2022-03-23 10:10:10.0"));
		domesticHelp.setModifiedBy("rishitha");
		domesticHelp.setArrivalTime("7:00 AM");
		domesticHelp.setDepartureTime("11:00 AM");
		domesticHelp.setHelpType("gardening");
		Mockito.when(domesticHelpDAOInt.findById((long) 1)).thenReturn(Optional.of(domesticHelp));
		Mockito.doNothing().when(domesticHelpDAOInt).delete(domesticHelp);
		domesticService.delete(domesticHelp);

	}

}
