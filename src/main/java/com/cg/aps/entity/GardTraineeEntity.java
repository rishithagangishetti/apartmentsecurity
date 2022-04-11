package com.cg.aps.entity;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class GardTraineeEntity extends BaseEntity {

	@Positive(message = "Id can not be less than or equal to zero")
	private long userId;
	@NotBlank(message = "Gard name should not be emplty")
	private String name;
	@Size(min = 10, max = 10, message = "enter a valid mobileNo number")
	private String mobileNo;
	@NotBlank(message = "Status need to be updated")
	private String status;
	private String timeing;
	private Date date;

	// relationship between delivery and guardTrainee
	@JsonIgnore
	@OneToMany(mappedBy = "guardTrainee", cascade = CascadeType.MERGE)
	private List<DeliveryEntity> deliveryList;

	// relationship between domesticHelp and guardTrainee
	@JsonIgnore
	@OneToMany(mappedBy = "guardTrainee", cascade = CascadeType.MERGE)
	private List<DomesticHelpEntity> domesticHelpList;

}
