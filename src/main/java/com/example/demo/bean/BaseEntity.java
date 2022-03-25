package com.example.demo.bean;


import java.sql.Timestamp;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import lombok.Data;


@Data
@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public  class BaseEntity  implements IDropdownList{
	
		@Id
		protected long id;
		protected String createdBy;
		protected String modifiedBy;
		protected Timestamp createdDateTime;
		protected Timestamp modifiedDateTime;
		@Override
		public String getKey() {
			return null;
		}
		@Override
		public String getValue() {
			return null;
		}
		

	}


