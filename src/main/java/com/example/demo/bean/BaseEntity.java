package com.example.demo.bean;


import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;


import lombok.Data;
import lombok.Generated;

@Data
@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class BaseEntity  implements IDropdownList{
	
		@Id
		@GeneratedValue
		protected long id;
		protected String createdBy;
		protected String modifiedBy;
		protected Timestamp createdDateTime;
		protected Timestamp modifiedDateTime;
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


