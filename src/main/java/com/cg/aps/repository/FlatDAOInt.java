package com.cg.aps.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.aps.entity.DomesticHelpEntity;
import com.cg.aps.entity.FlatEntity;


@Repository
public interface FlatDAOInt extends JpaRepository<FlatEntity, Long>
{
	
	
}
