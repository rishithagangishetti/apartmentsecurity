package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.bean.DomesticHelpEntity;
@Repository
public interface IDomesticHelpRepository extends JpaRepository<DomesticHelpEntity, Long>{
	public DomesticHelpEntity findByOwnerName(String name);
	
}
