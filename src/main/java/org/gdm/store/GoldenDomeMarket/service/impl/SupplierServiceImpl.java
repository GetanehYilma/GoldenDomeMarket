package org.gdm.store.GoldenDomeMarket.service.impl;

import java.util.List;

import org.gdm.store.GoldenDomeMarket.model.Supplier;
import org.gdm.store.GoldenDomeMarket.repository.SupplierRepository;
import org.gdm.store.GoldenDomeMarket.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
public class SupplierServiceImpl implements SupplierService {
	@Autowired
	private SupplierRepository supplierRepository;

	@Override
	public List<Supplier> getAllSuppliers() {		
		return supplierRepository.findAll();
	}
	
	@Override
    public Page<Supplier> getAllSuppliers(int pageNo) {
        return supplierRepository.findAll(PageRequest.of(pageNo, 5, Sort.by("name")));
    }

}
