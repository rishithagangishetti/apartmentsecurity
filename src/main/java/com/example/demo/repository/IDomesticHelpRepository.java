package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.bean.DomesticHelpEntity;
@Repository
public interface IDomesticHelpRepository extends JpaRepository<DomesticHelpEntity, Integer>{
	public DomesticHelpEntity findById(long id);
	public DomesticHelpEntity findByOwnerName(String name);
	
}
