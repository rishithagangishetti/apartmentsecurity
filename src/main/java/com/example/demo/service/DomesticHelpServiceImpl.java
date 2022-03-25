package com.example.demo.service;

import com.example.demo.bean.DomesticHelpEntity;
import com.example.demo.exception.DuplicateRecordException;
import com.example.demo.exception.RecordNotFoundException;
import com.example.demo.repository.IDomesticHelpRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
@Service
public class DomesticHelpServiceImpl implements IDomesticHelpService{
	@Autowired
	IDomesticHelpRepository domesticHelpRepository;
	
	@Override
	public long add(DomesticHelpEntity bean) {
		Optional<DomesticHelpEntity> a=domesticHelpRepository.findById(bean.getId());
		if(a.isPresent())
		{
			throw new DuplicateRecordException("Record is present");
		}
		
		return domesticHelpRepository.save(bean).getId();
	}

	@Override
	public void update(DomesticHelpEntity bean) {
		Optional<DomesticHelpEntity> domesticHelpEntity = domesticHelpRepository.findById(bean.getId());
		if(!domesticHelpEntity.isPresent())
		{
			throw new RecordNotFoundException("Record Not Present");
		}
		domesticHelpRepository.save(bean);
		
	}

	@Override
	public void delete(DomesticHelpEntity bean) {
		Optional<DomesticHelpEntity> domesticHelpEntity= domesticHelpRepository.findById(bean.getId());
		if(!domesticHelpEntity.isPresent())
		{
			throw new RecordNotFoundException("Record Not Present");
		}
		domesticHelpRepository.delete(domesticHelpEntity.get());
	}

	@Override
	public DomesticHelpEntity findByName(String name) {
		return domesticHelpRepository.findByOwnerName(name);
	}

	@Override
	public DomesticHelpEntity findByPk(long id) {
		Optional<DomesticHelpEntity> domestichelpEntity=domesticHelpRepository.findById(id);
		if(! domestichelpEntity.isPresent())
		{
			throw new RecordNotFoundException("Record Not Present");
		}
		return  domestichelpEntity.get();
	}

	@Override
	public List<DomesticHelpEntity> search(long pageNo, int pageSize) {
		PageRequest paging=PageRequest.of((int) pageNo, pageSize);
		Page<DomesticHelpEntity> res=domesticHelpRepository.findAll(paging);
		if(res.hasContent())
		{
			return res.getContent();
		}
		else
		{
			throw new RecordNotFoundException("No records Found");
		}	
		
	}

	@Override
	public List<DomesticHelpEntity> search(DomesticHelpEntity bean) {
		Optional<DomesticHelpEntity> domesticHelpEntity = domesticHelpRepository.findById(bean.getId());
		if(!domesticHelpEntity.isPresent())
		{
			throw new RecordNotFoundException("Record Not Found");
		}
		List<DomesticHelpEntity> d = new ArrayList<>();
		d.add(this.findByPk(bean.getId()));
		return d;
	}

	

}
