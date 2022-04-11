package com.cg.aps.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data

public class FlatEntity extends BaseEntity {

	private String ownerName;
	private String flatNo;
	private String floorNo;
	private String flatType;
	@JsonIgnore
	@OneToMany(mappedBy = "flat",cascade = CascadeType.MERGE)
	private List<DeliveryEntity> deliveries;
	
	@ManyToOne(cascade=CascadeType.MERGE)
	@JsonIgnore
	@JoinColumn(name = "domestic_help_id", referencedColumnName = "id")
	private DomesticHelpEntity domesticHelpList;
	
	
}
