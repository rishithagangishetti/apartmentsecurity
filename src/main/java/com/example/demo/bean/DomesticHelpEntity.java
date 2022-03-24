/**
 * 
 */
package com.example.demo.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author grishith
 *
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DomesticHelpEntity extends BaseEntity{
	private String flatNo;
	private String ownerName;
	private String name;
	private String helpType;
	private String arrivalTime;
	private String departureTime;
	private String date;
	@Override
	public String getKey() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return null;
	}

}
