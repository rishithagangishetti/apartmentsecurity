package com.example.demo.service;

import java.util.List;

import com.example.demo.bean.DomesticHelpEntity;

public interface IDomesticHelpService {

	public long add(DomesticHelpEntity bean);
	
	public void update(DomesticHelpEntity bean);
	
	public void delete(DomesticHelpEntity bean);
	
	public DomesticHelpEntity findByName(String name);
	
	public DomesticHelpEntity findByPk(long id);
	
	public List<DomesticHelpEntity> search(long pageNo, int pageSize);
	
	public List<DomesticHelpEntity> search(DomesticHelpEntity bean);
	
}
