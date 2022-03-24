package com.example.demo.service;

import com.example.demo.bean.DomesticHelpEntity;
import com.example.demo.repository.IDomesticHelpRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class DomesticHelpServiceImpl implements IDomesticHelpService{
	@Autowired
	IDomesticHelpRepository domesticHelpRepository;
	@Override
	public long add(DomesticHelpEntity bean) {
		// TODO Auto-generated method stub
		return domesticHelpRepository.save(bean).getId();
	}

	@Override
	public void update(DomesticHelpEntity bean) {
		// TODO Auto-generated method stub
		DomesticHelpEntity domesticHelpEntity = domesticHelpRepository.findById(bean.getId());
		if(domesticHelpEntity==null)
		{
			;
		}
		domesticHelpRepository.save(bean);
		
	}

	@Override
	public void delete(DomesticHelpEntity bean) {
		// TODO Auto-generated method stub
		DomesticHelpEntity domesticHelpEntity= domesticHelpRepository.findById(bean.getId());
		domesticHelpRepository.delete(domesticHelpEntity);
	}

	@Override
	public DomesticHelpEntity findByName(String name) {
		// TODO Auto-generated method stub
		return domesticHelpRepository.findByOwnerName(name);
	}

	@Override
	public DomesticHelpEntity findByPk(long id) {
		// TODO Auto-generated method stub
		return domesticHelpRepository.findById(id);
	}

	@Override
	public List<DomesticHelpEntity> search(DomesticHelpEntity bean, long pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DomesticHelpEntity> search(DomesticHelpEntity bean) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
